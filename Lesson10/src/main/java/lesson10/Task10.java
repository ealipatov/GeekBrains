package lesson10;

import java.util.*;

public class Task10 {

    public static void main(String[] args) {

        Random random = new Random();

        String[] color = {"Красный", "Оранжевый", "Желтый", "Зеленый", "Голубой", "Синий", "Фиолетовый"};

        ArrayList<String> arrWord = new ArrayList();
        HashMap<String, Integer> words = new HashMap<>();

            for (int i = 0; i < 15; i++) {
                arrWord.add(color[random.nextInt(7)]);

            }
            for (String s : arrWord){
                if (words.containsKey(s)) {
                    int cont=1;
                    cont += words.get(s);
                    words.put(s, cont) ;
                } else {
                    words.put(s, 1);
                }
            }

            System.out.println(arrWord);
        for (Map.Entry<String,Integer> item : words.entrySet()){
            System.out.printf("\nУникальное слово: %s. Количество повторений: %d", item.getKey(), item.getValue());
        }
    }
}
