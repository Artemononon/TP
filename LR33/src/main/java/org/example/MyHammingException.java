package org.example;

class MyHammingException extends RuntimeException {
    private int row;
    private int column;
    private String value;

    public MyHammingException(int row, int column, String value) {
        super("Не принадлежит последовательности Хемминга число \"" + value + "\" в ячейке [" + (row+1) + "][" + (column+1) + "]");
        this.row = row;
        this.column = column;
    }
}