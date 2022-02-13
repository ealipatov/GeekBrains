package lesson11;

import java.util.ArrayList;
import java.util.Arrays;

public class Task11_1 {

    public static void main(String[] args) {

        String[] str = {"Иванов","Петров","Сидоров"};
        Integer[] num = {1, 2, 3};

        ArrTools.print(str);
        ArrTools.print(num);

        ArrTools.swap(str, 0, 2);
        ArrTools.swap(num, 0, 2);

        ArrTools.print(str);
        ArrTools.print(num);

        System.out.println(ArrTools.Transformation(str));
        System.out.println(ArrTools.Transformation(num));


    }
}
class ArrTools{

    /**
     * Метод, трансформирующий массив с список (коллекцию).
     * @param <T> - исходный массив
     * @return - возвращаемый список (коллекция).
     */
    public static <T> ArrayList<T> Transformation (T[] items){
        ArrayList<T> temp = new ArrayList<>(Arrays.asList(items));
        return temp;
    }

    /**
     * Метод вывода одномерного обобщенного массива на печать.
     * @param <T> - обобщенный массив
     */
    public static <T> void print(T[] items){
        for (T item: items) {
            System.out.println(item + " ");
        }
        System.out.println();
    }

    /**
     * Метод, меняющий местами два элемента обобщенного массива.
     * @param a - первый элемент массива
     * @param b - второй элемент массива
     * @param <T> - исходный массив.
     */
    public static <T> void swap(T[] items, int a, int b){
        T buf = items[a];
        items[a] = items[b];
        items[b] = buf;
    }
}