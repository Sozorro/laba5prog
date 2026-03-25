package builders;

import enums.Color;
import exceptions.WrongAction;
import exceptions.WrongParam;
import io.Input;
import io.InputFile;
import managers.Validator;

public class PersonBuilder extends Builder {
    public Person makePerson() {
        try {
            return new Person (
                makeName(),
                makeHeight(),
                makeWeight(),
                makePassportID(),
                makeHairColor()
                /*
                getStandartValue("name", String.class), 
                getStandartValue("height", Double.class), 
                getStandartValue("weight", Long.class), 
                getStandartValue("passportID", String.class), 
                makeColor("hairColor")*/
            );
        } catch (WrongParam e) {
            return makePerson();
        }
    }

    public Person makePerson(String name, String height, String weight, String passportID, String hairColor) {
        return new Person(
            makeName(name),
            makeHeight(height),
            makeWeight(weight),
            makePassportID(passportID),
            makeHairColor(hairColor)

        );
    }
    public Person makePerson(String name, double height, long weight, String passportID, Color hairColor) {
        return new Person (name, height, weight, passportID, hairColor);
    }

    public String makeName(String... args) throws WrongParam, WrongAction {
        String s = "Введите имя: ";
        String ext = "Недопустимое название, проверьте корректность ввода";

        String result = interactInputRetry((params) -> {
            if (params != null && params.length != 0) {
                String input = String.join("", params).toString().trim();
                if (Validator.validNameForLabWork(input)) {
                    return input;
                } else {
                    throw new WrongParam(ext);
                }
            } else if (InputFile.readFile == true) {
                throw new WrongParam(ext);
            } else {
                return makeName(Input.getParams(s).split(" "));
            }
        }, args, s);
        return result;
    }

    public double makeHeight(String... args) throws WrongParam, WrongAction {
        String s = "Введите рост: ";
        String ext = "Некорректный рост";

        return interactInputRetry((params) -> {
            if (params != null && params.length == 1) {
                try {
                    double input = Double.valueOf(params[0]);
                    if (Validator.validHeightForPerson(input)) {
                        return input;
                    } else {
                        throw new WrongParam(ext);
                    }
                } catch (NumberFormatException e) {
                    throw new WrongParam(ext);
                }
            } else if (params != null && params.length != 0 || InputFile.readFile == true) {
                throw new WrongParam(ext);
            } else {
                return makeHeight(Input.getParams(s).split(" "));
            }
        }, args, s);
    }

    public long makeWeight(String... args) throws WrongParam, WrongAction {
        String s = "Введите вес: ";
        String ext = "Некорректный вес";

        return interactInputRetry((params) -> {
            if (params != null && params.length == 1) {
                try {
                    Long input = Long.valueOf(params[0]);
                    if (Validator.validWeightForPerson(input)) {
                        return input;
                    } else {
                        throw new WrongParam(ext);
                    }
                } catch (NumberFormatException e) {
                    throw new WrongParam(ext);
                }
            } else if (params != null && params.length != 0 || InputFile.readFile == true) {
                throw new WrongParam(ext);
            } else {
                return makeWeight(Input.getParams(s).split(" "));
            }
        }, args, s);
    }

    public String makePassportID(String... args) throws WrongParam, WrongAction {
        String s = "Введите номер паспорта: ";
        String ext = "Некорректный номер паспорта";

        String result = interactInputRetry((params) -> {
            if (params != null && params.length != 0) {
                String input = String.join("", params).toString().trim();
                if (Validator.validPassportIDForPerson(input)) {
                    return input;
                } else {
                    throw new WrongParam(ext);
                }
            } else if (InputFile.readFile == true) {
                throw new WrongParam(ext);
            } else {
                return makeName(Input.getParams(s).split(" "));
            }
        }, args, s);
        return result;
    }

    public Color makeHairColor(String... args) throws WrongParam, WrongAction {
        String s = ("Введите цвет волос: \n" +
                    "\t Доступные значения: \n \t 1. YELLOW \n \t 2. ORANGE \n \t 3. WHITE");
        String ext = "Некорректный цвет, проверьте корректность ввода";

        return interactInputRetry((params) -> {
            if (params != null && params.length == 1) {
                Color input = null;
                try {
                    int i = Integer.parseInt(args[0]);
                    input = Color.getVal(i);
                } catch (NumberFormatException notNum) {
                    System.out.println(ext);
                    try {
                        input = Color.valueOf(args[0]);
                    } catch (IllegalArgumentException notZnach) {
                        throw new WrongParam(ext);
                    }
                }
                if (Validator.validHairColorForPerson(input)) {
                    return input;
                } else {
                    throw new WrongParam(ext);
                }
            } else if (params != null && params.length != 0 || InputFile.readFile == true) {
                throw new WrongParam(ext);
            } else {
                return makeHairColor(Input.getParams(s).split(" "));
            }
        }, args, s);
    }



















    /*private Color makeColor(String s) {
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
    }*/
}
