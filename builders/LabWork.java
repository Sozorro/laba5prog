package builders;

import enums.Difficulty;
import manager.Coordinates;

public class LabWork {
    //объекты коллекции
    private static long idCounter = 1;

    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int minimalPoint; //Значение поля должно быть больше 0
    private int personalQualitiesMinimum; //Значение поля должно быть больше 0
    private String description; //Длина строки не должна быть больше 3271, Поле не может быть null
    private Difficulty difficulty; //Поле может быть null
    private Person author; //Поле может быть 
    
    LabWork (String name, Coordinates coordinates, int minimalPoint, int personalQualitiesMinimum,
        String description, Difficulty difficulty, Person author) {
        id = Long.valueOf(idCounter);
        idCounter++;
        this.creationDate = new java.util.Date();

        this.name = name;
        this.coordinates = coordinates;
        this.minimalPoint = minimalPoint;
        this.personalQualitiesMinimum = personalQualitiesMinimum;
        this.description = description;
        this.difficulty = difficulty;
        this.author = author;
    }
}
