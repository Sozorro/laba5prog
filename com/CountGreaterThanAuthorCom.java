package com;

import builders.Person;
import builders.PersonBuilder;
import exceptions.WrongParam;
import managers.CollectionManager;

public class CountGreaterThanAuthorCom extends Command {
    public CountGreaterThanAuthorCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "counter";
        this.description = "добавить элемент LabWork";
    }
    @Override
    public void execute(String... args) {
        try {
            PersonBuilder personBuilder = new PersonBuilder();
            Person author = personBuilder.makePerson();
            System.out.println(collectionManager.findElems(author).size());
        } catch (WrongParam e) {

        }
    }
}
