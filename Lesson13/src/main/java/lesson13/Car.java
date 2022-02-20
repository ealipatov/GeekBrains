package lesson13;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    CyclicBarrier barrier;
    ArrayList<String> winner;

    private static int carQuantity;

    private static int CARS_COUNT;
    private Race race;

    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier barrier,ArrayList winner, int carQuantity) {
        this.carQuantity = carQuantity;
        this.barrier = barrier;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.winner = winner;
    }

    /**
     * Метод подготовки автомобилей
     */
    public void preparationCar(){
        try {
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT  + this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT  + this.name + " готов");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод запуска гонки
     */
    public void startRace(){
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

    }

    // TODO будущий метод определния победителя.
    public synchronized void checkAllCar(String s){

        try {
            //Наверное счетчик количества потоков в ожидании начинается с 0, колво авто уменьшаем на 1
            if(barrier.getNumberWaiting() == carQuantity - 1){
                System.out.println("");
                System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + s);
                System.out.println("");
            }
            barrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        //Готовим автомобили к гонке.
        preparationCar();

        //Ждем пока не будут готовы все автомобили (синхронизируем старт).
        checkAllCar("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        //Стартуем гонку
        startRace();

        //TODO Проработать определение единственного победителя другим методом.

        winner.add(this.name);

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT  + this.name + " закончил гонку.");

        if(this.name.equals(winner.get(0)))
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT  + winner.get(0) + " Победил!");

        checkAllCar("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        //4- е место не объявляем
        if(winner.indexOf(this.name) < 3)
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT  + this.name + " - " + (winner.indexOf(this.name) + 1) + " место!");


    }
}
