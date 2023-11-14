package org.example;

public enum Walll {
    LOW(1),
    SHORT(2),
    HIGH(3);

    private final int height;

    Walll(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
