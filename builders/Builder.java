package builders;

import java.util.Scanner;

public class Builder {
    
    protected String makeString(String s) {
        // вывод текста и получение строки
        Scanner scan = new Scanner(System.in);
        String str = "";
        System.out.println(s);
        str = scan.nextLine();
        return str;
    }
    protected int makeInt(String s) {
        // вывод текста и получение строки
        int str = 0;
        return str;
    }
    protected int makeDouble(String s) {
        // вывод текста и получение строки
        double str = 0;
        return str;
    }
    protected int makeLong(String s) {
        // вывод текста и получение строки
        long str = 0;
        return str;
    }
}
