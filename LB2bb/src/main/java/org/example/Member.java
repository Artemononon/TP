package org.example;

public interface Member {

    default boolean superJump(String name)
    {
        int extraJumpCount = Main.getExtraJumpCount();
        if (extraJumpCount > 0) {
            Main.decrementExtraJumpCount();
            System.out.println(name + " использовал суперпрыжок. Осталось " + extraJumpCount);
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
