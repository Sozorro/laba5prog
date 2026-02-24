package manager;

import enums.Color;
import exeptions.WrongParam;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private double height; //Значение поля должно быть больше 0
    private long weight; //Значение поля должно быть больше 0
    private String passportID; //Поле может быть null
    private Color hairColor; //Поле не может быть null

    public void SetName(String name) {
        if(name == null) {
            throw new WrongParam();
        }
        this.name = name;
    }
    public void SetHeight(double height) {
        if(height <= 0) {
            throw new WrongParam();
        }
        this.height = height;

    }
    public void SetWeight(long weight) {
        if(weight <= 0) {
            throw new WrongParam();
        }
        this.weight = weight;
    }
    public void SetPassportID(String passportID) {
        this.passportID = passportID;

    }
    public void SetHairColor(Color hairColor) {
        if(hairColor == null) {
            throw new WrongParam();
        }
        this.hairColor = hairColor;

    }
}
