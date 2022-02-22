package lesson14;

import java.io.IOException;
import java.util.logging.*;

public class Task14 {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Task14.class.getName());
        try {

            LogManager.getLogManager().readConfiguration(Task14.class.getResourceAsStream("/config/logger.config"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] mass = {1, 2, 3, 9, 5, 6, 7, 8, 9, 7, 5, 6, 3, 2, 1};
        int[] mass2 = {1, 2, 3, 4, 5, 6, 7, 8, 4, 7, 5, 6, 3, 2, 1};

        int[] mass3 = {1,1,4,4,1,3};

        //Вызовем первый метод.
        try {
            printArrInt(mass2);
            printArrInt(ArrCheck.arrFindFour(mass2));
            System.out.println("");
            printArrInt(mass);
            printArrInt(ArrCheck.arrFindFour(mass));
        } catch (RuntimeException e){
            e.printStackTrace();
            logger.log(Level.WARNING, "Произошло исключение.\n  Продолжаем работу.");

        }

        System.out.println("");

        //Вызовем второй метод.
        System.out.println(ArrCheck.arrCheckOneOrFour(mass3));

        logger.info("Все сервисы отработали корректно.");
    }

    public static void printArrInt(int[] arr) {
        System.out.print("[ ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println("]");
    }

}




