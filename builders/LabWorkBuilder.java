package builders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Function;

import enums.Difficulty;
import exceptions.WrongAction;
import exceptions.WrongParam;
import io.Input;
import io.InputFile;
import managers.Coordinates;
import managers.Validator;

public class LabWorkBuilder extends Builder {

    public LabWork makeLabWork() throws ParseException, WrongAction { // интерактивный ввод всех полей, кроме времени
        try {
            return new LabWork(
                new java.util.Date(),
                makeName(),
                makeCoordinates(), 
                makeMinimalPoint(), 
                makePersonalQualitiesMinimum(), 
                makeDescription(),
                makeDifficulty(), 
                makePerson()
                /*new java.util.Date(),
                getStandartValue("Введите название работы: ", String.class), 
                makeCoordinates(), 
                getStandartValue("Введите minimalPoint: ", Integer.class), 
                getStandartValue("Введите personalQualitiesMinimum: ", Integer.class),
                getStandartValue("Укажите описание вашей работы: ", String.class), 
                makeDifficulty(), 
                makePerson()*/
            );
        } catch (WrongParam e) {
            return makeLabWork();
        }
    }

    public LabWork makeLabWork(String date, String name, String coordinatesX, String coordinatesY, String minimalPoint, String personalQualitiesMinimum,
        String description, String difficulty, String... author) { //проверка всех полей
        return new LabWork(
            makeDate(date),
            makeName(name),
            makeCoordinates(coordinatesX, coordinatesY), 
            makeMinimalPoint(minimalPoint), 
            makePersonalQualitiesMinimum(personalQualitiesMinimum), 
            makeDescription(description),
            makeDifficulty(difficulty), 
            makePerson(author)
        );
    }

    public LabWork makeLabWork(java.util.Date date, String name, Coordinates coordinates, int minimalPoint, int personalQualitiesMinimum,
        String description, Difficulty difficulty, Person author) { //насильная установка :)
        return new LabWork(
            date, 
            name, 
            coordinates, 
            minimalPoint, 
            personalQualitiesMinimum,
            description, 
            difficulty, 
            author
        );        
    }

    public java.util.Date makeDate(String... args) throws WrongParam, WrongAction {
        String s = "Введите дату в формате \"dd.MM.yyyy\": ";
        String ext = "Неверный формат даты, проверьте корректность ввода";

        java.util.Date date = interactInputRetry((params) -> {
            if(params != null && params.length == 1) {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                    java.util.Date makeDate = formatter.parse(params[0].toString());
                    if (Validator.validDateForLabWork(makeDate)) {
                        return makeDate;
                    } else {
                        throw new WrongParam(ext);
                    }
                } catch (ParseException e) {
                    throw new WrongParam("Ошибка парсинга, проверьте корректность ввода");
                }
            } else if (params != null && params.length != 0 || InputFile.readFile == true) {
                throw new WrongParam(ext);
            } else {
                return makeDate(Input.getParams(s).split(" "));
            }
        }, args, s);
        return date;
    }

    public String makeName(String... args) throws WrongParam, WrongAction {
        String s = "Введите название лабораторной: ";
        String ext = "Недопустимое название, проверьте корректность ввода";
        

        /*if ((args == null || args.length == 0) && InputFile.readFile == false) {
            return makeName(Input.getParams(s).split(" "));
        }*/
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
                //throw new WrongParam(ext);
                //params = Input.getParams(s).split(" ");
                //return;
                //continue;
                return makeName(Input.getParams(s).split(" "));
            }
        }, args, s);
        return result;
    }

    public Coordinates makeCoordinates(String... args) throws WrongParam, WrongAction {
        String s = "Введите координаты х и у (в одну строку через пробел или на одной сначала x, затем на другой у): ";
        String ext = "Неверный формат координат, проверьте корректность ввода";

        Coordinates result = interactInputRetry((params) -> {
            String[] coords = new String[2];
            if (params != null && params.length == 2) {
                try {
                    coords[0] = params[0];
                    coords[1] = params[1];
                    boolean b = true;
                    try {
                        Integer.valueOf(coords[0]);
                        b = true;
                        
                    } catch (NumberFormatException e) {
                        b = false;
                    }
                    Coordinates coord = new Coordinates(Float.valueOf(coords[0]), Float.valueOf(coords[1]));
                    if (Validator.validCoordinatesForLabWork(coord)) {
                        return coord;
                    } else {
                        throw new WrongParam(ext);
                    }
                } catch (NumberFormatException e) {
                    throw new WrongParam(ext);
                }
                
            } else if (params != null && params.length != 0 || InputFile.readFile == true) {
                throw new WrongParam(ext);
            } else {
                String[] str = Input.getParams(s).split(" ");
                if(str == null || str.length == 0){
                    throw new WrongParam(ext);
                }
                if(str.length == 1) {
                    coords[0] = str[0];
                    str = Input.getParams("Теперь введите у:").split(" ");
                    if(str.length == 1) {
                        coords[1] = str[0];
                    } else {
                        throw new WrongParam(ext);
                    }
                } else if (str.length == 2)  {
                    coords[0] = str[0];
                    coords[1] = str[1];
                } else {
                    throw new WrongParam(ext);
                }
                return makeCoordinates(coords);
            }
        }, args, s);
        return result;
    }   

    public int makeMinimalPoint(String... args) throws WrongParam, WrongAction {
        String s = "Введите значение makeMinimalPoint: ";
        String ext = "Некорректное значение makeMinimalPoint";

        return interactInputRetry((params) -> {
            if (params != null && params.length == 1) {
                try {
                    Integer input = Integer.valueOf(params[0]);
                    if (Validator.validMinimalPointForLabWork(input)) {
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
                return makeMinimalPoint(Input.getParams(s).split(" "));
            }
        }, args, s);
    }

    public int makePersonalQualitiesMinimum(String... args) throws WrongParam, WrongAction {
        String s = "Введите минимальные личные качества: ";
        String ext = "Некорректные личные качества";

        return interactInputRetry((params) -> {
            if (params != null && params.length == 1) {
                try {
                    Integer input = Integer.valueOf(params[0]);
                    if (Validator.validPersonalQualitiesMinimumForLabWork(input)) {
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
                return makePersonalQualitiesMinimum(Input.getParams(s).split(" "));
            }
        }, args, s);
    }

    public String makeDescription(String... args) throws WrongParam, WrongAction {
        String s = "Введите описание: ";
        String ext = "Некорректное описание";

        return interactInputRetry((params) -> {
            if (params != null && params.length != 0) {
                String input = String.join("", params).toString().trim();
                if (Validator.validDescriptionForLabWork(input)) {
                    return input;
                } else {
                    throw new WrongParam(ext);
                }
            } else if (InputFile.readFile == true) {
                throw new WrongParam(ext);
            } else {
                return makeDescription(Input.getParams(s).split(" "));
            }
        }, args, s);
    }

    public Difficulty makeDifficulty(String... args) throws WrongParam, WrongAction {
        String s = ("Введите сложность работы или выберете цифру: \n" +
                    "\tДоступные значения: \n \t1. HARD \n \t2. VERY_HARD \n \t3. INSANE");
        String ext = "Неверный формат сложности, проверьте корректность ввода";
            

        return interactInputRetry((params) -> {
            if (params != null && params.length == 1) {
                Difficulty input = null;
                try {
                    int i = Integer.parseInt(args[0]);
                    input = Difficulty.getVal(i);
                } catch (NumberFormatException notNum) {
                    try {
                        input = Difficulty.valueOf(args[0]);
                    } catch (IllegalArgumentException notZnach) {
                        throw new WrongParam(ext);
                    }
                }
                if (Validator.validDifficultyForLabWork(input)) {
                    return input;
                } else {
                    throw new WrongParam(ext);
                }
            } else if (params != null && params.length != 0 || InputFile.readFile == true) {
                throw new WrongParam(ext);
            } else {
                return makeDifficulty(Input.getParams(s).split(" "));
            }
        }, args, s);
    }


    public Person makePerson(String... args) throws WrongParam, WrongAction {
        String s = "Введите author";
        String ext = "Некорректное pyfxtybt";

        PersonBuilder personBuilder = new PersonBuilder();
        Person person = null;
        if (args.length == 5) person = personBuilder.makePerson(args[0], args[1], args[2], args[3], args[4]);
        else person = personBuilder.makePerson();
        return person;
    }
    















    /**/
    /*public LabWork makeLabWork(java.util.Date date, String name, Coordinates coordinates, int minimalPoint, int personalQualitiesMinimum,
        String description, Difficulty difficulty, Person author) throws ParseException, WrongParam {
            PersonBuilder personBuilder = new PersonBuilder();
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            return makeLabWork(
                formatter.parse(InputFile.getParams("Labwork", "date")), 
                InputFile.getParams("Labwork", "name"), 
                new Coordinates(Float.valueOf(InputFile.getParams("Labwork", "coordinatesX")), Float.valueOf(InputFile.getParams("Labwork", "coordinatesY"))), 
                Integer.valueOf(InputFile.getParams("Labwork", "minimalPoint")),
                Integer.valueOf(InputFile.getParams("Labwork", "personalQualitiesMinimum")),
                InputFile.getParams("Labwork", "description"), 
                Difficulty.valueOf(InputFile.getParams("Labwork", "difficulty")), 
                    personBuilder.makePerson(
                        InputFile.getParams("Labwork", "Person", "name"), 
                        Double.valueOf(InputFile.getParams("Labwork", "Person", "height")), 
                        Long.valueOf(InputFile.getParams("Labwork", "Person", "weight")), 
                        InputFile.getParams("Labwork", "Person", "passportID"), 
                        Color.valueOf(InputFile.getParams("Labwork", "Person", "hairColor"))
                    )
            );
        }
    }*/
/*
    

    public LabWork makeLabWork(java.util.Date date, String name, Coordinates coordinates, int minimalPoint, int personalQualitiesMinimum,
        String description, Difficulty difficulty, Person author) { //все необходимые параметры
        return new LabWork(
            date, 
            name, 
            coordinates, 
            minimalPoint, 
            personalQualitiesMinimum,
            description, 
            difficulty, 
            author
        );        
    }

    public LabWork makeLabWork(String name, Coordinates coordinates, int minimalPoint, int personalQualitiesMinimum,
        String description, Difficulty difficulty, Person author) { // с автоматическим указанием времени
        return new LabWork(
            new java.util.Date(), 
            name, 
            coordinates, 
            minimalPoint, 
            personalQualitiesMinimum, 
            description, 
            difficulty, 
            author);
    }
    

    private Coordinates makeCoordinates(String... args) {
        // вывод текста и получение Coordinates
        String s = "Введите координаты х и у (в одну строку через пробел или на одной сначала x, затем на другой у): ";
        String ext = "Неверный формат координат, проверьте корректность ввода";
        String[] coords = new String[2];
        String[] str = new String[2];
        try {
            if(args != null && args.length == 2) {
                coords[0] = args[0];
                coords[1] = args[1];
                Coordinates coord = new Coordinates(Float.valueOf(coords[0]), Float.valueOf(coords[1]));
                return coord;
            } 
            
            if(args != null) {
                throw new WrongParam(ext);
            }
            str = Input.getParams(s).split(" ");
            if(str == null || str.length == 0){
                throw new WrongParam(ext);
            }
            if(str.length == 1) {
                coords[0] = str[0];
                str = Input.getParams("Теперь введите у:").split(" ");
                if(str.length == 1) {
                    coords[1] = str[0];
                } else {
                    throw new WrongParam(ext);
                }
            } else if (str.length == 2)  {
                coords[0] = str[0];
                coords[1] = str[1];
            } else {
                throw new WrongParam(ext);
            }
            Coordinates coord = new Coordinates(Float.valueOf(coords[0]), Float.valueOf(coords[1]));
            return coord;

        } catch (NumberFormatException e) {
            System.out.println(ext);
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeCoordinates();
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw new WrongParam(ext);
        } catch (WrongParam e) {
            e.getMessage();
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeCoordinates();
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw e;
        }
    }

    private Difficulty makeDifficulty(String... args) {
        // вывод текста и получение Difficulty
        String s = "Введите сложность работы или выберете цифру: ";
        String ext = "Неверный формат сложности, проверьте корректность ввода";
        try {
            if(args != null && args.length == 1) {
                try {
                    int i = Integer.parseInt(args[0]);
                    return Difficulty.getVal(i);
                } catch (NumberFormatException notNum) {
                    System.out.println(ext);
                    try {
                        Difficulty difficulty = Difficulty.valueOf(args[0]);
                        return difficulty;
                    } catch (IllegalArgumentException notZnach) {
                        throw new WrongParam(ext);
                    }
                }
            }

            String str = Input.getParams(s, "\n \tДоступные значения: \n \t1. HARD \n \t2. VERY_HARD \n \t3. INSANE");
            
            if(str == null || str.isEmpty()){
                throw new WrongParam(ext);
            }
            try {
                int i = Integer.parseInt(str);
                return Difficulty.getVal(i);
            } catch (NumberFormatException notNum) {
                System.out.println(ext);
                try {
                    Difficulty difficulty = Difficulty.valueOf(str);
                    return difficulty;
                } catch (IllegalArgumentException notZnach) {
                    throw new WrongParam(ext);
                }
            }
            
        } catch (WrongParam e) {
            e.getMessage();
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeDifficulty();
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw e;
        }
    }

    private Person makePerson(String... args) {
        // вывод текста и получение Person
        String s = "Введите author";
        try {
            System.out.println(s);
            PersonBuilder personBuilder = new PersonBuilder();
            Person person = personBuilder.makePerson(args);
            return person;
        } catch (WrongParam e) {
            return makePerson(s);
        } catch (WrongAction e) {
            e.getMessage();
            String prov = Input.getParams("\tЕсли хотите начать создание всей лабораторной работы сначала введите: \"yes\" \n \tЕсли хотите вообще выйти из создания объекта введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                throw new WrongParam();
            }
            throw e;
        }
    }*/


}
