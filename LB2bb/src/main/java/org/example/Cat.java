package org.example;
public class Cat implements Member{

    private String name;
    int maxRunDistance;
    private int maxJumpHeight;


    public Cat(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }
    @Override
    public boolean run(int dist) {
        if(dist <= maxRunDistance) return true;
        else return false;
    }

    @Override
    public boolean jump(int heigth) {
        if(heigth <= maxJumpHeight) return true;
        else if(superJump(name))return true;
        return false;
    }

    public String getName(){
        return name;
    }
}
