package lesson06;

public abstract class Animal {

    private String name;
    // Базовый конструктор
    Animal() {
   }
    // Конструктор с одним параметром
    Animal(String name) {
       this.name = name;
    }

    public String getName() {
        return name;
    } // Геттер для Имени (клички)

    /**
     * Метод движения животного - плыть
     * @param dist - дистанция, которую животному требуется проплыть
     * Максимальная длина плавания maxDistSail = 10 метров для собаки, коты плавать не умеют;
     */
    public abstract void sail(int dist);    //Абстрактный метод sail (необходимо будет перепределить в подклассе).

    /**
     * Метод движения животного - бежать
     * @param dist - дистанция, которую животному требуется пробежать
     * Максимальная длина бега maxDistRun = 200 метров для кота, и 500 метров для собаки.
     */
    public abstract void run(int dist);     //Абстрактный метод run (необходимо будет перепределить в подклассе).

    /**
     * Метод, объединяющий методы движения животных
     * @param runDist - дистанция, которую животному требуется пробежать
     * @param sailDist - дистанция, которую животному требуется проплыть
     * При использовании метода move собака дополнительно виляет хвостом.
     */
    public abstract void move(int runDist, int sailDist);
}
