package com.chip8.emulator;

public class Main {

    public static void main(String[] args) {
        Memory memory = new Memory();
        Loader loader = new Loader("IBM", memory);

        loader.readFile();
        loader.loadToMemory();
    }
}
