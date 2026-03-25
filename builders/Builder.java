package builders;

import java.util.function.Function;

import exceptions.WrongAction;
import exceptions.WrongParam;
import io.Input;
import io.InputFile;

public class Builder {
    /*@SuppressWarnings("unchecked")
    protected <T> T getStandartValue(String s, Class<T> type) {
        // вывод текста и получение строки, Int, Double, Long
        String ext;
        if (type == String.class) {
            ext = "Неверный формат строки, проверьте корректность ввода";
        } else if (type == Integer.class || type == Long.class) {
            ext = "Неверный формат целого числа, проверьте корректность ввода";
        } else if (type == Double.class) {
            ext = "Неверный формат вещественного числа, проверьте корректность ввода";
        } else {
            throw new WrongParam("Неверный тип");
        }
        try {
            String str = Input.getParams(s);
            if(str == null){
                throw new WrongParam(ext);
            } 

            if (type == String.class) {
                return (T) str;
            } else if (type == Integer.class) {
                return (T) Integer.valueOf(str);
            } else if (type == Double.class) {
                return (T) Double.valueOf(str);
            } else if (type == Long.class) {
                return (T) Long.valueOf(str);
            } else {
                throw new WrongParam("Неверный ввод");
            }
            
        } catch (NumberFormatException e) {
            System.out.println(ext);
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return getStandartValue(s, type);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw new WrongParam(ext);
        } catch (WrongParam e) {
            e.getMessage();
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tЕсли хотите начать создание лабораторной работы сначала введите: \"no\" \n \tЕсли хотите совсем выйти из создания лабораторной введите \"back\"");
            if(prov != null && prov.equals("yes")) {
                return getStandartValue(s, type);
            }
            if(prov != null && prov.equals("back")) {
                throw new WrongAction();
            }
            throw e;
        }
    }*/

    public <T> T interactInputRetry(Function<String[], T> action, String[] params, String s) throws WrongParam, WrongAction {
        try {
            return action.apply(params);
        } catch (WrongParam e) {
            System.out.println(e.getMessage());
            if(InputFile.readFile == false)  {
                String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n" +
                                    //"\tЕсли хотите начать создание всей лабораторной работы сначала введите: \"no\" \n" +
                                    "\tЕсли хотите выйти из создания лабораторной введите \"back\"");
                while (prov == null) {
                    prov = Input.getParams("\tВведите: \"yes\", \"no\" или \"back\"");
                }
                if (prov.equals("yes")) {
                    return interactInputRetry(action, null, s); // повторить попытку
                }/*else if (prov.equals("no")) {
                    throw e; // начать заново (поднимаем исключение)
                } */else {
                    throw new WrongAction(); // выйти
                }
            } else {
                System.out.println("\tВведены не все параметры или они некорректно заданы, хотите ввести их ещё раз в интерактивном режиме? \n" );
                String prov = null;
                while (prov == null) {
                    prov = Input.getParams("\tВведите: \"yes\" или \"no\" \n");
                }
                if (prov.equals("yes")) {
                    return interactInputRetry(action, Input.getParams(s).split(" "), s); // повторить попытку
                } else {
                    throw new WrongAction(); // выйти
                }
            }
            
        }
    }
}