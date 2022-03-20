import static java.lang.Math.pow;

public class Planet {
    public final float spaceG= (float) pow(10,-11)*6667430;
    private float mass;
    private float startSpeed;
    private float VectorAcc;
    private float VectorGravity;
    private long speed;
    private long odleglosc;
    private double kat;
    double x,y;
    public Planet(double x,double y,Sun s)
    {
        this.x=x;
        this.y=y;
        this.odleglosc= (long) Math.sqrt((x*x)+(y*y));
        newSpeed(s);
    }

    public double gravityAcc(Sun s)
    {
        return(spaceG*s.getMass()/odleglosc*odleglosc);
    }
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
    public void nowaOdleglosc(){
        this.odleglosc= (long) Math.sqrt((x*x)+(y*y));
    }
    public void newSpeed(Sun s)
    {
        this.speed= (long) Math.sqrt(spaceG*s.getMass()/odleglosc);
    }
    public void aktualizacja(double czas,Sun s)
    {
        przemieszczenieSpeed(czas);
        newSpeed(s);
        nowaOdleglosc();
        System.out.println("odleglosc: "+odleglosc);
        System.out.println("predkosc: "+speed);
    }
    public void setX(double x)
    {
        this.x=x;
    }
    public void setY(double y)
    {
        this.y=y;
    }


}
