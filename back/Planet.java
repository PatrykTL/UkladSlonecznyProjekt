package back;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Math.pow;
import static java.math.BigDecimal.valueOf;

public class Planet {
    private BigDecimal G; //(float) ;
    private BigDecimal mass;
    private BigDecimal speedX;
    private BigDecimal speedY;
    private BigDecimal odleglosc;
    private BigDecimal x,y;
    private Sun s;
    private MathContext mc;
    public Planet(BigDecimal x, BigDecimal y, Sun s, BigDecimal speedX, BigDecimal speedY,MathContext mc)
    {
        this.mc = mc;
        this.x=x;
        this.y=y;
        this.odleglosc= (BigDecimal) ((x.multiply(x)).add(y.multiply(y))).sqrt(mc);
        this.speedX = speedX;
        this.speedY = speedY;
        //System.out.println("odleglosc: "+odleglosc);
        //System.out.println("predkoscX: "+speedX);
        //System.out.println("predkoscY: "+speedY);
        //System.out.println("x= "+ this.x + " y= " + this.y);
        this.G = new BigDecimal("0.00000000000086498928");
        this.s = s;
    }

    public void actualizationOfPosition(double czas)
    {
        this.x = x.add(speedX.multiply(valueOf(czas), mc));
        this.y = y.add(speedY.multiply(valueOf(czas), mc));
    }

    public void actualizationOfSpeed(double czas)
    {
        BigDecimal speed = speedFromGravity(s.getMass(),czas);
        this.speedX = speedX.subtract(speedXFromGravity(speed));
        this.speedY = speedY.subtract(speedYFromGravity(speed));
    }

    public void actualizationOfDistance()
    {
        odleglosc = (((x.multiply(x)).add(y.multiply(y))).sqrt(mc));
    }
    public BigDecimal speedFromGravity(BigDecimal M, double czas)
    {
        //System.out.println(" M = " + M + " czas = " + czas + " G = " + G + " odleglosc = " + odleglosc + " speed = " + (double) ((M*G*czas)/(odleglosc*odleglosc)));
        return (BigDecimal) ((M.multiply(G.multiply(BigDecimal.valueOf(czas)))).divide(odleglosc.multiply(odleglosc),50, RoundingMode.HALF_UP));
    }

    public BigDecimal speedXFromGravity(BigDecimal speed)
    {
            return (BigDecimal) (speed.multiply(x.divide(odleglosc,50,RoundingMode.HALF_UP)));
    }

    public BigDecimal speedYFromGravity(BigDecimal speed)
    {
            return (BigDecimal) (speed.multiply(y.divide(odleglosc,50,RoundingMode.HALF_UP)));
    }
    public void aktualizacja(double czas)
    {
        actualizationOfPosition(czas);
        actualizationOfDistance();
        actualizationOfSpeed(czas);
        //System.out.println("odleglosc: "+odleglosc);
        //System.out.println("predkoscX: "+speedX);
        //System.out.println("predkoscY: "+speedY);
        //System.out.println("x= "+ this.x + " y= " + this.y);
    }
    public void setX(BigDecimal x)
    {
        this.x= new BigDecimal("x");
    }
    public void setY(BigDecimal y)
    {
        this.y= new BigDecimal("y");
    }

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }
}

/*
    private float startSpeed;
    private float VectorAcc;
    private float VectorGravity;
    private double kat;
*/
    /*
    public void nowaOdleglosc(){
        this.odleglosc= (long) Math.sqrt((x*x)+(y*y));
    }
    public void newSpeed(Sun s)
    {
        this.speed= (long) Math.sqrt(spaceG*s.getMass()/odleglosc);
    }
    */

    /*
    public void przemieszczenieGrav(Sun s, double czas)
    {
        double droga=(gravityAcc(s)*czas*czas)/2;
        System.out.println("droga Planety:"+droga);
        double a,b;
        a=y-droga*(y/odleglosc);
        b=x-droga*(x/odleglosc);
        setY(a);
        setX(b);
        System.out.println("x="+x+" y="+y);
    }
     */
/*
    public void przemieszczenieSpeed(double czas)
    {
        double droga=speed*czas;
        double a,b;
        a=y-droga*(x/odleglosc);
        b=x+droga*(y/odleglosc);
        setY(a);
        setX(b);
        System.out.println("przemieszczenie Droga: x="+x+" y="+y);

    }
 */
/*
    public double gravityAcc(Sun s)
    {
        return(spaceG*s.getMass()/odleglosc*odleglosc);
    }
 */