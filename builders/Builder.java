package builders;

import exceptions.WrongAction;
import exceptions.WrongParam;
import io.Input;

public class Builder {
    
    protected String makeString(String s) {
        // вывод текста и получение строки
        String ext = "Неверный формат координат, проверьте корректность ввода";
        try {
            String str = Input.getParams(s);
            if(str == null){
                throw new WrongParam(ext);
            } 
            return str;
        } catch (WrongParam e) {
            e.getMessage();
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeString(s);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw e;
        }
        
    }
    protected int makeInt(String s) {
        // вывод текста и получение Int
        String ext = "Неверный формат целого числа, проверьте корректность ввода";
        try {
            String str = Input.getParams(s);
            if(str == null){
                throw new WrongParam(ext);
            } 
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            System.out.println(ext);
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeInt(s);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw new WrongParam(ext);
        } catch (WrongParam e) {
            e.getMessage();
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeInt(s);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw e;
        }
    }
    protected Double makeDouble(String s) {
        // вывод текста и получение Double
        String ext = "Неверный формат вещественного числа, проверьте корректность ввода";
        try {
            String str = Input.getParams(s);
            if(str == null){
                throw new WrongParam(ext);
            } 
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            System.out.println(ext);
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeDouble(s);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw new WrongParam(ext);
        } catch (WrongParam e) {
            e.getMessage();
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeDouble(s);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw e;
        }
    }
    protected Long makeLong(String s) {
        // вывод текста и получение Long
        String ext = "Неверный формат целого числа, проверьте корректность ввода";
        try {
            String str = Input.getParams(s);
            if(str == null){
                throw new WrongParam(ext);
            } 
            return Long.valueOf(str);
        } catch (NumberFormatException e) {
            System.out.println(ext);
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeLong(s);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw new WrongParam(ext);
        } catch (WrongParam e) {
            e.getMessage();
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return makeLong(s);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw e;
        }
    }
}
