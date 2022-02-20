package lesson13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore semaphore;

    public Tunnel(Semaphore semaphore) {
        this.semaphore = semaphore;
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(ConsoleColors.YELLOW  + c.getName() + " готовится к этапу(ждет): " + description);
                //В тоннель может въехать только половина учачтников, поэтому туту применяем семафор
                //Получаем разрешение (если есть свободные)
                    semaphore.acquire();
                System.out.println(ConsoleColors.BLUE  + c.getName() + " начал этап: " + description);

                Thread.sleep(length / c.getSpeed() * 1000);
                //Возвращаем разрешение
                    semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(ConsoleColors.PURPLE  + c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
