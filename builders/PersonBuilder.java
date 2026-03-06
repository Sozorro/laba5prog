package builders;

import enums.Color;

public class PersonBuilder extends Builder {
    public Person makePerson() {
        return new Person (makeString("name"), makeDouble("height"), makeLong("weight"), makeString("passportID"), makeColor("hairColor"));
    }
    private Color makeColor(String s) {
        // вывод текста и получение Difficulty
        Color str = Color.WHITE;
        System.out.println(s);
        return str;
    }
}
