package fr.epita.titanice.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class CSVExtractionTest {

    public static void main(String[] args) throws IOException {
        File file = new File("./titanic/data.csv");
        if (!file.exists()){
            System.out.println("file does not exist");
            return;
        }
       // System.out.println(Files.readAllLines(file.toPath()));
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while (scanner.hasNext()){
            String line = scanner.nextLine();

        }
        scanner.close();

    }
}
