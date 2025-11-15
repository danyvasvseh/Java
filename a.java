public class a {
    public static void main(String[] args) {
        Card aceOfClubs = new Card("clubs", 11);
        Card aceOfSpades = new Card("spades", 11);
        System.out.println(aceOfClubs.equals(aceOfSpades));
    }
}

class Card{
    public String suit;
    public int value;

    Card(String suit, int value){
        this.suit = suit;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        Card other = (Card) obj;
        /*
         * соглашение: equals - отношение эквиваленции
         * 1 рефлексивно
         * 2 симметрично
         * 3 транзитивно
         * бонус: не "портит" объект - проверка должна возвращать одно и то же,
         * пока объекты не изменены чем-то ещё.
         */
        return this.suit==other.suit & this.value == other.value;
    }
}