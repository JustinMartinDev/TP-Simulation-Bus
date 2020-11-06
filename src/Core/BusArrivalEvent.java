package Core;

import java.util.Random;

public class BusArrivalEvent extends EventSimulator {

    public BusArrivalEvent() {
        super("Arrivée d'un bus dans ");
    }

    @Override
    public void execute() {

        scheduler.add(scheduler.dateSimu + getExpo(2), new BusArrivalEvent());
        statisticalIndicator.nbBus += 1;
        scheduler.add(scheduler.dateSimu, new ControlQueueEvent());
    }


}