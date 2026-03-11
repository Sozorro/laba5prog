package enums;

import exeptions.WrongParam;

public enum Color {
    YELLOW(1),
    ORANGE(2),
    WHITE(3);


    private final int num;

    Color(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
    public static Color getColor(int num) throws WrongParam{
        for (Color col : values()) {
            if (col.getNum() == num) {
                return col;
            }
        }
        throw new WrongParam("Некорректное значение: ");
    }
}
