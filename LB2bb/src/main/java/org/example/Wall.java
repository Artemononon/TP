package org.example;

public class Wall implements Obstacle {
    int maxJumpHeight;

    Wall(int maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    public boolean isCan(Member member)
    {
        if (member.jump(maxJumpHeight))
        {
            System.out.println(member.getName() + " смог перепрыгнуть.");
            return true;
        }
        else
        {
            System.out.println(member.getName() + " не смог перепрыгнуть.");
            return false;
        }
    }
}
