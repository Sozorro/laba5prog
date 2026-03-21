package builders;

import enums.Color;
import exeptions.WrongAction;
import exeptions.WrongParam;
import io.Input;

public class PersonBuilder extends Builder {
    public Person makePerson() {
        try {
            return new Person (makeString("name"), makeDouble("height"), makeLong("weight"), makeString("passportID"), makeColor("hairColor"));
        } catch (WrongParam e) {
            return makePerson();
        }
    }
    public Person makePerson(String name, double height, long weight, String passportID, Color hairColor) {
        return new Person (name, height, weight, passportID, hairColor);
    }
    private Color makeColor(String s) {
        // вывод текста и получение Color
        String str = Input.getParams(s, "\n \t Доступные значения: \n \t 1. YELLOW \n \t 2. ORANGE \n \t 3. WHITE");
        String ext = "Несуществующий цвет, проверьте корректность ввода";
        try {
            if(str == null || str.isEmpty()){
                throw new WrongParam(ext);
            }
            try {
                int i = Integer.parseInt(str);
                return Color.getVal(i);
            } catch (NumberFormatException notNum) {
                System.out.println(ext);
                try {
                    Color color = Color.valueOf(str);
                    return color;
                } catch (IllegalArgumentException notZnach) {
                    throw new WrongParam(ext);
                }
            }
            
        } catch (WrongParam e) {
            e.getMessage();
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание Person сначала введите: \"no\" \n \t tЕсли хотите выйти из создания Person введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeColor(s);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw e;
        }
    }
}
