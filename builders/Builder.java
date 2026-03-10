package builders;

import exeptions.WrongParam;
import io.Input;

public class Builder {
    
    protected String makeString(String s) {
        // вывод текста и получение строки
        String str = Input.getParams(s);
        if(str == null){
            throw new WrongParam();
        } 
        return str;
    }
    protected int makeInt(String s) {
        // вывод текста и получение Int
        String str = Input.getParams(s);
        if(str == null){
            throw new WrongParam();
        } 
        return Integer.valueOf(str);
    }
    protected Double makeDouble(String s) {
        // вывод текста и получение Double
        String str = Input.getParams(s);
        if(str == null){
            throw new WrongParam();
        } 
        return Double.valueOf(str);
    }
    protected Long makeLong(String s) {
        // вывод текста и получение Long
        String str = Input.getParams(s);
        if(str == null){
            throw new WrongParam();
        } 
        return Long.valueOf(str);
    }
}
