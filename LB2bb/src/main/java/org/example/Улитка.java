package org.example;
public class Улитка implements Member{

    private String name;
    private int maxRunDistance;



    public Улитка(String name, int maxRunDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;

    }
    @Override
    public boolean run(int dist) {
        if(dist <= maxRunDistance) return true;
        else return false;
    }

    @Override
    public boolean jump(int heigth) {
        System.out.println(name + " не прыгающее");
            return false;

    }


    public String getName(){
        return name;
    }
}
