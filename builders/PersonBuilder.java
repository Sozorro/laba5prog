package builders;

import enums.Color;
import io.Input;

public class PersonBuilder extends Builder {
    public Person makePerson() {
        return new Person (makeString("name"), makeDouble("height"), makeLong("weight"), makeString("passportID"), makeColor("hairColor"));
    }
    private Color makeColor(String s) {
        // вывод текста и получение Color
        System.out.println(s);
        String str = Input.scannerNow.nextLine();
        Color color = Color.valueOf(str);
        return color;
    }
}
