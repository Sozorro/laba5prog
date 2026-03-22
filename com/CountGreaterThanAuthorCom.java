package com;

import builders.Person;
import builders.PersonBuilder;
import enums.Color;
import exceptions.WrongParam;
import io.Input;
import managers.CollectionManager;
import managers.ComHistory;

public class CountGreaterThanAuthorCom extends Command {
    public CountGreaterThanAuthorCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "counter by weight";
        this.description = "Вывести кол-во элементов, вес которых в поле \"author\"  больше заданного";
    }
    @Override
    public void execute(String... args) {
        try {
            String[] str;
            if(args == null) str = Input.getParams("введите вес").split(" ");
            else str = args;
            String ext = "Неверный формат, проверьте корректность ввода";
            if(str.length > 1 || str.length == 0) {
                throw new WrongParam(ext);
            }
            PersonBuilder personBuilder = new PersonBuilder();
            Person author = personBuilder.makePerson("", 0.0, Long.valueOf(str[0]), "", Color.WHITE);
            ComHistory.addCom(name, str[0]);
            System.out.println("Кол-во элементов, вес которых больше, чем " + str[0] + ": " + collectionManager.findElemsHeavierPerson(author).size());
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат веса");
        } catch (WrongParam e) {
            System.out.println(e.getMessage());
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tИначе введите: \"no\" \n \t");
            if(prov != null && prov.equals("yes")) {
                execute();
            }
        }
    }
}
