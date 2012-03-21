package com.folkol.compiler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class MyCompilerRunner {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream(args[0].replace(".java", ".class"));
            com.folkol.compiler.Javac compiler = new com.folkol.compiler.Javac();
            byte[] compiledClass = compiler.compile(args[0]);
            fos.write(compiledClass);
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException : " + ex);
        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe);
        }
    }
}