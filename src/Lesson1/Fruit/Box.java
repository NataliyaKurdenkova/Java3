package Lesson1.Fruit;
/*(вес яблока - 1.0f, апельсина - 1.5f)*/

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.Arrays;


public class Box<T extends Fruit> {
    ArrayList<Fruit> boxFruit;

    // пустая коробка
    public Box() {
        this.boxFruit = new ArrayList<>(Arrays.asList());
    }

    //коробка сразу с фруктами
    public Box(T... fruit) {
        this.boxFruit = new ArrayList<>(Arrays.asList(fruit));
    }


    //метод взвешивание коробки
    public float getWeight() {
        float weightBoxAll = 0.0f;
        for (int i = 0; i < boxFruit.size(); i++) {
            weightBoxAll += boxFruit.get(i).getWeight();
        }
        return weightBoxAll;
    }

    //метод добавления фрукта в коробку
    public ArrayList<Fruit> addFruit(T fruit) {
        boxFruit.add(fruit);
        return boxFruit;
    }


    //метод сравнения коробок
    public boolean compare(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.1f;
    }

    //метод пересыпания фрутов
    public void put(Box<T> box) {
        if (box == this)
            return;
        box.boxFruit.addAll(this.boxFruit);
        this.boxFruit.clear();

    }

    //печать
    public void printBox() {
        System.out.println(boxFruit.toString());
    }

}
