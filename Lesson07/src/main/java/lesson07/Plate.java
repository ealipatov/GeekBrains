package lesson07;

import java.util.Scanner;

public class Plate {
    private int food;
    private String name;
    private Scanner scanner = new Scanner(System.in);

    {
        name = "all";
    }
    //Создадим конструктор класа Plate
    public Plate(int food) {
        this.food = food;
    }

    public Plate(int food, String name){
        this.food = food;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Сгенерируем сеттер для количества еды и добавим защиту от отрицательных значений
    public void setFood(int food) {
        if(food > 0)
            this.food = food;
        else
            System.out.println("Введено некорректное количество корма.");
    }

    /**
     * Метод проверки достаточности еды в тарелке. Если еды не достаточно,
     * метод предложит добавить еду в тарелку.
     * @param n - параметр аппетита кота, который собирается покушать.
     */
    public void checkFood(int n){
        if(n > food){
            System.out.printf("В тарелке %s не хватает корма.\n",getName());
            System.out.printf("Добавить корм в тарелку %s? Да/Нет\n", getName());
            String  a = scanner.next();
            scanner.nextLine();
            if(a.equalsIgnoreCase("Да")) {
                System.out.print("Введите количество корма: ");
                if(scanner.hasNextInt()){
                    int f = scanner.nextInt();
                    setFood(food + f);

                } else
                    System.out.println("Введены некорректные данные.");
                    scanner.nextLine();

            }
        } //scanner.nextLine();
    }

    /**
     * Метод в котором кот кушает. Если еды не хватает, предлагается добавить еды в тарелку.
     * Если и добавленной еды все равно не хватает, кот не кушает и остается голодным.
     * @param n - параметр аппетита кота, который собирается покушать.
     * @param c - параметр проверки достаточнисти корма 1 - проверяем, 0 - нет.
     * @return Если кот покушал, возвращаем true, если нет - false.
     */
    public boolean decreaseFood(int n, int c) {
       boolean s = false;
        switch (c) {

            case 1:
                checkFood(n);
                if (food >= n) {
                    food -= n;
                    s = true;
                } else
                    s = false;
                break;

            case 0:
                if (food >= n) {
                    food -= n;
                    s = true;

                } else
                    s = false;
                break;

        }
        return s;
    }


    /**
     * Выводим количество корма в тарелке.
     */
    public void info() {
        System.out.printf("Количество корма в тарелке %s: %d\n",getName(), food);
    }
}
