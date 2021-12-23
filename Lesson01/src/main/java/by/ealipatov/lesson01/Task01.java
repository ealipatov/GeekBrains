package by.ealipatov.lesson01;

public class Task01 {
    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
    public static void main(String[] args) {
        System.out.println("Привет!");

        //2.Создать переменные всех пройденных типов данных и инициализировать их значения.
        byte valByte = 10;
        short valShort = 10100;
        int valInt = 1000;
        long valLong = 100100L;
        float valFloat = 12.12f;
        double valDouble = 121.121;
        char valChar = 'A';
        boolean valBoolean = true;

    /*
    3.  Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        где a, b, c, d – аргументы этого метода, имеющие тип float.
        Проверяем работу метода, вычияляющего выражение:
    */
        System.out.println("3. Результат: a * (b + (c / d)) = " + calc(3f, 4f, 6f, 3f));

    /*
    4.  Написать метод, принимающий на вход два целых числа и проверяющий,
        что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
        в противном случае – false.
        Проверяем что сумма  а и b лежит в пределах от 10 до 20 (включительно).
    */
        System.out.println("4. Сумма чисел a и b лежит в диапазоне от 10 до 20? - " + checkSum(10, 5));

    /*
    5. Написать метод, которому в качестве параметра передается целое число,
       метод должен напечатать в консоль, положительное ли число передали или отрицательное.
       Замечание: ноль считаем положительным числом.
    */
        System.out.print("5. ");
        isPositiveOrNegative(-10);
    /*
    6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    если число отрицательное, и вернуть false если положительное.
    */
        System.out.println("6. Число n отрицательное? - " + isNegative(10));


    /*
    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
       Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    */
        System.out.print("7. ");
        prName("Федот");

    /*
    8. Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    */
        System.out.print("8. ");
        leapYear(2021);
    }

    /**
     * 3. Метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     * где a, b, c, d – входные параметры этого метода.
     */
    public static float calc(float a, float b, float c, float d) {
        float res = a * (b + (c / d));
        return res;
    }

    /**
     * 4. Метод, принимающий на вход два числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно),
     * если да – вернуть true, в противном случае – false.
     */
    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        if (sum >= 10 || sum <= 20) {
            return true;
        } else return false;
    }

    /**
     * 5. Метод возвращает (выводит на консоль) значение "Положительное" или "Отрицательное"
     * @param n проверяемое целое число
     */
    public static void isPositiveOrNegative(int n) {
        if (n >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    /**
     * 6. Метод возвращает true, если число отрицательное, и false - если положительное.
     * @param n - целое число
     * @return возвращается false или true.
     */
    public static boolean isNegative(int n) {
        if (n >= 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 7. Выводит на консоль "Привет, name!"
     * @param name  - имя
     */
    public static void prName(String name) {
        System.out.printf("Привет, %s ! \n", name);
    }

    public static void leapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " Високосный");
        } else if (year % 400 == 0) {
            System.out.println(year + " Високосный");
        } else System.out.println(year + " Не високосный");
    }
}