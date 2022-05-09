package back;

import java.math.BigDecimal;

import static java.lang.Math.pow;

public class Planet {
    public final double G; //(float) pow(10,-11)*6667430;
    private double mass;
    private double speedX;
    private double speedY;
    private double odleglosc;
    private double x,y;
    private Sun s;
    public Planet(double x, double y, Sun s, double speedX, double speedY)
    {
        this.x=x;
        this.y=y;
        this.odleglosc= (double) Math.sqrt((x*x)+(y*y));
        this.speedX = speedX;
        this.speedY = speedY;
        //System.out.println("odleglosc: "+odleglosc);
        //System.out.println("predkoscX: "+speedX);
        //System.out.println("predkoscY: "+speedY);
        //System.out.println("x= "+ this.x + " y= " + this.y);
        this.G = 1;
        this.s = s;
    }

    public void actualizationOfPosition(double czas)
    {
        this.x = this.x + speedX*czas;
        this.y = this.y + speedY*czas;
    }

    public void actualizationOfSpeed(double czas)
    {
        double speed = speedFromGravity(s.getMass(),czas);
        this.speedX = speedX - speedXFromGravity(speed);
        this.speedY = speedY - speedYFromGravity(speed);
    }

    public void actualizationOfDistance()
    {
        odleglosc = (double) Math.sqrt((x*x)+(y*y));
    }
    public double speedFromGravity(double M, double czas)
    {
        //System.out.println(" M = " + M + " czas = " + czas + " G = " + G + " odleglosc = " + odleglosc + " speed = " + (double) ((M*G*czas)/(odleglosc*odleglosc)));
        return (double) ((M*G*czas)/(odleglosc*odleglosc));
    }

    public double speedXFromGravity(double speed)
    {
            return (double) (speed*(x/odleglosc));
    }

    public double speedYFromGravity(double speed)
    {
            return (double) (speed*(y/odleglosc));
    }
    public void aktualizacja(double czas)
    {
        actualizationOfPosition(czas);
        actualizationOfDistance();
        actualizationOfSpeed(czas);
        //System.out.println("odleglosc: "+odleglosc);
        System.out.println("predkoscX: "+speedX);
        System.out.println("predkoscY: "+speedY);
        //System.out.println("x= "+ this.x + " y= " + this.y);
    }
    public void setX(double x)
    {
        this.x=x;
    }
    public void setY(double y)
    {
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
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