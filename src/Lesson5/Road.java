package Lesson5;

public class Road extends Stage{
    String n;
    int count=0;
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";

    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            if((length==40)&&(count==0)){
                c.setFlagWin(true);
                count++;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
