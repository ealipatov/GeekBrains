package lesson11_2;

import java.util.ArrayList;

public class Task11_2 {

    public static void main(String[] args) {

        ArrayList<Apple> apples = new ArrayList<>();
        ArrayList<Orange> oranges = new ArrayList<>();
       for (int i = 0; i < 15; i++){
            apples.add(new Apple());
            oranges.add(new Orange());
        }


        Box boxApple01 = new Box(apples, Apple.NAME);
        Box boxOrange02 = new Box(oranges, Orange.NAME);
        Box boxApple03 = new Box<>(new ArrayList<Apple>(), Apple.NAME);

        System.out.println(boxOrange02);
        System.out.println(boxApple01);
        System.out.println(boxApple03);

        boxApple01.compare(boxOrange02);
        boxApple01.compare(boxApple03);

        boxApple01.transfer(boxApple03);
        boxOrange02.transfer(boxApple03);

        boxApple01.add(15);
        System.out.println(boxApple01);

        boxApple01.compare(boxApple03);

        boxOrange02.add(5);
        System.out.println(boxOrange02);

    }
}

interface FruitData{

    double getWeightOne();
}

abstract class Fruit implements FruitData {
}

class Apple extends Fruit{
    final static double WEIGHT = 1.0f;
    final static String NAME = "Apple";

    @Override
    public double getWeightOne() {
        return WEIGHT;
    }

}

class Orange extends Fruit{
    final static double WEIGHT = 1.5f;
    final static String NAME = "Orange";

    @Override
    public double getWeightOne() {
        return WEIGHT;
    }

}

class Box<T extends Fruit> {
    Apple apple;
    Orange orange;
    private ArrayList <T> fruit;
    double weight;
    private String nameFruit;

    public Box(ArrayList<T> fruit, String name) {
        this.nameFruit = name;
        this.fruit = fruit;
        this.weight = getWeight();
    }

    @Override
    public String toString() {
        return "Ящик {"+ nameFruit + ", вес ящика: " + getWeight() +'}' + fruit.getClass().getSimpleName();
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public double getWeight(){
        if(fruit.size() != 0) {
            return fruit.size() * fruit.get(0).getWeightOne();
        } else return 0;
    }

    public boolean compare(Box box){
        if(box.getWeight() == this.getWeight()){
            System.out.printf("Ящики %s весом %.2f и %s весом %.2f равны по весу \n",
                    box.nameFruit, box.getWeight(), this.nameFruit, this.getWeight());
            return true;
        } else{
            System.out.printf("Вес ящиков %s весом %.2f и %s весом %.2f разный.\n",
                    box.nameFruit, box.getWeight(), this.nameFruit, this.getWeight());
            return false;
        }
    }

    //TODO Переработать проверку совместимости фруктов через ограничекние(не по имени).
    public void transfer(Box box){
        if(this.getNameFruit().equals(box.getNameFruit())) {
            box.fruit.addAll(this.fruit);
            this.fruit.clear();
        } else System.out.printf("Нельзя пересыпать %s в %s. Это разные фрукты. \n"
                ,this.getNameFruit(), box.getNameFruit());
    }

    // TODO Разработать метод добавления фрукта в ящик с проверкой через ограничение (не по имени).
    public void add(int quantity){
        Apple apple = new Apple();
        Orange orange = new Orange();

        if(this.nameFruit == Apple.NAME){
            for(int i = 0; i < quantity; i++){
                fruit.add((T) apple);
            }
        } else {
            for(int i = 0; i < quantity; i++){
                fruit.add((T) orange);
            }
        }

    }

}