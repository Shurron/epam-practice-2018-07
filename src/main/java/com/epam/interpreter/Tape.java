package com.epam.interpreter;

public class Tape {
    private char[] arr;
    private int pointer;

    public Tape(int tapeLength) {
        if (tapeLength < 1)
            throw new IllegalArgumentException("tapeLength can't be negative or zero");

        arr = new char[tapeLength];
        pointer = 0;
    }

    public Tape() {
        this(30000);
    }

    public void shiftRight() {
        pointer++;

        if (pointer == arr.length) {
            pointer = 0;
        }
    }

    public void shiftLeft() {
        pointer--;

        if (pointer == -1) {
            pointer = arr.length - 1;
        }
    }

    public void increment() {
        arr[pointer]++;

        if (arr[pointer] == 256) {
            arr[pointer] = 0;
        }
    }

    public void decrement() {
        arr[pointer]--;

        if (arr[pointer] == Character.MAX_VALUE) {
            arr[pointer] = 255;
        }
    }

    public char getValue() {
        return arr[pointer];
    }

    public void setValue(char newValue) {
        arr[pointer] = newValue;
    }
}
