package lesson10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task10_2 {


    public static void main(String[] args) {

            Random random = new Random();

            String[] surname = {
                    "Голубев",
                    "Громов",
                    "Мельников",
                    "Тихонов",
                    "Карасев",
                    "Блинов",
                    "Спиридонов",
                    "Бобров",
                    "Макаров",
                    "Кузьмин",
                    "Орлов",
                    "Федоров",
                    "Степанов",
                    "Морозов",
                    "Королев"};

            int[] number = {1844001, 1320736, 1813399, 3899339, 1106864, 9792861, 3442399, 1394099,
                    7778049, 7449791, 1098708, 2870460, 7137474, 3134353, 1153573, 4326505, 7702568,
                    9612696, 6620036, 9399790, 3584184, 4456627, 6651352, 3926433, 4467923, 1590881,
                    9827392, 2482587, 5824478, 6434203};

            //Сгенерируем массив из строк фамилия + телефон
            String[] list = new String[15];
            for (int i = 0; i < 15; i++) {
                list[i] = surname[random.nextInt(15)] + " " + number[i];
                //System.out.println(list[i]);
            }
        //Создадим коллекцию HashMap, ключ - фамилия, значение - список объектов типа PhoneList (фамилия и телефон).
        HashMap<String, ArrayList<PhoneList>> phoneBook = new HashMap<>();

            // Добавим информацию из строкового массива list в список phoneBook
            for (String s : list) {
            add(s, phoneBook);
            }
            //Выведем коллекцию на консоль
            print(phoneBook);
            //Добавим в коллекцию phoneBook строки
            add("Коровьев 5552211", phoneBook);
            add("Коровьев 6663322", phoneBook);

        //Поищим фамилии Коровьев и Михалков в нашем справочнике и результат выведем на консоль
        get("Коровьев",phoneBook);
        get("Михалков",phoneBook);
    }

    /**
     * Метод для вывода на консоль коллекции типа HashMap по ключу.
     * @param phoneBook -  выводимый список (коллекция)
     */
    public static void print(HashMap<String,ArrayList<PhoneList>> phoneBook){
        for (Map.Entry<String,ArrayList<PhoneList>> item : phoneBook.entrySet()) {
            System.out.printf("\nФамилия: %s \n", item.getKey());
            for (PhoneList phone : item.getValue()) {
                System.out.printf("Телефон: %s \n", phone.getPhone());
            }
        }
    }

    /***
     * Метод, добавляющий в коллекцию (список) данные из строки типа "'фамилия' 'телефон'"
     * @param s - передаваемая строка
     * @param phoneBook - коллекция в которую будем добавлять данные.
     *                  если ключи (фамилии) одинаковые, то в значение добавляем объект типа PhoneList
     *                  к уще существующему там значению. Если ключ уникальный - создаем новую запись.
     */
    public static void add(String s, HashMap<String,ArrayList<PhoneList>> phoneBook){
        String[] parts = s.split(" ");

        if (phoneBook.containsKey(parts[0])) {
            phoneBook.get(parts[0]).add(new PhoneList(parts[0], parts[1]));
        } else {
            ArrayList<PhoneList> lst = new ArrayList<>();
            lst.add(new PhoneList(parts[0], parts[1]));
            phoneBook.put(parts[0], lst);
        }
    }

    public static void get(String s, HashMap<String,ArrayList<PhoneList>> phoneBook){
        if(phoneBook.get(s) == null)
            System.out.printf("Фамилия: '%s' в справочнике не найдена.\n", s);
        else
            System.out.println(phoneBook.get(s));
    }


}

//Создадим класс, который хранит фамилию и телефон.
class PhoneList{
    private String surname;
    private String phone;

    public PhoneList(String surname, String phone) {
        this.surname = surname;
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Фамилия: " + "'" + surname + '\'' + ", телефон: '" + phone + '\'' +' ';
    }
}
