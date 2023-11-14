
package org.example;

public class Wall implements Obstacle {
    private final int maxJumpHeight;

    public Wall(Walll walll)
    {
        this.maxJumpHeight = walll.getHeight();
    }

    public boolean isCan(Member member) {
        if (member.jump(maxJumpHeight)) {
            System.out.println(member.getName() + " смог перепрыгнуть " + maxJumpHeight + "м.");
            return true;
        } else {
            System.out.println(member.getName() + " не смог перепрыгнуть " + maxJumpHeight + "м.");
            return false;
        }
    }
}
