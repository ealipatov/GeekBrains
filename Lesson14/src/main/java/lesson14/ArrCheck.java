package lesson14;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrCheck extends Throwable {

    /**
     * Метод возвращяет все значения из целочисленного массива после числа 4 (если такое имеется)
     * Если числа 4 в проверяемом рассиве нет, выбрасывается исключение RuntimeException.
     * @param arr - исходный массив.
     * @return Возвращается целочисленный массив.
     */
    public static int[] arrFindFour(int[] arr) {
        boolean check = false;
        int[] res = new int[arr.length];

        // Проиходимся по элементиам массива и если находим 4, создаем копию массива с последующей
        // позиции и до конца массива. Немного ресурсоёмко при больших массивах, но работает.
        //Можно реализовать через коллекцию.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                check = true;
                res = Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        if (!check)
            throw new RuntimeException();
        return res;
    }

    /**
     * Метод преобразует целочисленный массив в коллекцию, проверяет имеются ли в проверяемом массиве
     * числа и 1 и 4, если меются оба числа, проверяет чтобы массив состоял только из этих числел.
     * @param arr Проверяемый массив.
     * @return Возвращает true если все условия выполняются.
     */
    public static boolean arrCheckOneOrFour(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        boolean check = false;

        //Передаём все элеиенты массива в список.
        for (int i : arr){
            temp.add(i);
        }

        System.out.println(temp);
        //Проверяем наличие одновременно 1 и 4 в списке.
        if (temp.contains(1) && temp.contains(4)){
            //и если есть, проверяеем чтобы в списке были только 1 и 4
            for(Integer i : temp){
                if(i == 1 || i == 4)
                    check = true;
                else check = false;
            }
        }
        else check = false;

        return check;
    }

}
