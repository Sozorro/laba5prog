package manager;

import exeptions.WrongParam;

public class Coordinates {
    private float x; //Значение поля должно быть больше -692
    private Float y; //Значение поля должно быть больше -859, Поле не может быть null
    
    public void SetX(float x) {
        if(x <= -692) {
            throw new WrongParam("Координата х должна быть больше -692");
        }
        this.x = x;

    }
    public void SetY(Float y) {
        if(y.floatValue() <= -859 || y == null) {
            throw new WrongParam("Координата у должна быть больше -859");
        }
        this.y = y;
    }
    public void SetY(float y) {
        if(y <= -859) {
            throw new WrongParam("Координата у должна быть больше -859");
        }
        this.y = Float.valueOf(y);
    }
}
