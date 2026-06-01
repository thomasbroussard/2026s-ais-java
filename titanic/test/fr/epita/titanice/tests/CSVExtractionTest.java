package fr.epita.titanice.tests;

import fr.epita.titanic.datamodel.Passenger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
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
        List<Passenger> passengers = new ArrayList<>();
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            String name = parts[0].trim();
            String passengerClass = parts[1].trim();
            if (parts[2] == null || parts[2].isBlank()){
                parts[2] = "0";
            }
            String part = parts[2].trim();
            Double age = Double.parseDouble(part);
            String sex = parts[3].trim();
            if (parts[4] == null){
                parts[4] = "0";
            }
            Integer survived = Integer.parseInt(parts[4].trim());

            Passenger passenger = new Passenger(name, passengerClass, age, sex, survived);
            passengers.add(passenger);
        }
        System.out.println("passengers loaded : " +  passengers.size());
        scanner.close();

    }
}
