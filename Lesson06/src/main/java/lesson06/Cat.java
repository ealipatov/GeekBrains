package lesson06;

public class Cat extends Animal {
    static int count;
    public int id;
    private final int maxDistRun = 200;

    {
        id = ++count; //В инициализаторе присваиваем id (на всякий случай) и наращиваем счетчик.
    }

    Cat(String name) {
        super(name);
    }

    /***
     * Метод плавания для объектов класса Animal подкласса Cat. Но по условию задачи коты не умеют плавать.
     * @param dist - дистанция для плавания.
     */
    @Override
    public void sail(int dist) {
        System.out.printf("Кот %s не может проплыть %d метров. Коты по условию задачи не умеют плавать.\n", getName(), dist);
    }

    /***
     * Метод бега для объектов класса Animal подкласса Cat.
     * @param dist - дистанция для бега.
     * Максимальная длина бега maxDistRun = 200 метров.
     */
    @Override
    public void run(int dist) {
        if (dist <= maxDistRun && dist >= 1)
            System.out.printf("Кот %s пробежал %d метров\n", getName(), dist);
        else if (dist > maxDistRun)
            System.out.printf("Кот %s не может пробежать %d метров. Не больше %d метров. \n", getName(), dist, maxDistRun);
        else
            System.out.printf("Введена не корректная дистанция бега %d для кота %s\n", dist, getName());
    }

    public void move(int runDist, int sailDist){
        run(runDist);
        sail(sailDist);
    }
}
