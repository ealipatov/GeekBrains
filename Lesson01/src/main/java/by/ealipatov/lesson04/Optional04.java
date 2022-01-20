package by.ealipatov.lesson04;

import java.util.Random;

public class Optional04 {
    public static void main(String[] args) {

        Random random = new Random();
        int a = random.nextInt(9);
        int b = random.nextInt(9);
        int c = random.nextInt(9);

        System.out.printf("Случайные числа a: %o, b: %o, c: %o", a, b, c);
        System.out.println();
        System.out.print("Максимальное число: ");
        System.out.println(a > b && a > c ? a : b > a && b > c ? b : c);
    }
}
