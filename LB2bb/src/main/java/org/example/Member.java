package org.example;

public interface Member {

    default boolean superJump(String name)
    {
        int SuperJumpCount = Main.getSuperJump();
        if (SuperJumpCount >= 0) {
            Main.decrementSuperJumpCount();
            System.out.println(name + " использовал суперпрыжок. Осталось " + SuperJumpCount);
            return true;
        }
        else
        {
            System.out.println(name + " больше нельзя использовать суперпрыжок.");
            return false;
        }
    }
    boolean run(int distance);
    boolean jump(int height);
    public String getName();
}
