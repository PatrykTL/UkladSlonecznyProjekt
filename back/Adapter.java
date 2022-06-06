package back;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Adapter {
    private double centerX;
    private double centerY;
    private BigDecimal maxOdleglosc;

    public Adapter(double centerX,double centerY, BigDecimal maxOdleglosc){
        this.centerX = centerX;
        this.centerY = centerY;
        this.maxOdleglosc = maxOdleglosc;
    }
    public double dostosujDoEkranu(BigDecimal x){
        if(maxOdleglosc.toString()=="0"){
            return -1;
        }
        return  ((x.multiply(BigDecimal.valueOf(centerY))).divide(maxOdleglosc,40, RoundingMode.HALF_UP)).doubleValue();
    }

    public double ostatecznaPozycjaX(BigDecimal x){
        //System.out.println("center X "+centerX + " center Y " + centerY);
        //System.out.println("max odl= " + maxOdleglosc);
        //System.out.println("x =" + dostosujDoEkranu(x));
        return (dostosujDoEkranu(x) + centerX);
    }

    public double ostatecznaPozycjaY(BigDecimal y){
        //System.out.println("y =" + dostosujDoEkranu(y));
        return (dostosujDoEkranu(y) + centerY);
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }
}
