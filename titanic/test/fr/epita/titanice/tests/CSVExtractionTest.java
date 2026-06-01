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
            String[] parts = line.split(";");
            String name = parts[0];
            String passengerClass = parts[1];
            if (parts[2] == null){
                parts[2] = "0";
            }
            String part = parts[2];
            Double age = Double.parseDouble(part);
            String sex = parts[3];
            if (parts[4] == null){
                parts[4] = "0";
            }
            Integer survived = Integer.parseInt(parts[4]);

        }
        scanner.close();

    }
}
