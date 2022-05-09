package back;

public class Adapter {
    public double dostosujDoEkranu(double maxOdleglosc, double szerokoscEkranu,double x){
        return (szerokoscEkranu*x)/maxOdleglosc;
    }
}
