package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double t1, t2;

    public double getT1() {
        return t1;
    }

    public double getT2() {
        return t2;
    }

    public boolean isaPripada() {
        return aPripada;
    }

    public boolean isbPripada() {
        return bPripada;
    }

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

    public Interval intersect(Interval inter){
        Interval vratiti = new Interval();
        if(inter.getT1() > t1 && inter.getT2()>t2) {
            vratiti = new Interval(inter.getT1(), t2, inter.isaPripada(), bPripada);
        }
        return vratiti;
    }

    public static Interval intersect(Interval inter1, Interval inter2){
        Interval vratiti = new Interval();
        if(inter1.getT1() > inter2.getT1() && inter1.getT2()>inter2.getT2()) {
            vratiti = new Interval(inter1.getT1(), inter2.getT2(), inter1.isaPripada(), inter2.isbPripada());
        }
        return vratiti;
    }

    @Override
    public String toString() {
        if(aPripada == true && bPripada == true) return "[" + t1 + "," + t2 +"]";
        if(aPripada == true && bPripada == false) return "[" + t1 + "," + t2 +")";
        if(aPripada == false && bPripada == true) return "(" + t1 + "," + t2 +"]";
        if(aPripada == false && bPripada == false) return "(" + t1 + "," + t2 +")";
        return null;
    }

    @Override
    public boolean equals(Object o){
        Interval inter = (Interval) o;
        if(inter.getT1() == t1 && inter.getT2() == t2 && inter.isaPripada() == aPripada && inter.isbPripada() == bPripada) return true;
        return false;
    }

}
