package Lesson1.Fruit;

import java.util.Arrays;

/*
3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
 */
public class Main {
    public static void main(String[] args) {

        //с апельсинами
        Orange fr = new Orange();
        Orange fr5 = new Orange();
        Orange fr9 = new Orange();
        Box<Orange> box1 = new Box<>(fr, fr5, fr9);
        Orange fr2 = new Orange();
        box1.addFruit(fr2);
        System.out.println(box1.getWeight());
        box1.printBox();

        //с яблоками
        Apple fr3 = new Apple();
        Box<Apple> box2 = new Box<>(fr3);
        Apple fr4 = new Apple();
        box2.addFruit(fr4);
        System.out.println(box2.getWeight());
        box2.printBox();
        // Orange fr8=new Orange();
        // box2.addFruit(fr8);
        // System.out.println(box2.getWeight());
        // box1.printBox();

        //пустая коробка
        Box<Fruit> box = new Box<>();
        System.out.println(box.getWeight());
        box.printBox();
        Apple fr6 = new Apple();
        box.addFruit(fr6);
        System.out.println(box.getWeight());
        box.printBox();
        Orange fr7 = new Orange();
        box.addFruit(fr7);
        System.out.println(box.getWeight());
        box.printBox();

        System.out.println(box.compare(box2));


        Apple fr10 = new Apple();
        Box<Apple> box4 = new Box<>(fr10);
        Apple fr11 = new Apple();
        box4.addFruit(fr11);
        System.out.println(box4.getWeight());
        box4.printBox();
        System.out.println(box2.compare(box4));

        box4.put(box2);
        box4.printBox();
        box2.printBox();
    }
}
