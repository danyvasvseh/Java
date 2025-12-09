
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Реализация алгоритма кодирования и декодирования файлов
 * по алгоритму Хаффмана. 
 *
 * <p>Формат архивного файла:</p>
 * <pre>
 * [3 бита]  количество незначащих нулей в конце
 * [N байт]   дерево (N = число символов + количество вершин/8)
 * [M байт]   закодированные данные
 * </pre>
 *
 * <p>Использование из командной строки:</p>
 * <pre>
 * 1) Кодировать файл
 * 2) Декодировать файл
 * 3) Выход
 * </pre>
 */
public class Huffman {

    private static class Node implements Comparable<Node> {
        byte value;
        int freq;
        Node left, right;

        Node(byte value, int freq) { this.value = value; this.freq = freq; }
        Node(Node left, Node right) {
            this.left = left;
            this.right = right;
            this.freq = left.freq + right.freq;
        }

        boolean isLeaf() { return left == null && right == null; }

        @Override
        public int compareTo(Node o) {
            int cmp = Integer.compare(this.freq, o.freq);
            if (cmp != 0) return cmp;
            return Boolean.compare(this.isLeaf(), o.isLeaf());
        }
    }

// это нам придётся ввести, чтобы удобно записывать/читать фацлы
    private static class BitOutputStream implements Closeable {
        private final OutputStream out;
        private int currentByte = 0;
        private int numBits = 0;

        BitOutputStream(OutputStream out) { this.out = out; }

        void writeBit(int bit) throws IOException {
            currentByte = (currentByte << 1) | bit;
            numBits++;
            if (numBits == 8) {
                out.write(currentByte);
                currentByte = 0;
                numBits = 0;
            }
        }

        void writeByte(byte b) throws IOException {
            for (int i = 7; i >= 0; i--) writeBit((b >>> i) & 1); // извлекаем i-ый бит
        }

        @Override
        public void close() throws IOException {
            while (numBits > 0 && numBits < 8) {
                writeBit(0); // Добиваем нулями
            }
            out.close();
        }
    }
    
    private static class BitInputStream implements Closeable {
        private final InputStream in;
        private int currentByte = 0;
        private int numBitsLeft = 0;
        private long totalBitsRead = 0; // счётчик

        BitInputStream(InputStream in) { this.in = in; }

        int readBit() throws IOException {
            if (numBitsLeft == 0) {
                currentByte = in.read();
                if (currentByte == -1) throw new EOFException("Встретился неожиданный конец файла");
                numBitsLeft = 8;
            } 
            numBitsLeft--;
            totalBitsRead++;
            return (currentByte >>> numBitsLeft) & 1;
        }

        int readByte() throws IOException {
            int val = 0;
            for (int i = 0; i < 8; i++) val = (val << 1) | readBit();
            return val;
        }
        
        long getBitsRead() { return totalBitsRead; }

        @Override
        public void close() throws IOException { in.close(); }
    }

//сами функции алгоритма алгоритм 
    private static Node buildTree(int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < freq.length; i++)
            if (freq[i] > 0) pq.add(new Node((byte) i, freq[i]));

        if (pq.isEmpty()) return null;
        if (pq.size() == 1) {
            return new Node(pq.poll(), new Node((byte)0, 0));
        }

        while (pq.size() > 1) {
            pq.add(new Node(pq.poll(), pq.poll()));
        }
        return pq.poll();
    }

    private static String[] buildCodeTable(Node root) {
        String[] table = new String[256];
        buildCodeTable(root, "", table);
        return table;
    }

    private static void buildCodeTable(Node node, String prefix, String[] table) {
        if (node == null) return;
        if (node.isLeaf()) {
            table[node.value & 0xFF] = prefix.isEmpty() ? "0" : prefix;
        } else {
            buildCodeTable(node.left, prefix + "0", table);
            buildCodeTable(node.right, prefix + "1", table);
        }
    }
    
    
    private static long calculateTreeSize(Node node) {
        if (node.isLeaf()) {
            return 1 + 8; // 1 бит (флаг листа) + 8 бит (значение)
        } else {
            return 1 + calculateTreeSize(node.left) + calculateTreeSize(node.right);
        }
    }


    // у Хаффмана каждый не лист имеет 2 сына, следовательно можно кодировать за p бит
    private static void writeTree(Node node, BitOutputStream out) throws IOException {
        if (node.isLeaf()) {
            out.writeBit(1);
            out.writeByte(node.value);
        } else {
            out.writeBit(0);
            writeTree(node.left, out);
            writeTree(node.right, out);
        }
    }

    private static Node readTree(BitInputStream in) throws IOException {
        int bit = in.readBit();
        if (bit == 1) {
            return new Node((byte) in.readByte(), 0);
        } else {
            return new Node(readTree(in), readTree(in));
        }
    }

    /**
     * Кодирует произвольный файл методом Хаффмана.
     * Результатом - файл со встроенным деревом.
     *
     * <p>Этапы работы:</p>
     * <ol>
     *     <li>Чтение всех байтов файла</li>
     *     <li>Подсчёт частот символов</li>
     *     <li>Построение дерева Хаффмана</li>
     *     <li>Побитовая запись дерева</li>
     *     <li>Побитовое кодирование данных</li>
     *     <li>Запись служебных данных + дерева + кодированного массива</li>
     * </ol>
     *
     * @param inputFile путь к исходному файлу
     * @param outputFile путь к файлу записи
     * @throws IOException при ошибках чтения/записи
     */
    public static void encode(String inputFile, String outputFile) throws IOException {
        byte[] data = Files.readAllBytes(Paths.get(inputFile));
        if (data.length == 0) {
            // Пустой файл -> создаем пустой файл
            new FileOutputStream(outputFile).close();
            System.out.println("Пустой файл закодирован.");
            return;
        }

        int[] freq = new int[256];
        for (byte b : data) freq[b & 0xFF]++; // корректный перевод byte в int

        Node root = buildTree(freq);
        String[] codes = buildCodeTable(root);

        long totalBits = 3; 
        totalBits += calculateTreeSize(root);
        long dataBits = 0;

        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                dataBits += (long) freq[i] * codes[i].length();
            }
        }
        totalBits += dataBits;

        // Вычисляем сколько бит не хватает до полного байта
        byte padding = (byte) ((8 - (totalBits % 8)));
        
        try (FileOutputStream fos = new FileOutputStream(outputFile);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             BitOutputStream bitOut = new BitOutputStream(bos)) {

            // Пишем 3 бита padding info
            for (int i = 2; i >= 0; i--) {
                bitOut.writeBit((padding >>> i) & 1);
            }

            writeTree(root, bitOut);

            for (byte b : data) {
                String code = codes[b & 0xFF];
                for (int i = 0; i < code.length(); i++) {
                    bitOut.writeBit(code.charAt(i) == '1' ? 1 : 0);
                }
            }
           
        }
        System.out.println("Файл закодирован: " + outputFile);
    }

        /**
     * Декодирует ранее созданный архив Хаффмана.
     *
     * <p>Этапы работы:</p>
     * <ol>
     *     <li>Чтение служебных данных (длина исходного файла, длина дерева, биты дерева)</li>
     *     <li>Десериализация дерева побитно</li>
     *     <li>Пошаговое восстановление символов по коду</li>
     *     <li>Запись результата в выходной файл</li>
     * </ol>
     *
     * @param inputFile закодированный файл 
     * @param outputFile путь для сохранения декодированного оригинала
     * @throws IOException при повреждённом архиве или ошибках I/O
     */
    

    public static void decode(String inputFile, String outputFile) throws IOException {
        File inFile = new File(inputFile);
        if (inFile.length() == 0) {
            new FileOutputStream(outputFile).close();
            System.out.println("Пустой файл декодирован.");
            return;
        }
        
        long fileSizeBits = inFile.length() * 8;

        try (FileInputStream fis = new FileInputStream(inFile);
             BufferedInputStream bis = new BufferedInputStream(fis);
             BitInputStream bitIn = new BitInputStream(bis);
             FileOutputStream fos = new FileOutputStream(outputFile);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            int padding = 0;
            for (int i = 0; i < 3; i++) {
                padding = (padding << 1) | bitIn.readBit();
            }

           
            long totalValidBits = fileSizeBits - padding;

            Node root = readTree(bitIn);

            while (bitIn.getBitsRead() < totalValidBits) {
                Node cur = root;
                while (!cur.isLeaf()) {
                    // Проверка на случай битого файла, чтобы не зависнуть
                    if (bitIn.getBitsRead() >= totalValidBits) {
                        System.out.println("Всё плохо файл битый");
                         break; 
                    }
                    int bit = bitIn.readBit();
                    cur = (bit == 0) ? cur.left : cur.right;
                }
                if (cur.isLeaf()) {
                    bos.write(cur.value);
                }
            }
        }
        System.out.println("Файл декодирован: " + outputFile);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "CP866");// чтобы русский работал
        while (true) {
            System.out.println("1) Кодировать");
            System.out.println("2) Декодировать");
            System.out.println("3) Выход");
            System.out.print(">>> ");
            String line = sc.nextLine().trim();
            if ("3".equals(line)) break;
            
            System.out.print("Вход: "); String in = sc.nextLine().trim();
            System.out.print("Выход: "); String out = sc.nextLine().trim();
            try {
                if ("1".equals(line)) encode(in, out);
                else if ("2".equals(line)) decode(in, out);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
        sc.close();
    }
}
