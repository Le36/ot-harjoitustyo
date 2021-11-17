package com.chip8.emulator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Loader {

    private byte[] bytes;
    private String name;
    private Memory memory;

    public Loader(String name, Memory memory) {
        this.name = name;
        this.memory = memory;
    }

    public void readFile() {
        File rom = new File(this.name);
        try {
            bytes = Files.readAllBytes(rom.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadToMemory() {
        short address = 0x200; // Chip8 RAM starts at 0x200 / 0d512 for programs, 0x0 - 0x1FF reserved for fonts etc.
        for (byte b : bytes) {
            memory.initializeMemory(address, b);
            address++;
            //System.out.println(address);
        }
    }

}
