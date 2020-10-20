package Core;

import java.util.Random;

public abstract class EventSimulator {
    public String name;

    public EventSimulator(String name){
        this.name = name;
    }

    public abstract void execute();

    public double getDate(int param) {
        Random rand = new Random();
        double exp = Math.log(1 - rand.nextDouble()) / (-param);

        return (exp/10) * 60;

    }
}
