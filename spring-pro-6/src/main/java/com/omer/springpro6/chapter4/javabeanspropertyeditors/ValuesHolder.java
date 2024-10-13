package com.omer.springpro6.chapter4.javabeanspropertyeditors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class ValuesHolder {
    List<String> stringList;
    InputStream inputStream;

    public ValuesHolder(List<String> stringList) {
        this.stringList = List.of("Mayer", "Psihoza", "Mazikeen");
        try {
            this.inputStream = new FileInputStream(
                System.getProperty("java.io.tmpdir")
                    + System.getProperty("file.separator")
                    + "test.txt"
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // we are not interested in this exception
        }
    }

    public static void main(String... args) throws Exception {
        File baseDir = new File(System.getProperty("java.io.tmpdir"));
        Path path = Files.createFile(Path.of(baseDir.getAbsolutePath(), "test.txt"));
        Files.writeString(path, "Hello World!");
        path.toFile().deleteOnExit();
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(ValuesHolder.class, DiverseValuesContainer.class);
        ctx.refresh();
        ctx.close();
    }

    public List<String> getStringList() {
        return stringList;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
