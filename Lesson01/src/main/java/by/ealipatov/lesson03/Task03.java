package by.ealipatov.lesson03;

import java.util.Random;
import java.util.Scanner;

public class Task03 {

    static Scanner scanner = new Scanner(System.in);
    static int maxCount = 3;
    private static Random random;

    /**
     * Печать однострочного массива
     * @param arr - передаваемый массив.
     */
    public static void printArr(char arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    // Метод печатающий правила предлагаемых игр (сильно не расписывал)
    public static void rules () {
        System.out.println(" ");
        System.out.println("Правила игры отгадай число:");
        System.out.println("====================================================");
        System.out.println("Вам требуется отгадать число от 1 до 10.");
        System.out.println("У Вас будет всего три попытки(а). Удачи.");
        System.out.println("====================================================");
        System.out.println(" ");
        System.out.println("Правила игры отгадай слово:");
        System.out.println("====================================================");
        System.out.println("Вам требуется отгадать загаданное компьютером слово ");
        System.out.println("Если слово не угадано, отобразятся совпадающие буквы");
        System.out.println("Игра продолжается пока не будет угадано слово.");
        System.out.println("====================================================");
    }
    // Метод, вызывающий игру "Отгадай число".
    public static void game1 () {
        Random random = new Random();
        int number = random.nextInt(10);
        int userNumber;
        int count;

        System.out.println("============================================");
        System.out.println("Игра отгадай число");
        System.out.println("============================================");

        for (count = 1; count <= maxCount; count++){
            System.out.print("Угадайте число от 0 до 10: ");
            boolean isNumber = scanner.hasNextInt();
            if (isNumber) {
                userNumber = scanner.nextInt();
                scanner.nextLine();
                if (userNumber == number) {
                    System.out.println("==============================================");
                    System.out.println("Поздравляем! Вы угадали! Загаданное число: " + number);
                    System.out.println("==============================================");
                    break;
                } else if (userNumber > number) {
                    System.out.println("Вы ввели число " + userNumber + " оно больше загаданного.");
                    System.out.println("У вас осталось " + (maxCount - count) + " попытки(а).");
                } else if (userNumber < number) {
                    System.out.println("Вы ввели число " + userNumber + " оно меньше загаданного.");
                    System.out.println("У вас осталось " + (maxCount - count) + " попытки(а).");
                }
            } else {
                System.out.println("Вы ввели некорректное число.\nПожалуйста, повторите попытку ввода.");
                scanner.nextLine();
                count--;
            }
        }
        if(maxCount == (count -1)){
            System.out.println("=================================================================");
            System.out.println("К сожалению вы проиграли. Не расстраивайтесь, попробуйте еще раз.");
            System.out.println("Загаданное число: " + number);
            System.out.println("=================================================================");
        }

    }
    // Метод, вызывающий игру "Отгадай слово"
    public static void game2 (){
        boolean isNumber = true;
        String userWord;
        // Создаем массив слов, рандомно предлагаемых для угадывания.
        String arrWords[] = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int number = random.nextInt(arrWords.length); //Выбираем случайную позицию в массиве.
        // Создаем вспомогательный массив из символов 'X'
        char arrTempWord[] = {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'};
        String word = arrWords[number]; // Выбираем слово из массива, согласно ранее определенной позиции.

        do {
            System.out.print("Отгадайте слово: ");
            userWord = scanner.next();
            scanner.nextLine();

            if(userWord.equals(word)){ // Подсмотрел сравнение строк в интернете, просто userWord == word не работало.
                System.out.println("Поздравляю, вы угадали! Загаданное слово: " + word);
                isNumber = false;

            } else { //Циклом сравниваем загаданное слово и введенное, совпадающие позиции
                     // записываем в соответствующие места вспомогательного массива и выводим его на консоль
                    for(int i = 0; i < word.length() && i < userWord.length(); i++){
                        if(word.charAt(i) == userWord.charAt(i)){
                        arrTempWord[i] = userWord.charAt(i);
                    }
                }
                System.out.print("Совпали следующие буквы: ");
                printArr(arrTempWord);
            }
        }
        while (isNumber);

    }

    public static void main(String[] args) {

        boolean isNumber = true;

        while (isNumber){
            System.out.println("              Меню:            ");
            System.out.println("================================");
            System.out.println("1 - Описание игр.");
            System.out.println("2 - Играть в игру отгадай число.");
            System.out.println("3 - Играть в игру отгадай слово.");
            System.out.println("0 - Выход");
            System.out.println("================================");
            System.out.print("Ваш выбор: ");

            if (scanner.hasNextInt()){
                int no = scanner.nextInt();
                scanner.nextLine();

                switch (no){
                    case 1:
                        rules();
                        break;

                    case 2:
                        game1();
                        break;

                    case 3:
                        game2();
                        break;

                    case 0:
                        isNumber = false;
                        break;
                }

            } else {
                System.out.println("Вы ввели некорректные данные. Повторите ввод.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

}
