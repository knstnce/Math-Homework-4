package truc;

public class Question1 {

    public Question1() {
    }

    public int EuclidGCD(int number1, int number2) {
        if (number1 == 0) {
            return number2;
        }
        return EuclidGCD(number2 % number1, number1);
    }
}