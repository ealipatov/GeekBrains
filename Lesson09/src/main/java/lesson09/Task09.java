package lesson09;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Task09 {


    public static void main(String[] args) throws MyArrayException {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String[][] arrGoodSizeString = new String[4][4];
        String[][] arrBadSizeString = new String[4][6];


        int n = 0;
        do {
        System.out.println("\nМеню: (0 - выход)\n1 - Вывести массив 4х4 на консоль и посчитать сумму его елементов. " +
                "\n2 - Вывести массив 4х6 на консоль и посчитать сумму его елементов. " +
                "\n3 - Вывести массив 4х4 на консоль с элементом содержащим не число посчитать сумму его елементов.");

            if (scanner.hasNextInt()) {

                n = scanner.nextInt();

                switch (n) {

                    case 1:
                        initArr(arrGoodSizeString);
                        printArr(arrGoodSizeString);
                        sumElemStringArr(arrGoodSizeString);
                        break;

                    case 2:
                        initArr(arrBadSizeString);
                        printArr(arrBadSizeString);
                        sumElemStringArr(arrBadSizeString);
                        break;

                    case 3:
                        //Запишем в рандомный елемент массива строку не содержащую числа.
                        initArr(arrGoodSizeString);
                        arrGoodSizeString[random.nextInt(4)][random.nextInt(4)] = "er";
                        printArr(arrGoodSizeString);
                        sumElemStringArr(arrGoodSizeString);
                        break;
                }

            } else {
                System.out.println("Введены некорректные данные.");
                scanner.nextLine();
            }

        }
        while (n != 0);
        System.out.println("Завершаем работу приложения");
        scanner.close();
    }


    /**
     * Метод проверяющий строку на содержание числовых символов
     * @param s = передаваемая строка
     * @return Если все элементы строки числа - возвращаем true, иначе false.
     */
    private static boolean checkElemStringIsDigit(String s){
        char[] elem;
        //Преобразуем строку в массив символов
        elem = s.toCharArray();
        for(char c : elem){
            //Если эелемент массива не "число" вернем false
            if(!Character.isDigit(c))
                return false;
        }
        return true;
    }

    /**
     * Метод суммирующий элементы строкового массива 4х4.
     * @param s - передаваемый массив
     * @throws MyArrayException - возможные исключения.
     */
    private static void sumElemStringArr(String[][] s) throws MyArrayException{
        int sum = 0;
        try{
            //TODO: Возможно доработать условие вызова исключения для разных длин размерности массива
            //Проверяем длину передаваемого массива, так как у нас массив массивов, проверяем
            //длину каждой "строки" Если передаваемый массив не 4х4 - вызовем исключение.
            if(s.length != 4 || s[0].length != 4 || s[1].length != 4 || s[2].length != 4 || s[3].length != 4) {
            // Если передаваемый массив не соответствует параметрам, вызываем исключение.
                throw new MyArraySizeException();
            }

             //Циклом пройдем по всем элементам массива.
             for (int i = 0; i < s.length; i++){
                 for (int j = 0; j < s[1].length; j++){
                     //Вызовем метод, проверяющий елемент массива на содержание числовых символов
                     if(checkElemStringIsDigit(s[i][j]))
                     // Если проверка удачна, преобразовываем строку в число и суммируем.
                     sum += parseInt(s[i][j]);
                     //Иначе вызываем исключение и передадим индекс элемента, вызвавшего исключение.
                     else throw new MyArrayDataException(i, j);
                 }
             }
            System.out.println("Сумма элементов массива: " + sum);
        }
        catch (MyArraySizeException e){
            e.printStackTrace();
        }
        catch (MyArrayDataException e){
            e.printStackTrace();
        }
    }

    /**
     * Метод вывода двумерного массива на консоль в виде матрицы.
     * @param s - передаваемый массив
     */
    public static void printArr(String[][] s){
        for(int i = 0; i < s.length; i++){
            System.out.println("");
            for (int j = 0; j < s[i].length; j++) {
                System.out.print(s[i][j] + " ");
            }
        }
        System.out.println("");
    }

    /**
     * Метод инициализации двумерного массива строками, содержащими числа.
     * @param s - массив для инициализации
     * @return - возвращяем проинициализированный массив.
     */
    public static String[][] initArr(String[][] s){
        Random random = new Random();
        for(int i = 0; i < s.length; i++){
            for (int j = 0; j < s[i].length; j++) {
                //TODO: Разобраться в чем разница преобразования в строку через valueOf и Integer.toString
                s[i][j] = valueOf(random.nextInt(100 - 10) + 10);
                // arrGoodSizeString[i][j] = Integer.toString(random.nextInt(100 - 10) + 10);
            }
        }
        return s;
    }

}
//Объявим абстрактный класс исключений
abstract class MyArrayException extends Exception{

}

/**
 * Исключение если передан массив недопустимой размерности
 */
class MyArraySizeException extends MyArrayException{

    @Override
    public void printStackTrace() {
        System.out.println("");
        System.out.println("Исключение: Передан массив недопустимой размерности.");

        //super.printStackTrace();
    }
}

/**
 * Исключение, если в массиве есть строки, сожержащие не числовые символы.
 */
class MyArrayDataException extends MyArrayException {
    int i, j;
    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public void printStackTrace() {
        System.out.println("");
        System.out.printf("Исключение: Элемент массива с индексом : [%d][%d], содержит не числовое значение.\n", i, j);
        // Не знаю как вывести на экран super.printStackTrace(); сразу после System.out.printf();
        //По этому закомментировал
        //super.printStackTrace();
    }
}