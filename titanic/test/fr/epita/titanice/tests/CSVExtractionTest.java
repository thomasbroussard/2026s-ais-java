package fr.epita.titanice.tests;

import fr.epita.titanic.datamodel.Passenger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

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

        Map<String, Long> collect = passengers
                .stream()
                .collect(Collectors.groupingBy(Passenger::getpClass, Collectors.counting()));

        Map<String, Long> distribution = new HashMap<>();
        for (Passenger p: passengers){
            String currentPClass = p.getpClass();
            Long count = distribution.get(currentPClass);
            if (count == null){
                count = 0L;
            }else{
                count ++;
            }
            distribution.put(currentPClass, count);
        }

        Map<Integer, Long> distributionSurvivedAmong3rd = passengers.stream()
                .filter(p -> "3rd".equals(p.getpClass()))
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(Passenger::getSurvived), Collectors.counting());

        System.out.println(distribution);

        System.out.println(collect);
    }
}
