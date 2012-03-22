package com.folkol.compiler.constants;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public abstract class Constant {
    byte[] tag = new byte[1];

    public void write(ByteArrayOutputStream os) throws UnsupportedEncodingException, IOException {
        writeTagByte(os);
        writeData(os);
    }

    private void writeTagByte(ByteArrayOutputStream os) {
        // tag '1' -> UTF-8 string
    }

    void writeData(ByteArrayOutputStream os) throws UnsupportedEncodingException, IOException {
    }

    abstract int size() throws UnsupportedEncodingException;
}