package org.example;

public enum TreadmillL {
    Short(50),
    Middle(150),
    Long(200);
    private final int val;
    public int getVal() {
        return val;
    }
    TreadmillL(int val) {
        this.val = val;
    }
}
