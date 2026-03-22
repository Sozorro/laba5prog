package managers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import builders.LabWork;
import builders.Person;
import exceptions.WrongParam;

public class CollectionManager {
    private TreeSet<LabWork> labwork = new TreeSet<>(new idComparator());
    private static long idCounter = 1;
    
    public void addLab(LabWork labWork) {
        labWork.setId(Long.valueOf(idCounter));
        idCounter++;
        this.labwork.add(labWork);
    }
    public void addLabs(ArrayList<LabWork> labWorks) {
        for(var laba : labWorks) {
            laba.setId(Long.valueOf(idCounter));
            idCounter++;
            this.labwork.add(laba);
        }
    }
    public void delLab(long id) {
        LabWork delLaba = findElem(id);
        if(delLaba == null) {
            throw new WrongParam();
        }
        Iterator<LabWork> iterator = labwork.tailSet(delLaba, false).iterator();
        labwork.remove(delLaba);
        while (iterator.hasNext()) {
            LabWork laba = iterator.next();
            labwork.remove(laba);
            laba.setId(laba.getId() - 1);
            labwork.add(laba);
        }
        idCounter--;
    }

    public long delLabs() {
        long i = idCounter - 1;
        labwork.clear();
        idCounter = 1;
        return i;
    }

    class idComparator implements Comparator<LabWork> {
        @Override
        public int compare(LabWork a, LabWork b) {
            return (int) (Long.valueOf(a.getId()) - Long.valueOf(b.getId()));
        }
    }

    public LabWork findElem(long id) {
        Iterator<LabWork> iterator = labwork.iterator();
        while(iterator.hasNext()) {
            LabWork laba = iterator.next();
            if(laba.getId() == id)             
                return laba;
        }
        return null;
    }
    public ArrayList<LabWork> findElems(Person author) {
        ArrayList<LabWork> labs = new ArrayList<LabWork>();
        Iterator<LabWork> iterator = labwork.iterator();
        while(iterator.hasNext()) {
            LabWork laba = iterator.next();
            if(laba.getAuthor().getWeight() > author.getWeight())             
                labs.add(laba);
        }
        return labs;
    }

    public ArrayList<LabWork> findElems(String... prefDescription) {
        ArrayList<LabWork> labs = new ArrayList<LabWork>();
        Iterator<LabWork> iterator = labwork.iterator();
        while(iterator.hasNext()) {
            LabWork laba = iterator.next();
            if(laba.getDescription().startsWith(String.join(" ", prefDescription))){
                labs.add(laba);
            }          
        }
        return labs;
    }

    public static long getIdCounter() {
        return idCounter;
    }
    public static void setIdCounter(long id) {
        idCounter = id;
    }

    /*
    Должно быть:
    сортировка по умолчанию
    Коллекция типа java.util.TreeSet
    При запуске приложения коллекция должна автоматически заполняться значениями из файла.
    */
}
