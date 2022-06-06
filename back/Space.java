package back;

import back.Planet;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.function.DoubleToIntFunction;

import static java.lang.Math.pow;

public class Space {
    public static final double G= 1;//(float) pow(10,-11)*6667430;
    //static BigInteger sunMass = "1989000000000000000000000000000";//(long) ((double) pow(10,30)*19891);
    public static double EarthMass= 100;//(float) pow(10,24)*59742;

    public static void main(String[]args)
    {
        //Sun s = new Sun(new BigDecimal("1988400000000000000000000000000"));
        //MathContext mc=new MathContext(40);
        //Planet planet = new Planet(new BigDecimal("69610000000"), new BigDecimal("0"), s, new BigDecimal("107208000"), new BigDecimal("0"),mc);
        BigDecimal x = new BigDecimal("10");
        System.out.println(x);
        x = new BigDecimal("20");
        System.out.println(x);
        BigDecimal y = new BigDecimal("10");
        System.out.println(y);
        y = x;
        System.out.println(y);
        x = x.add(x);
        System.out.println(x + "d" + y);
        //Sun s=new Sun(sunMass);
        //System.out.println(G + " massS " + sunMass + " earthMass " + EarthMass);
        //Planet p=new Planet(0,100,s,100,0);
        for(int i=0;i<100;i++)
        {
            //p.aktualizacja(0.1);
        }
    }

}
