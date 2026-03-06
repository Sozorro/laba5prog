package builders;

import java.util.Scanner;

import enums.Difficulty;
import manager.Coordinates;

public class LabWorkBuilder extends Builder {
    public LabWork makeLabWork() {
        return new LabWork(
            makeString("Введите название работы"), 
            makeCoordinates("coordinates"), 
            makeInt("minimalPoint"), 
            makeInt("personalQualitiesMinimum"),
            makeString("description"), 
            makeDifficulty("difficulty"), 
            makePerson("author")
        );
    }

    public LabWork makeLabWork(String name, Coordinates coordinates, int minimalPoint, int personalQualitiesMinimum,
        String description, Difficulty difficulty, Person author) {

        return new LabWork(name, coordinates, minimalPoint, personalQualitiesMinimum, description, difficulty, author);
    }

    private Coordinates makeCoordinates(String s) {
        // вывод текста и получение Coordinates
        Coordinates str;
        System.out.println(s);
        return str;
    }
    private Difficulty makeDifficulty(String s) {
        // вывод текста и получение Difficulty
        Difficulty str = Difficulty.HARD;
        System.out.println(s);
        return str;
    }
    private Person makePerson(String s) {
        PersonBuilder personBuilder = new PersonBuilder();
        // вывод текста и получение Person
        Person str = personBuilder.makePerson();
        System.out.println(s);
        return str;
    }

}
