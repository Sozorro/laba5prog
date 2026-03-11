package builders;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import enums.Color;
import enums.Difficulty;
import exeptions.WrongParam;
import io.Input;
import io.InputFile;
import managers.Coordinates;

public class LabWorkBuilder extends Builder {
    private static long idCounter = 1;
    
    public LabWork makeLabWork() throws ParseException {
        if (InputFile.readFile == false) {
            return new LabWork(
                new java.util.Date(),
                makeString("Введите название работы"), 
                makeCoordinates("coordinates"), 
                makeInt("minimalPoint"), 
                makeInt("personalQualitiesMinimum"),
                makeString("description"), 
                makeDifficulty("difficulty"), 
                makePerson("author")
            );
        }
        else {
            PersonBuilder personBuilder = new PersonBuilder();
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            return makeLabWork(
                formatter.parse(InputFile.getParams("Labwork", "date")), 
                InputFile.getParams("Labwork", "name"), 
                new Coordinates(Float.valueOf(InputFile.getParams("Labwork", "coordinatesX")), Float.valueOf(InputFile.getParams("Labwork", "coordinatesY"))), 
                Integer.valueOf(InputFile.getParams("Labwork", "minimalPoint")),
                Integer.valueOf(InputFile.getParams("Labwork", "personalQualitiesMinimum")),
                InputFile.getParams("Labwork", "description"), 
                Difficulty.valueOf(InputFile.getParams("Labwork", "difficulty")), 
                    personBuilder.makePerson(
                        InputFile.getParams("Labwork", "Person", "name"), 
                        Double.valueOf(InputFile.getParams("Labwork", "Person", "height")), 
                        Long.valueOf(InputFile.getParams("Labwork", "Person", "weight")), 
                        InputFile.getParams("Labwork", "Person", "passportID"), 
                        Color.valueOf(InputFile.getParams("Labwork", "Person", "hairColor"))
                    )
            );
        }
    }
    public LabWork makeLabWork(java.util.Date date, String name, Coordinates coordinates, int minimalPoint, int personalQualitiesMinimum,
        String description, Difficulty difficulty, Person author) {
        return new LabWork(
            date, 
            name, 
            coordinates, 
            minimalPoint, 
            personalQualitiesMinimum,
            description, 
            difficulty, 
            author
        );        
    }

    public LabWork makeLabWork(String name, Coordinates coordinates, int minimalPoint, int personalQualitiesMinimum,
        String description, Difficulty difficulty, Person author) {
        return new LabWork(new java.util.Date(), name, coordinates, minimalPoint, personalQualitiesMinimum, description, difficulty, author);
    }

    private Coordinates makeCoordinates(String s) {
        // вывод текста и получение Coordinates
        String str = Input.getParams(s);
        if(str == null){
            throw new WrongParam();
        } 
        String[] coords = str.split(" ", 2);
        Coordinates coord = new Coordinates(Float.valueOf(coords[0]), Float.valueOf(coords[1]));
        return coord;
    }
    private Difficulty makeDifficulty(String s) {
        // вывод текста и получение Difficulty
        String str = Input.getParams(s);
        if(str == null){
            throw new WrongParam();
        }        
        Difficulty difficulty = Difficulty.valueOf(str);
        return difficulty;
    }
    private Person makePerson(String s) {
        // вывод текста и получение Person
        System.out.println(s);
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder.makePerson();
        return person;
    }

    public static long getIdCounter() {
        return idCounter;
    }
    public static void setIdCounter(long id) {
        idCounter = id;
    }

}
