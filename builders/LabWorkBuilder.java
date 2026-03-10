package builders;

import enums.Difficulty;
import exeptions.WrongParam;
import io.Input;
import managers.Coordinates;

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

}
