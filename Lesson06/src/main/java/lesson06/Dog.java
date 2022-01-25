package lesson06;

public class Dog extends Animal {
    static int count;
    public int id;
    int maxDistRun = 500;
    int maxDistSail = 10;

    {
        id = ++count; //В инициализаторе присваиваем id (на всякий случай) и наращиваем счетчик.
    }

    Dog(String name) {
        super(name);
    }

    /**
     * Метод плавания для объектов класса Animal подкласса Dog.
     * @param dist - дистанция плавания.
     *  Максимальная длина плавания maxDistSail = 10 метров;
     */
    @Override
    public void sail(int dist) {
        if (dist <= maxDistSail && dist >= 1)
            System.out.printf("Пес %s проплыл %d метров.\n", getName(), dist);
        else if (dist > maxDistSail)
            System.out.printf("Пес %s не может проплыть %d метров. Не бельше %d метров.\n", getName(), dist, maxDistSail);
        else
            System.out.printf("Введена не корректная дистанция плавания %d для собаки %s\n", dist, getName());
    }

    /**
     * Метод бега для объектов класса Animal подкласса Dog.
     * @param dist - дистанция бега.
     * Максимальная длина бега maxDistRun = 500 метров;

     */
    @Override
    public void run(int dist) {
        if (dist <= maxDistRun && dist >= 1)
            System.out.printf("Пес %s пробежал %d метров.\n", getName(), dist);
        else if (dist > maxDistRun)
            System.out.printf("Пес %s не может пробежать %d метров. Не бельше %d метров.\n", getName(), dist, maxDistRun);
        else
            System.out.printf("Введена не корректная дистанция бега %d для собаки %s\n", dist, getName());
    }
    public void move(int runDist, int sailDist){
        run(runDist);
        sail(sailDist);
        System.out.printf("Пес %s повилял хвостом.\n", getName());
    }

}
