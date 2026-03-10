package builders;

import enums.Color;
import exeptions.WrongParam;
import io.Input;

public class PersonBuilder extends Builder {
    public Person makePerson() {
        return new Person (makeString("name"), makeDouble("height"), makeLong("weight"), makeString("passportID"), makeColor("hairColor"));
    }
    private Color makeColor(String s) {
        // вывод текста и получение Color
        String str = Input.getParams(s);
        if(str == null){
            throw new WrongParam();
        }
        Color color = Color.valueOf(str);
        return color;
    }
}
