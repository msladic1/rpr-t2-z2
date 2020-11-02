package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double t1, t2;
    private boolean aPripada, bPripada;
    public Interval(double a, double b, boolean aPripada, boolean bPripada) {
        if(a > b) {
            throw new IllegalArgumentException("Prva tacka ne smije biti veca od druge");
        }
        t1 = a; t2 = b; this.aPripada = aPripada; this.bPripada = bPripada;
    }
    public Interval() {
        t1 = 0; t2 = 0; aPripada = false; bPripada = true;
    }

    public boolean isNull() {
        if(t1 == 0 && t2 == 0) return true;
        return false;
    }

    public boolean isIn(double tacka) {
        if(tacka >= t1 && tacka <= t2) return true;
        return  false;
    }
}
