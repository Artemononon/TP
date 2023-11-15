package org.example;

class MyHappingException extends RuntimeException {
    private int row;
    private int column;
    private String value;

    public MyHappingException(int row, int column, String value) {
        super("Не принадлежит последовательности Хемминга и является Счастливым числом \"" + value + "\" в ячейке [" + (row+1) + "][" + (column+1) + "]");
        this.row = row;
        this.column = column;
    }
}