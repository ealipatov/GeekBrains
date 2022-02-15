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

        Box<Apple> box01 = new Box(apples, "Яблоки");
        Box<Orange> box02 = new Box(oranges, "Апельсины");
        Box<Apple> box03 = new Box<>(new ArrayList<Apple>(),"Яблоки");

        System.out.printf("Вес фруктов в ящике %s: %.2f\n", box02.getName(), box02.getWeight());
        System.out.printf("Вес фруктов в ящике %s: %.2f\n", box01.getName(), box01.getWeight());
        System.out.printf("Вес фруктов в ящике %s: %.2f\n", box03.getName(), box03.getWeight());

        System.out.println(box01.compare(box02));
        System.out.println(box01.compare(box03));

        box01.transfer(box03);
        box02.transfer(box03);
        box01.add(15);
        System.out.printf("Вес фруктов в ящике %s: %.2f\n", box02.getName(), box02.getWeight());
        System.out.printf("Вес фруктов в ящике %s: %.2f\n", box01.getName(), box01.getWeight());
        System.out.printf("Вес фруктов в ящике %s: %.2f\n", box03.getName(), box03.getWeight());
        System.out.println(box01.compare(box03));
        box02.add(10);
        System.out.printf("Вес фруктов в ящике %s: %.2f\n", box02.getName(), box02.getWeight());

    }
}

interface FruitData{

    double getWeightOne();
}

abstract class Fruit implements FruitData {
    double weightOne;
    double weight;
    int quantity;

}

class Apple extends Fruit{
    final double weightOne = 1.0f;

    @Override
    public double getWeightOne() {
        return weightOne;
    }
}

class Orange extends Fruit{
    final double weightOne = 1.5f;

    @Override
    public double getWeightOne() {
        return weightOne;
    }
}

class Box<T extends Fruit> {
    private ArrayList <T> fruit;
    private double weightOne;
    private String name;

    public Box(ArrayList<T> fruit, String name) {
        this.name = name;
        this.fruit = fruit;
        this.weightOne = 0;
    }


    public String getName() {
        return name;
    }

    public double getWeight(){
        if(fruit.size() != 0) {
            double sum = fruit.size() * fruit.get(0).getWeightOne();
            return sum;
        } else return 0;
    }

    public boolean compare(Box box){
        if(box.getWeight() == this.getWeight()){
            return true;
        } else
        return false;
    }

    //TODO Переработать проверку совместимости фрцктов через ограничекние(не по имени).
    public void transfer(Box box){
        if(this.name == box.name) {
            box.fruit.addAll(this.fruit);
            this.fruit.clear();
        } else System.out.println("Нельзя пересыпать разные фрукты");

    }

    // TODO Разработать метод добавления фрукта в ящик с проверкой через ограничение (не по имени).
    public void add(int quantuty){
        Apple apple = new Apple();
        Orange orange = new Orange();

        if(this.name == "Яблоки"){
            for(int i = 0; i < quantuty; i++){
                fruit.add((T) apple);
            }
        } else fruit.add((T) orange);

    }

}