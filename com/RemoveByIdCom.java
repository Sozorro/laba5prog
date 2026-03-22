package com;

import java.text.ParseException;

import exceptions.WrongParam;
import io.Input;
import managers.CollectionManager;
import managers.ComHistory;

public class RemoveByIdCom extends Command {
    public RemoveByIdCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "remove";
        this.description = "удалить элемент из коллекции по его id";
    }
    @Override
    public void execute(String... args) {
        try {
            String[] str;
            if(args == null || args.length == 0) str = Input.getParams("Какой элемент удалить?").split(" ");
            else str = args;
            if (str.length != 1) throw new WrongParam("Неверный формат ввода");
            collectionManager.delLab(Long.parseLong(str[0]));
            ComHistory.addCom(name, str[0]);
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
