package lesson08;

import java.util.Random;

public class Task08 {

    private static final Random random = new Random();

    /**
     * Генерируем объекты класса Obstacle (препятствия);
     */
    static Obstacle generateObstacles(){
        String[] nameType = new String[] {"Стена", "Беговая дорожка"};
        int typeIndex = random.nextInt(2);
        int[] lengthTrack = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 55};
        int[] heightWall = new int[] {50, 60, 70, 80, 90, 100, 110, 120, 130, 140};
            switch (typeIndex){
                case 0:
                    return new Wall(nameType[typeIndex]+ "_" + Wall.count,0, heightWall[random.nextInt(10)]);
                case 1:
                    return new Track(nameType[typeIndex] + "_" + Track.count, lengthTrack[random.nextInt(10)], 0);

            }
            return null;
    }

    /**
     * Генерируем объекты класса Cat
     */
    static Cat generateCat(){
        String[] name = new String[] {"Кот_01", "Кот_02", "Кот_03", "Кот_04", "Кот_05", "Кот_06", "Кот_07", "Кот_08", "Кот_09", "Кот_10"};
        int[] maxLength = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 55};
        int[] maxHeight = new int[] {50, 60, 70, 80, 90, 100, 110, 120, 130, 140};

        return new Cat(name[Cat.count], maxLength[random.nextInt(10)], maxHeight[random.nextInt(10)]);
    }

    /**
     * Генерируем объекты класса Human
     */
    static Human generateHuman(){
        String[] name = new String[] {"Человек_01", "Человек_02", "Человек_03", "Человек_04", "Человек_05", "Человек_06", "Человек_07", "Человек_08", "Человек_09", "Человек_10"};
        int[] maxLength = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 55};
        int[] maxHeight = new int[] {50, 60, 70, 80, 90, 100, 110, 120, 130, 140};

        return new Human(name[Human.count], maxLength[random.nextInt(10)], maxHeight[random.nextInt(10)]);
    }

    /***
     * Генерируем объекты класса Robot
     */
    static Robot generateRobot(){
        String[] name = new String[] {"Робот_01", "Робот_02", "Робот_03", "Робот_04", "Робот_05", "Робот_06", "Робот_07", "Робот_08", "Робот_09", "Робот_10"};
        int[] maxLength = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 55};
        int[] maxHeight = new int[] {50, 60, 70, 80, 90, 100, 110, 120, 130, 140};

        return new Robot(name[Robot.count], maxLength[random.nextInt(10)], maxHeight[random.nextInt(10)]);
    }

    public static void main(String[] args) {

        Obstacle[] obstacles = new Obstacle[10];

        Runner[] runners = new Runner[3];

        Runner[] cats = new Cat[10];
        Runner[] humans = new Human[10];
        Runner[] robots = new Robot[10];

        //Генерируем массив препятствий
        for (int i = 0; i < obstacles.length; i++){
            obstacles[i] = generateObstacles();
        }
        // Генерируем массивы участников
        for (int i = 0; i < 10; i++){
            cats[i] = generateCat();
            humans[i] = generateHuman();
            robots[i] = generateRobot();
        }

        //Создадим 3-х участников из объектов разных классов (заранее сгенерированных).
        runners[0] = cats[random.nextInt(10)];
        runners[1] = humans[random.nextInt(10)];
        runners[2] = robots[random.nextInt(10)];

        // Циклом попросим всех участников runners пройти все препятствия obstacles;
        //Мложно предавать учатсников других типов (Runners cat : cats) например.
        //TODO: Переработать, возможно в метод в более универсальный.

        for(Runner runner : runners){
            System.out.println("");
            for (Obstacle obstacle : obstacles) {
                obstacle.info();
                // по длине препятствия определим его тип и определим действия для его преодоления.
                if (obstacle.getLength() == 0){
                    //Если препятствие преодалено, продолжаем движение.
                    if(runner.jump(obstacle.getHeight()));
                    //Иначе завершаем.
                    else break;
                }  else if (runner.run(obstacle.getLength()));
                else break;
            }
        }
    }
}

/**
 * Объявим интерфейс для действий
 */
interface Runner{
    boolean run(int distance);
    boolean jump(int height);

    default void info() {

    }
}

/**
 * Объявим интерфейс для препятствий
 */
interface Obstacle{

    int getLength();
    int getHeight();
    void info();

}

//Создадим класс перпятствий "беговая дорожка" имплементированного от интерфейса для препятствий.
class Track implements Obstacle {
    static int count = 1;
    String name;
    private final int length;

    static {
        count++;
    }

    public Track(String name, int length, int height) {
            this.name = name;
            this.length = length;
    }

        @Override
        public int getLength () {
            return length;
        }

        @Override
        public int getHeight () {
            return 0;
        }

    @Override
    public void info() {
        System.out.printf("Препятствие: %s длина %d метров.\n", name, length);
    }

}
//Создадим класс перпятствий "стена" имплементированного от интерфейса для препятствий.
class Wall implements Obstacle{
    static int count = 1;
    String name;
    private int height;

    static {
        count++;
    }

        public Wall(String name, int length, int height) {
            this.name = name;
            this.height = height;
        }

    public void setHeight(int height) {
            this.height = height;
        }

        public void setLength(int length) {
        }

        @Override
    public int getLength() {
        return 0;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void info() {
        System.out.printf("Препятствие: %s, высота %d см.\n", name, height);
    }

}