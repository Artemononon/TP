package org.example;

public class Treadmill implements Obstacle {
    int dist;

    Treadmill(int dist) {
        this.dist = dist;
    }
    @Override
    public boolean isCan(Member member)
    {
        if (member.run(dist))
        {
            System.out.println(member.getName() + " пробежал");
            return true;
        }
        else
        {
            System.out.println(member.getName() + " не пробежал");
            return false;
        }
    }
}
