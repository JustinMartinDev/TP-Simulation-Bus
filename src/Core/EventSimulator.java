package Core;

import java.util.Random;

public abstract class EventSimulator {
    public String name;

    public static StatisticalIndicator statisticalIndicator;

    public EventSimulator(String name){
        this.name = name;
    }

    public abstract void execute();

    public double getExpo(int param) {
        Random rand = new Random();
        //peut-être ça plutôt :  -(1 / lambda) * log( 1 - rand.nextDouble() );
        double exp = Math.log(1 - rand.nextDouble()) / (-param);

        return (exp/10) * 60;

    }

    public double getUni(double inf, double sup) {
        double range = (sup - inf);
        return inf + (Math.random() * range);

    }


}
