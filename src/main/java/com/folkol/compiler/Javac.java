package com.folkol.compiler;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.folkol.compiler.constants.Constant;

public class Javac {
    List<Constant> constantPool = new ArrayList<Constant>();
    byte[] fakeConstantPool = {(byte) 0x00, (byte) 0x0F, (byte) 0x0A, (byte) 0x00, (byte) 0x03, (byte) 0x00, (byte) 0x0C, (byte) 0x07, (byte) 0x00, (byte) 0x0D, (byte) 0x07, (byte) 0x00, (byte) 0x0E, (byte) 0x01, (byte) 0x00, (byte) 0x06, (byte) 0x3C, (byte) 0x69, (byte) 0x6E, (byte) 0x69, (byte) 0x74, (byte) 0x3E, (byte) 0x01, (byte) 0x00, (byte) 0x03, (byte) 0x28, (byte) 0x29, (byte) 0x56, (byte) 0x01, (byte) 0x00, (byte) 0x04, (byte) 0x43, (byte) 0x6F, (byte) 0x64, (byte) 0x65, (byte) 0x01, (byte) 0x00, (byte) 0x0F, (byte) 0x4C, (byte) 0x69, (byte) 0x6E, (byte) 0x65, (byte) 0x4E, (byte) 0x75, (byte) 0x6D, (byte) 0x62, (byte) 0x65, (byte) 0x72, (byte) 0x54, (byte) 0x61, (byte) 0x62, (byte) 0x6C, (byte) 0x65, (byte) 0x01, (byte) 0x00, (byte) 0x03, (byte) 0x61, (byte) 0x64, (byte) 0x64, (byte) 0x01, (byte) 0x00, (byte) 0x05, (byte) 0x28, (byte) 0x49, (byte) 0x49, (byte) 0x29, (byte) 0x49, (byte) 0x01, (byte) 0x00, (byte) 0x0A, (byte) 0x53, (byte) 0x6F, (byte) 0x75, (byte) 0x72, (byte) 0x63, (byte) 0x65, (byte) 0x46, (byte) 0x69, (byte) 0x6C, (byte) 0x65, (byte) 0x01, (byte) 0x00, (byte) 0x0D, (byte) 0x41, (byte) 0x64, (byte) 0x64, (byte) 0x69, (byte) 0x74, (byte) 0x69, (byte) 0x6F, (byte) 0x6E, (byte) 0x2E, (byte) 0x6A, (byte) 0x61, (byte) 0x76, (byte) 0x61, (byte) 0x0C, (byte) 0x00, (byte) 0x04, (byte) 0x00, (byte) 0x05, (byte) 0x01, (byte) 0x00, (byte) 0x08, (byte) 0x41, (byte) 0x64, (byte) 0x64, (byte) 0x69, (byte) 0x74, (byte) 0x69, (byte) 0x6F, (byte) 0x6E, (byte) 0x01, (byte) 0x00, (byte) 0x10, (byte) 0x6A, (byte) 0x61, (byte) 0x76, (byte) 0x61, (byte) 0x2F, (byte) 0x6C, (byte) 0x61, (byte) 0x6E, (byte) 0x67, (byte) 0x2F, (byte) 0x4F, (byte) 0x62, (byte) 0x6A, (byte) 0x65, (byte) 0x63, (byte) 0x74, (byte) 0x00, (byte) 0x21, (byte) 0x00, (byte) 0x02, (byte) 0x00, (byte) 0x03, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x02, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x04, (byte) 0x00, (byte) 0x05, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x06, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x1D, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x05, (byte) 0x2A, (byte) 0xB7, (byte) 0x00, (byte) 0x01, (byte) 0xB1, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x07, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x06, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x08, (byte) 0x00, (byte) 0x09, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x06, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x1C, (byte) 0x00, (byte) 0x02, (byte) 0x00, (byte) 0x03, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x04, (byte) 0x1B, (byte) 0x1C, (byte) 0x60, (byte) 0xAC, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x07, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x06, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x03, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x0A, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x02, (byte) 0x00, (byte) 0x0B};

    public byte[] compile(String srcFileName) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        File src = new File(srcFileName);
        parseSourceFile(src);
        writeMagicNumber(os);
        writeClassFileVersion(os);
        writeConstantPool(os);
        writeAccessFlags(os);
        writeSuperClassName(os);
        writeSuperClassName(os);
        writeInterfaces(os);
        writeMethods(os);
        writeMethods(os);
        writeAttributes(os);
        // Magic Number: 0xCAFEBABE
        // Version of Class File Format: the minor and major versions of the
        // class file
        // Constant Pool: Pool of constants for the class
        // Access Flags: for example whether the class is abstract, static, etc.
        // This Class: The name of the current class
        // Super Class: The name of the super class
        // Interfaces: Any interfaces in the class
        // Fields: Any fields in the class
        // Methods: Any methods in the class
        // Attributes: Any attributes of the class (for example the name of the
        // sourcefile, etc.)
        return os.toByteArray();
    }

    private void parseSourceFile(File src) {
        // TODO Auto-generated method stub
    }

    private void writeMagicNumber(ByteArrayOutputStream os) throws IOException {
        byte[] magicNumber = new byte[4];
        magicNumber[0] = (byte) 0xca;
        magicNumber[1] = (byte) 0xfe;
        magicNumber[2] = (byte) 0xba;
        magicNumber[3] = (byte) 0xbe;
        os.write(magicNumber);
    }

    private void writeClassFileVersion(ByteArrayOutputStream os) throws IOException {
        byte[] minorVersion = new byte[2];
        minorVersion[0] = 0;
        minorVersion[1] = 0;
        // 0x32 = java 1.6
        byte[] majorVersion = new byte[2];
        majorVersion[0] = 0;
        majorVersion[1] = 0x32;
        os.write(minorVersion);
        os.write(majorVersion);
    }

    private void writeConstantPool(ByteArrayOutputStream os) throws IOException {
        // Write constant pool count, at least one higher than the actual number...
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeShort(constantPool.size() + 1);
        dos.flush();
        byte[] bytes = baos.toByteArray();

        // Write constant pool count
//        os.write(bytes);

        // Write the constants, one by one.
        for (Constant c : constantPool) {
            c.write(os);
        }


        // Fake constant pool bytes

//        byte[] fakeConstantPool = new byte[] {00 0F 0A 00 03 00 0C 07 00 0D 07 00 0E 01 00 06 3C 69 6E 69 74 3E 01 00 03 28 29 56 01 00 04 43 6F 64 65 01 00 0F 4C 69 6E 65 4E 75 6D 62 65 72 54 61 62 6C 65 01 00 03 61 64 64 01 00 05 28 49 49 29 49 01 00 0A 53 6F 75 72 63 65 46 69 6C 65 01 00 0D 41 64 64 69 74 69 6F 6E 2E 6A 61 76 61 0C 00 04 00 05 01 00 08 41 64 64 69 74 69 6F 6E 01 00 10 6A 61 76 61 2F 6C 61 6E 67 2F 4F 62 6A 65 63 74 00 21 00 02 00 03 00 00 00 00 00 02 00 01 00 04 00 05 00 01 00 06 00 00 00 1D 00 01 00 01 00 00 00 05 2A B7 00 01 B1 00 00 00 01 00 07 00 00 00 06 00 01 00 00 00 01 00 01 00 08 00 09 00 01 00 06 00 00 00 1C 00 02 00 03 00 00 00 04 1B 1C 60 AC 00 00 00 01 00 07 00 00 00 06 00 01 00 00 00 03 00 01 00 0A 00 00 00 02 00 0B};
        os.write(fakeConstantPool);
    }

    private void writeAccessFlags(ByteArrayOutputStream os) {
        // TODO Auto-generated method stub
    }

    private void writeSuperClassName(ByteArrayOutputStream os) {
        // TODO Auto-generated method stub
    }

    private void writeInterfaces(ByteArrayOutputStream os) {
        // TODO Auto-generated method stub
    }

    private void writeMethods(ByteArrayOutputStream os) {
        // TODO Auto-generated method stub
    }

    private void writeAttributes(ByteArrayOutputStream os) {
        // TODO Auto-generated method stub
    }
}