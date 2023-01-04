package main.java.br.com.rtech.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractorAtributesService {

    public static List<String[]> getAtributes(String path) {
        List<String[]> atributes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))){
            scanner.nextLine();
            while (scanner.hasNext()) {
                atributes.add(scanner.nextLine().split(","));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

       return atributes;
    }
}
