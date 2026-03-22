package com;

import exceptions.WrongParam;
import io.Input;
import managers.CollectionManager;

public class FilterStartsWithDescriptionCom extends Command {
    public FilterStartsWithDescriptionCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "filter";
        this.description = "вывести элементы, значение поля description которых начинается с заданной подстроки";
    }
    @Override
    public void execute(String... args) {
        try {
            String str;
            if(args == null) str = Input.getParams("Какой элемент удалить?");
            else str = String.join(" ", args);
            for(var elem : collectionManager.findElemsSubstring(str)) {
                System.out.println(elem);
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат id");
        } catch (WrongParam e) {
            System.out.println(e.getMessage());
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tИначе введите: \"no\" \n \t");
            if(prov != null && prov.equals("yes")) {
                execute();
            }
        }
    }
}
