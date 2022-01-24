package lesson05;

import java.util.Random;

public class Task05 {


    public static void main(String[] args) {

        int size = 5; // Зададим размерность массива
        // Создадим массивы с данными для рандомного заполнения массива объектов Employee
        String arrFcs[] = {"Евгений Петросян", "Омар Хаям", "Стас Михайлов", "Катя Лель",
                           "Юлий Гусман", "Федор Бондарчук", "Валдис Пельш", "Нюша",
                           "Аркадий Укупник", "Иммануил Кант"};
        String arrPost[] = {"Менеджер", "Директор", "Курьер", "Бухгалтер", "Инженер", "Юрист",
                            "Секретарь", "Рабочий", "Дизайнер", "Переводчик"};
        String arrEmail[] = {"1@company.com", "2@company.com", "3@company.com", "4@company.com",
                          "5@company.com", "6@company.com", "7@company.com", "8@company.com",
                          "9@company.com", "10@company.com"};
        String arrTel[] = {"+375 29 1112233", "+375 29 2223344", "+375 29 3334455", "+375 29 4445566",
                        "+375 29 5556677", "+375 29 6667788", "+375 29 7778899", "+375 29 8889900",
                        "+375 29 9990011", "+375 29 0001122"};
        int arrSalary[] = {500, 750, 1200, 2500, 900, 1350, 1250, 1800, 2100, 1400};
        int arrAge[] = {25, 40, 38, 19, 42, 56, 41, 34, 28, 33};

        Random random = new Random();
        // Создаем массив объектов Employee размерностью size (5);
        Employee arrEmp[] = new Employee[size];

        //С помощью цикла заполним нам массив объектами типа Employee
        for (int i = 0; i < size; i++){
           arrEmp[i] = new Employee(arrFcs[random.nextInt(9)], arrPost[random.nextInt(9)],
                    arrEmail[random.nextInt(9)], arrTel[random.nextInt(9)],
                    arrSalary[random.nextInt(9)], arrAge[random.nextInt(9)]);
        }
        //Выведем на консоль созданные объекты.
        for (int i = 0; i < size; i++){
            arrEmp[i].dicplayInfo();
        }
        //Выведем на консоль объекты согласно условию (возраст больше 40 лет)
        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < size; i++) {
            if (arrEmp[i].getAge() >= 40)
            arrEmp[i].dicplayInfo();
        }

    }
}