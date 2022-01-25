package lesson06;

public class Task06 {

    public static void main(String[] args) {
        //Создаем объекты классов Cat и Dog
        Animal cat01 = new Cat("Барсик");
        Animal dog01 = new Dog("Барбос");
        Animal cat02 = new Cat("Дымка");
        Animal dog02 = new Dog("Дружок");
        Animal dog03 = new Dog("Палкан");

        cat01.run(100); // Вызываем метод run для объекта cat01 и задаем дистанцию бега.
        cat01.sail(10); // Вызываем метод sail для объекта cat01 и задаем дистанцию плавания.
        System.out.println();

        cat02.run(-5);
        System.out.println();

        dog01.run(300); // Вызываем метод run для объекта dog01 и задаем дистанцию бега.
        dog01.sail(80); // Вызываем метод sail для объекта dog01 и задаем дистанцию плавания.
        System.out.println();

        dog02.move(600, 0); //Вызываем метод, объединяющий методы run и sail
        System.out.println();

        dog03.move(100, 10);
        System.out.println();

        // Выводим на консоль общее количество животных. Отдельно количество котов и собак.
        System.out.println("Всего животных - " + (Cat.count + Dog.count));
        System.out.println("Из них собак - " + Dog.count);
        System.out.println("Из них котов - " + Cat.count);
    }


}

