package com;

import java.text.ParseException;

import builders.LabWork;
import builders.LabWorkBuilder;
import exceptions.WrongAction;
import exceptions.WrongParam;
import io.Input;
import managers.CollectionManager;

public class AddCom extends Command {
    public AddCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "add";
        this.description = "добавить элемент LabWork";
    }
    @Override
    public void execute(String... args){
        try { 
            LabWorkBuilder labWorkBuilder = new LabWorkBuilder();
            LabWork laba = labWorkBuilder.makeLabWork();
            if(laba == null) return;
            collectionManager.addLab(laba);
            System.out.println("элемент добавлен");
        } catch (ParseException e) {
            System.out.println("Ошибка парсинга, элемент не был добавлен");
        } catch (WrongParam e) {
            System.out.println("Элемент не был добавлен");
        } catch (WrongAction e) {
            System.out.println("Создание элемента было остановлено и он не был добавлен в коллекцию");
        }
        
    }
    /*передача параметров через конструкторы? */
}
