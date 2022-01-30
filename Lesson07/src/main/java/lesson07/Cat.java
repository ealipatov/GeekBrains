package lesson07;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    static int counter;

    {
        //satiety = false;
        ++counter;
    }

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;

    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void eat(Plate plate, int c){
        if(plate.decreaseFood(appetite, c)) {
            System.out.printf("Кот %s покушал из тарелки %s и сыт.\n", name, plate.getName());
            setSatiety(true);
            System.out.print("Остаток корма: ");
            plate.info();
        } else
            System.out.println("Кот не покушал и голоден.");
    }

    public void InfoCat(){
        System.out.printf("Пришел покушать кот %s, аппетит у кота: %d\n", name, appetite);
    }

    public void InfoSatietyCat(){
        if(satiety)
            System.out.printf("Кот %s сыт.\n", name);
        else
            System.out.printf("Кот %s голоден.\n", name);
    }
}
