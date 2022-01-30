package lesson07;

import java.awt.event.WindowFocusListener;
import java.util.Random;
import java.util.Scanner;

public class Task07 {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int count = 0;

    /**
     * Метод для генерации 10 объектов типа Cat.
     * nameCat - массив имен котов.
     * appetiteCat - массив значений аппетитов котов.
     * @return
     */
    static Cat generateCat(){
        String[] nameCat = {"Барсик", "Дымка", "Пушок", "Синди", "Персик", "Черныш", "Люська", "Маркиз", "Барон", "Багира"};
        int[] appetiteCat = {5, 10, 7, 12, 6, 16, 11, 14, 9, 18};
        if (count < 10)
        return new Cat(nameCat[count++], appetiteCat[random.nextInt(10)], false);
       return null;
    }


    public static void main(String[] args) {
        Plate plate = new Plate(80);   // Создадим объект типа Plate и присвоим ему значение 80.

        Cat[] cat = new Cat[10];            // Создадим массив оъектов типа Cat размерностью 10.
        Plate[] plates = new Plate[10];     // Создадим массив оъектов типа Plate размерностью 10.

            for (int i = 0; i < cat.length; i++) {
                cat[i] = generateCat();         // С помощь метода сгенерируем объекты типа Cat.
                // Создадим миски с именем для каждого кота. И количеством еды.
                plates[i] = new Plate(15, cat[i].getName());
            }

        System.out.println("Введите как кушают коты:\n1 - Из общей тарелки. \n2 - Каждый из своей. \n3 - Из какой получится тарелки.");

        if(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            switch (n) {

                case 1:
                    for (int i = 0; i < cat.length; i++) {
                        cat[i].InfoCat();               // Выведем информацию о коте (имя и аппетит).
                        plate.info();                   // Выведем количество корма в тарелке "plate".
                        cat[i].eat(plate,1);              // Попросим кота покушать.
                        System.out.println("");
                    }
                    break;

                case 2:
                    for (int i = 0; i < cat.length; i++) {
                        cat[i].InfoCat();                   // Выведем информацию о коте (имя и аппетит).
                        plates[i].info();                   // Выведем количество корма в тарелке.
                        cat[i].eat(plates[i], 1);              // Попросим кота покушать.
                        System.out.println("");
                    }
                    break;

                case 3:
                    System.out.println("Коты едят из рандомных тарелок с количеством еды от 10 до 20");

                    for (int i = 0; i < cat.length; i++) {
                        cat[i].InfoCat();
                        int r = random.nextInt(10);
                        plates[r].setFood(random.nextInt(21-10) + 10);
                        plates[r].info();
                        cat[i].eat(plates[r], 0);
                        System.out.println("");
                    }
                    break;
            }

        } else {
            System.out.println("Введены некорректные данные.");
            scanner.nextLine();
        }

        // Выведем список котов (имя и состояние сытости).
        for (int i = 0; i < cat.length; i++) {
            cat[i].InfoSatietyCat();
        }

    }


}