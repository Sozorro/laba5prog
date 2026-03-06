package builders;

import enums.Color;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private double height; //Значение поля должно быть больше 0
    private long weight; //Значение поля должно быть больше 0
    private String passportID; //Поле может быть null
    private Color hairColor; //Поле не может быть null

    Person (String name, double height, long weight, String passportID, Color hairColor) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
        this.hairColor = hairColor;
    }
}
