package lesson05;

public class Employee {
    private String fcs;     // ФИО
    private String post;    // Должность
    private String email;   // Электронная почта
    private String tel;     // Телефон
    private int salary;     // Зарплата
    public int age;        // Возраст
    public int id;          // Номер по порядку
    static int count;       // Счетчик

    int getAge(){           // Геттер для данных возраста
        return age;
    }
    void setAge(int age){   //Сеттер для данных возраста
        if (age < 18)
            this.age = 18;
        else
            this.age = age;
    }

    int getSalary(){        // Геттер для зарплаты
        return salary;
    }
    void setSalary(int salary){ //Сеттер для зарплаты
        if (salary < 0)         // Если введена отрицательная зарплата, то записываем 0
            this.salary = 0;
        else
            this.salary = salary;
    }

    Employee(){     // Конструктор без параметров

    }

    // Конструктор где вводятся только ФИО, Должность и телефон
    Employee(String fcs, String post, String tel){
        this.fcs = fcs;
        this.post = post;
        this.tel = tel;
    }
    //Конструктор, где вводятся все параметры.
    Employee(String fcs, String post, String email, String tel, int salary, int age){
        this.fcs = fcs;
        this.post = post;
        this.email = email;
        this.tel = tel;
        if (salary < 0)         // Если введена отрицательная зарплата, то записываем 0
            this.salary = 0;
        else
            this.salary = salary;
        if (age < 18)
            this.age = 18;      // Если вверен возраст меньше 18 лет, записываем 18.
        else
            this.age = age;
    }

    //Метод вывода на консоль информации из объекта.
    void dicplayInfo(){
        System.out.printf("№ п/п: %d; ФИО: %s; Должность: %s; Телефон: %s; Email: %s; Зарплата: %d; Возраст: %d\n", id, fcs, post, tel, email, salary, age);
    }

    {
        id = ++count;                           // Присвоим номер по порядку
        String fcs = "Иванов Иван Иванович";    // Проинициализируем ФИО
        String post = "Менеджер";               // Проинициализируем Должность
        String email = "mail@company.com";      // Проинициализируем Электронную почту
        String tel = "+375 29 1111111";         // Проинициализируем Телефон
        int salary = 500;                       // Проинициализируем Зарплату
        int age = 18;                           // Проинициализируем Возраст
    }




}
