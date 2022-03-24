package back;

import back.Planet;

import static java.lang.Math.pow;

public class Space {
    public final float spaceG= (float) pow(10,-11)*6667430;
    static long sunMass= (long) ((double) pow(10,30)*19891);
    public float EarthMass=(float) pow(10,24)*59742;

    public static void main(String[]args)
    {
        Sun s=new Sun(sunMass);
        Planet p=new Planet(100,100,s);
        for(int i=0;i<10000;i++){
            p.aktualizacja(1,s);
        }
    }

}
