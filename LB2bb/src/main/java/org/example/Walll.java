package org.example;

public enum Walll {
    LOW(1),
    SHORT(2),
    HIGH(3);
    private int height;
    public int getVasota(){
        return height;
    }
    Walll(int vasota){
        this.height = vasota;
    }

}
