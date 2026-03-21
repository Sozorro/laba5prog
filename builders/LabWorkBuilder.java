package builders;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import enums.Color;
import enums.Difficulty;
import exceptions.WrongAction;
import exceptions.WrongParam;
import io.Input;
import io.InputFile;
import managers.Coordinates;

public class LabWorkBuilder extends Builder {
    
    public LabWork makeLabWork() throws ParseException, WrongParam {
        if (InputFile.readFile == false) {
            try {
                return new LabWork(
                    new java.util.Date(),
                    makeString("Введите название работы: "), 
                    makeCoordinates("Введите координаты х и у (в одну строку через пробел или на одной сначала x, затем на другой у): "), 
                    makeInt("Введите minimalPoint: "), 
                    makeInt("Введите personalQualitiesMinimum: "),
                    makeString("Укажите описание вашей работы: "), 
                    makeDifficulty("Введите сложность работы или выберете цифру: "), 
                    makePerson("Введите author")
                );
            } catch (WrongParam e) {
                return makeLabWork();
            } //WrongAction up
        }
        else {
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
    }
    public LabWork makeLabWork(java.util.Date date, String name, Coordinates coordinates, int minimalPoint, int personalQualitiesMinimum,
        String description, Difficulty difficulty, Person author) {
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
        String description, Difficulty difficulty, Person author) {
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

    private Coordinates makeCoordinates(String s) {
        // вывод текста и получение Coordinates
        String ext = "Неверный формат координат, проверьте корректность ввода";
        String[] str = Input.getParams(s).split(" ");
        String[] coords = new String[2];
        try {
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
                return makeCoordinates(s);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw new WrongParam(ext);
        } catch (WrongParam e) {
            e.getMessage();
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeCoordinates(s);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw e;
        }
    }
    private Difficulty makeDifficulty(String s) throws WrongParam {
        // вывод текста и получение Difficulty
        String str = Input.getParams(s, "\n \tДоступные значения: \n \t1. HARD \n \t2. VERY_HARD \n \t3. INSANE");
        String ext = "Неверный формат сложности, проверьте корректность ввода";
        try {
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
                return makeDifficulty(s);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw e;
        }
    }
    private Person makePerson(String s) {
        // вывод текста и получение Person
        try {
            System.out.println(s);
            PersonBuilder personBuilder = new PersonBuilder();
            Person person = personBuilder.makePerson();
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
    }


}
