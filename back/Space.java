package back;

import back.Planet;

import static java.lang.Math.pow;

public class Space {
    public static final double G= 1;//(float) pow(10,-11)*6667430;
    static double sunMass= 10000;//(long) ((double) pow(10,30)*19891);
    public static double EarthMass= 100;//(float) pow(10,24)*59742;

    public static void main(String[]args)
    {
        Sun s=new Sun(sunMass);
        System.out.println(G + " massS " + sunMass + " earthMass " + EarthMass);
        Planet p=new Planet(0,100,s,100,0);
        for(int i=0;i<100;i++)
        {
            p.aktualizacja(0.1);
        }
    }

}
