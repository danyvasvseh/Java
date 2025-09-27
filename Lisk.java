public interface Num {
    public abstract double module();

}

// Целое число
class IntegerNumber implements Num {
    private final int value;

    public IntegerNumber(int value) {
        this.value = value;
    }
   
    @Override
    public double module() {
        return Math.abs(value);
    }


    public int getValue() {
        return value;
    }
}

// Вещественное число
class RealNumber implements Num {
    protected final double value;

    public RealNumber(double value) {
        this.value = value;
    }

    @Override
    public double module() {
        return Math.abs(value);
    }

    
    public double getValue() {
        return value;
    }
}

// Комплексное число
class ComplexNumber extends RealNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        super(real);
        this.real = this.value;
        this.imaginary = imaginary ;
    }

    @Override
    public double module() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }   

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}

public class Lisk {
    public static void main(String[] args) {
        Num [] numbers = {
            new IntegerNumber(5),
            new RealNumber(3.14),
            new ComplexNumber(12.0, 5.0)
        };
        // Ставим в Num любого наследника
        for (Num n : numbers) {
            System.out.println("Модуль: " + n.module());
        }

    }
}