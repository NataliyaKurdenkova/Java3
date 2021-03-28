package HW7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.reflect.InvocationTargetException;

import java.util.*;

/*
Создать класс, который может выполнять «тесты»,
в качестве тестов выступают классы с наборами методов с аннотациями @Test.
Для этого у него должен быть статический метод start(),
которому в качестве параметра передается или объект типа Class,
или имя класса. Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite,
если такой имеется, далее запущены методы с аннотациями @Test,
а по завершению всех тестов – метод с аннотацией @AfterSuite.
К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый,
то порядок не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать
в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».
 */
public class Main {
    public static int countBef = 0;
    public static int countAf = 0;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class testMy = MyTest2.class;
        Object testObj = testMy.newInstance();
        Method[] methods = testMy.getDeclaredMethods();

        List<Method> list = new ArrayList<>(Arrays.asList(methods));
        System.out.println(list);
        // проверка на несколько BeforeSuite и AfterSuite
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                countBef++;
                list.remove(m);
                if (countBef > 1) {
                    throw new RuntimeException("Больше одного метода с аннотацией BeforeSuite");
                }
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                countAf++;
                list.remove(m);
                if (countAf > 1) {
                    throw new RuntimeException("Больше одного метода с аннотацией AfterSuite");

                }
            }

        }
        //сортировка

        for (int i = 0; i < methods.length; i++)
            list.sort(new Comparator<Method>() {
                @Override
                public int compare(Method m1, Method m2) {
                    return m1.getAnnotation(Test.class).priority() - m2.getAnnotation(Test.class).priority();


                }
            });
        System.out.println(list);
//запуск

        for (Method m : methods) {
            try {
                if (m.isAnnotationPresent(BeforeSuite.class)) {
                    if (countBef != 0) {
                        System.out.println(m.getAnnotation(BeforeSuite.class).annotationType());
                        m.invoke(testObj, null);
                    }
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

        for (Method m1 : list) {
            try {

                System.out.println(m1.getAnnotation(Test.class).annotationType());
                m1.invoke(testObj, null);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

        for (Method m2 : methods) {
            try {
                if (m2.isAnnotationPresent(AfterSuite.class)) {
                    if (countAf != 0) {
                        System.out.println(m2.getAnnotation(AfterSuite.class).annotationType());

                        m2.invoke(testObj, null);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }

}



