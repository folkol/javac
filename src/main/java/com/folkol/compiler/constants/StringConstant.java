package com.folkol.compiler.constants;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

class StringConstant extends Constant {
    private String string = new String("");

    StringConstant(String s) {
        tag[0] = 1;
        this.setString(s);
    }

    @Override
    void writeData(ByteArrayOutputStream os) throws UnsupportedEncodingException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeUTF(getString());
        dos.flush();
        byte[] modifiedUTF8String = baos.toByteArray();

        baos = new ByteArrayOutputStream();
        dos = new DataOutputStream(baos);
        dos.writeShort(modifiedUTF8String.length);
        dos.flush();
        byte[] stringSize = baos.toByteArray();

        os.write(stringSize);
        os.write(modifiedUTF8String);
    }

    public void setString(String s) {
        this.string = s;
    }

    public String getString() {
        return string;
    }

    @Override
    int size() throws UnsupportedEncodingException {
        return 1 + 2 + string.getBytes("UTF8").length;
    }
}