package manager;

import enums.Difficulty;
import exeptions.WrongParam;

public class LabWork {
    //объекты коллекции
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int minimalPoint; //Значение поля должно быть больше 0
    private int personalQualitiesMinimum; //Значение поля должно быть больше 0
    private String description; //Длина строки не должна быть больше 3271, Поле не может быть null
    private Difficulty difficulty; //Поле может быть null
    private Person author; //Поле может быть null


    public void setId() {
        //automatic
    }

    public void setName(String name) {
        if (name == null) {
            throw new WrongParam("Name не может быть пустым");
        }
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new WrongParam("Coordinates не может быть пустым");
        }
        this.coordinates = coordinates;
    }

    public void setCreationDate(java.util.Date creationDate) {
        //automatic
    }

    public void setMinimalPoint(int minimalPoint) {
        if (minimalPoint <= 0) {
            throw new WrongParam("MinimalPoint должно быть больше 0");
        }
        this.minimalPoint = minimalPoint;
    }

    public void setPersonalQualitiesMinimum(int personalQualitiesMinimum) {
        if (personalQualitiesMinimum <= 0) {
            throw new WrongParam("PersonalQualitiesMinimum должно быть больше 0");
        }
        this.personalQualitiesMinimum = personalQualitiesMinimum;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new WrongParam("Description не может быть пустым");
        }
        if (description.length() > 3271) {
            throw new WrongParam("Длина Description не должна превышать 3271 символ");
        }
        this.description = description;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    /* Должно быть:
    */
}
