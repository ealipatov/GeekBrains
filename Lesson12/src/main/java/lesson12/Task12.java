package lesson12;

import java.util.Arrays;

public class Task12 {

    public static void main(String[] args) {

        final int size = 10000000;
        float[] arr = new float[size];

        //Метод расчета №1
        method1(arr);

        System.out.println("");

        //Метод расчета №2
        method2(arr);

    }

    /**
     * Метод поэтапного рассчета формулы для каждой ячейки массива.
     * @param arr - исходный массив.
     */
    public static void method1(float[] arr){
        Calculate calculate = new Calculate();
        System.out.println("Метод №1");
        System.out.printf("Инициализируем исходный массив на %d элементов.\n", arr.length);

            //Заполняем каждую ящейку массива 1
            Arrays.fill(arr, 1);

        System.out.println("Инициализация завершена.");

        System.out.printf("\nЗапускаем метод №1 расчета исходного массива. \n");
            long start = System.currentTimeMillis();

            calculate.formula(arr);

        System.out.println("Метод №1 завершил работу. Время заполнения: " +
                (System.currentTimeMillis() - start) + " миллисекунд.");

    }

    /**
     * Метод рассчета формулы для каждой ячейки массива. Метод использует разделение массива
     * на два вспомогательных и расчет каждого из них в отдельном потоке.
     * @param arr - исходный массив.
     */
    public static void method2(float[] arr){
        System.out.println("Метод №2");
        System.out.printf("Инициализируем исходный массив на %d элементов.\n", arr.length);

        Arrays.fill(arr, 1);

        System.out.println("Инициализация завершена.");

        System.out.printf("\nЗапускаем расчет исходного массива. \n");

            long start = System.currentTimeMillis();
            int half = arr.length / 2;

            float[] temp1 = new float[half];
            float[] temp2= new float[half];

        System.out.println("Разделяем исходный массив на два массива.");
        System.arraycopy(arr,0, temp1, 0,half);
        System.arraycopy(arr,half, temp2, 0,half);

        try {
            System.out.println("Запускаем обработку вспомогательных массивов двумя потоками.");

            Thread tread1 = new Thread(new CalcTread(temp1));
            Thread tread2 = new Thread(new CalcTread(temp2));

                tread1.start();
                    tread2.start();
                //Ожидаем основным потоком выполнения второстепенных потоков.
                tread1.join();
                    tread2.join();

                System.out.println("Склеиваем назад в один массив.");
                System.arraycopy(temp1,0, arr, 0,half);
                System.arraycopy(temp2,0, arr, half,half);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nМетод №2 завершил работу. Время заполнения: " +
                (System.currentTimeMillis() - start) + " миллисекунд.");

    }

}
class CalcTread implements Runnable{
    private Calculate calculate = new Calculate();
    private float[] arr;

    CalcTread(float[] arr){
        this.arr = arr;
    }

    @Override
    public void run() {
        calculate.formula(arr);

    }
}

class Calculate{

     void formula(float[] arr){
        for (int i = 0; i <arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));
        }
    }

}