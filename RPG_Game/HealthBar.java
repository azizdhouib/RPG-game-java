//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// health
// File description:
//      health
//
//package day7.day7_1;

public class HealthBar extends Bar {

    private boolean dead;

    public HealthBar(String name, int currentPoint, int maxPoint) {
        super(name, currentPoint, maxPoint);
        this.dead = false;
    }

    @Override
    public void addCurrentPoint(int point) {
        if (dead)
            return;
        currentPoint += point;
        if (this.currentPoint > this.maxPoint)
            currentPoint = maxPoint;
    }

    @Override
    public void removeCurrentPoint(int point) {
        if (dead)
            return;
        currentPoint -= point;
        if (currentPoint <= 0){
            currentPoint = 0;
            dead = true;
        }
    }
    public boolean isDead(){

        return this.dead;
    }
    @Override
    public void addMaxPoint(int point) {
        if (dead)
            return;
        maxPoint += point;

    }

    @Override
    public void removeMaxPoint(int point) {
        if (dead)
            return;
        maxPoint -= point;
    }

}
