package fr.epita.biostats;

import fr.epita.biostats.datamodel.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testIO {

    public static void main(String[] args) throws FileNotFoundException {
        //sampleInteractionWithConsole();

        Scanner fileScanner = new Scanner(new File("biostats/biostats.csv"));

        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();
            System.out.println(line);
            String[] parts = line.split(",");
            System.out.println(parts[0]);

            Person person = new Person();

            person.setName(parts[0]);

        }

    }

    private static void sampleInteractionWithConsole() {
        String question = "Bonjour, comment allez vous ?";

        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();

        System.out.println(response);
    }
}
