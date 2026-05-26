package fr.epita.biostats;

import fr.epita.biostats.datamodel.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testIO {

    public static void main(String[] args) throws FileNotFoundException {
        //sampleInteractionWithConsole();

        Scanner fileScanner = new Scanner(new File("biostats/biostats.csv"));
        fileScanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();
            System.out.println(line);
            String[] parts = line.split(",");

            Person person = new Person();

            String name = processString(parts[0]);
            String sex = processString(parts[1]);

            int age = Integer.parseInt(processString(parts[2]));
            int height = Integer.parseInt(processString(parts[3]));
            int weight = Integer.parseInt(processString(parts[4]));

            person.setName(name);
            person.setSex(sex);
            person.setAge(age);
            person.setHeight(height);
            person.setWeight(weight);

            people.add(person);

        }

        System.out.println(people);

    }

    private static String processString(String name) {
        name = name.replace("\"", "");
        name = name.replace(" ", "");
        return name;
    }

    private static void sampleInteractionWithConsole() {
        String question = "Bonjour, comment allez vous ?";

        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();

        System.out.println(response);
    }
}
