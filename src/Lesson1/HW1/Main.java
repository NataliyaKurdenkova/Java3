package Lesson1.HW1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        Object[] obj=new Object[]{1,"qwerty",85,"as",6};
        System.out.println(Arrays.toString(obj));
        swap(obj,1,3);
        System.out.println(Arrays.toString(obj));
        System.out.println(objectToArrayList(obj));
    }
    /*
    1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
     */
    public static Object swap(Object[] obj,int i,int j){
    Object o=obj[i];
    obj[i]=obj[j];
    obj[j]=o;
    return obj;
    }

    /*
    2. Написать метод, который преобразует массив в ArrayList;
     */
    public static Collection<Object> objectToArrayList(Object[] obj){
        return new ArrayList<>(Arrays.asList(obj));
    }
}

