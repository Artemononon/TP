package org.example;

public class Treadmill implements Obstacle {
    private final int dist;
    public Treadmill(TreadmillL dor) {
        this.dist = dor.getVal();
    }
    @Override
    public boolean isCan(Member member)
    {
        if (member.run(dist))
        {
            System.out.println(member.getName() + " пробежал " + dist + "м.");
            return true;
        }
        else
        {
            System.out.println(member.getName() + " не пробежал " + dist + "м.");
            return false;
        }
    }
}
