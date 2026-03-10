package managers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import builders.LabWork;
import builders.LabWorkBuilder;

public class CollectionManager {
    private TreeSet<LabWork> labwork = new TreeSet<>(new idComparator());
    
    public void addLab(LabWork labWork) {
        labWork.setId(Long.valueOf(LabWorkBuilder.getIdCounter()));
        LabWorkBuilder.setIdCounter(LabWorkBuilder.getIdCounter() + 1);
        this.labwork.add(labWork);
    }
    public void addLabs(ArrayList<LabWork> labWorks) {
        for(var laba : labWorks) {
            laba.setId(Long.valueOf(LabWorkBuilder.getIdCounter()));
            LabWorkBuilder.setIdCounter(LabWorkBuilder.getIdCounter() + 1);
            this.labwork.add(laba);
        }
    }
    public void delLab(long id) {
        LabWork delLaba = findElem(id);
        Iterator<LabWork> iterator = labwork.tailSet(delLaba, false).iterator();
        labwork.remove(delLaba);
        while (iterator.hasNext()) {
            LabWork laba = iterator.next();
            labwork.remove(laba);
            laba.setId(laba.getId() - 1);
            labwork.add(laba);
        }
        LabWorkBuilder.setIdCounter(LabWorkBuilder.getIdCounter() - 1);
    }

    public void delLabs() {
        labwork.clear();
        LabWorkBuilder.setIdCounter(0);
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

    /*
    Должно быть:
    сортировка по умолчанию
    Коллекция типа java.util.TreeSet
    При запуске приложения коллекция должна автоматически заполняться значениями из файла.
    */
}
