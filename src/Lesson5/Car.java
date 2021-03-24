package Lesson5;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static boolean flagWin;
    public static void setFlagWin(boolean flagWin) {
        Car.flagWin = flagWin;
    }




    private CyclicBarrier cb;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;



    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public  boolean getFlagWin() {
        return flagWin;
    }
    public Car(Race race, int speed,CyclicBarrier cb) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb=cb;
        this.flagWin=false;
    }
    @Override
    public void run() {

        try {

            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));

            System.out.println(this.name + " готов");
            cb.await();
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }
}
