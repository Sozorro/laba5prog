package com;

import java.text.ParseException;

import builders.LabWork;
import builders.LabWorkBuilder;
import exceptions.WrongAction;
import exceptions.WrongParam;
import io.Input;
import managers.CollectionManager;
import managers.ComHistory;

public class UpdateCom extends Command {
    public UpdateCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "update";
        this.description = "обновить значение элемента коллекции, id которого равен заданному";
    }
    @Override
    public void execute(String... args) {
        try {
            String[] str;
            if(args == null || args.length == 0) str = Input.getParams("Какой элемент обновить?").split(" ");
            else str = args;
            if (str.length != 1) throw new WrongParam("Неверный формат ввода");

            LabWorkBuilder labWorkBuilder = new LabWorkBuilder();
            LabWork laba = labWorkBuilder.makeLabWork();
            if(laba == null) return;
            collectionManager.updateLab(Long.parseLong(str[0]), laba);
            ComHistory.addCom(name, "Id обновлённого элемента: " + str[0] + "\nНовый элемент: \n" + laba.getTabString(1));
        } catch (ParseException e) {
            System.out.println("Ошибка парсинга, элемент не был обновлён");
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат id");
        } catch (WrongParam e) {
            System.out.println("Из-за ошибки ввода элемент не был обновлён");
        } catch (WrongAction e) {
            System.out.println("Создание было остановлено и элемент не был обновлён");
        }
    }
}
