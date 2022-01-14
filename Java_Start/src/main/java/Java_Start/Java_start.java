package Java_Start;

import java.util.Scanner;

public class Java_start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите операцию: \n 1. Сложение. \n 2. Вычитание. \n 3. Умножение.\n");
        int oper = scanner.nextInt();
        System.out.println("Введите числа a и b через пробел");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (oper == 1){
            System.out.println("a + b = " + (a + b));
        } else if (oper == 2){
            System.out.println("a - b = " + (a -b));
        } else System.out.println("a * b = " + (a * b));
    }
}
