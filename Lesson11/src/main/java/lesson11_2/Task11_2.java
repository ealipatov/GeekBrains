package lesson11_2;

public class Task11_2 {

    public static void main(String[] args) {


    }
}

interface FruitData{
    double getWeight(int quantity);
}

abstract class Fruit implements FruitData {


    protected double weight;


}

class Apple extends Fruit{
    final double weight = 1.0f;

    @Override
    public double getWeight(int quantity) {
        double sum = weight * quantity;
        return sum;
    }
}

class Orange extends Fruit{
    final double weight = 1.5f;

    @Override
    public double getWeight(int quantity) {
        double sum = weight * quantity;
        return sum;

    }
}

class Box<T extends Fruit> {
    public Box() {
    }

    public void compare(){

    }

}