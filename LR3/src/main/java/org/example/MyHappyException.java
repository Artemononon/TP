package org.example;

public class MyHappyException extends RuntimeException {
    private int row;
    private int column;
    private String value;

    public MyHappyException(int row, int column, String value) {
        super("Счастливое число \"" + value + "\" в ячейке [" + (row+1) + "][" + (column+1) + "]");
        this.row = row;
        this.column = column;
    }
}
