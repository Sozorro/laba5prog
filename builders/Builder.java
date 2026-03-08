package builders;

import io.Input;

public class Builder {
    
    protected String makeString(String s) {
        // вывод текста и получение строки
        System.out.println(s);
        String str = Input.scannerNow.nextLine();
        return str;
    }
    protected int makeInt(String s) {
        // вывод текста и получение Int
        System.out.println(s);
        String str = Input.scannerNow.nextLine();
        return Integer.valueOf(str);
    }
    protected Double makeDouble(String s) {
        // вывод текста и получение Double
        System.out.println(s);
        String str = Input.scannerNow.nextLine();
        return Double.valueOf(str);
    }
    protected Long makeLong(String s) {
        // вывод текста и получение Long
        System.out.println(s);
        String str = Input.scannerNow.nextLine();
        return Long.valueOf(str);
    }
}
