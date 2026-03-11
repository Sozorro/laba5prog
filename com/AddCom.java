package com;

import java.text.ParseException;
import builders.LabWorkBuilder;
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
            if(args == null) {
                LabWorkBuilder labWorkBuilder = new LabWorkBuilder();
                collectionManager.addLab(labWorkBuilder.makeLabWork());
                System.out.println("элемент добавлен");
            }
        } catch (ParseException e) {
            System.out.println("Ошибка парсинга");
        }
        
    }
    /*передача параметров через конструкторы? */
}
