package lesson08;

public class Robot implements Runner {

    private final String name;
    private final int maxLength;
    private final int maxHeight;

    static int count = 0;

    {
        count++;
    }

    public Robot(String name, int getMaxLength, int getMaxHeight){
        this.name = name;
        this.maxLength = getMaxLength;
        this.maxHeight = getMaxHeight;
    }


    public void info(){
        System.out.printf("Участник: %s. Максимальная дистранция бега %d метров, высота прыжка %d см.\n",
                name,  maxLength, maxHeight);

    }

    @Override
    public boolean run(int distance) {
        if(maxLength >= distance) {
            System.out.printf("%s пробежал дистанцию %d метров.\n", name, distance);
            return true;
        }
        else {
            System.out.printf("%s не смог пробежать дистанцию %d метров.\n", name, distance);
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if(maxHeight >= height){
            System.out.printf("%s перепрыгнул через прерятствие высотой %d см.\n", name, height);
            return true;
        }
        else {
            System.out.printf("%s не смог перепрыгнуть через стену %d см.\n", name, height);
            return false;
        }
    }
}

