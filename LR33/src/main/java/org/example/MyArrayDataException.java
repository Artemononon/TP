package org.example;

class MyArrayDataException extends RuntimeException {
    private int row;
    private int column;
    private String value;

    public MyArrayDataException(int row, int column, String value) {
        super("Неверные данные \"" + value + "\" в ячейке [" + (row+1) + "][" + (column+1) + "]");
        this.row = row;
        this.column = column;
    }
}