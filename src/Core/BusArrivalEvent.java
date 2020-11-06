package Core;

import java.util.Random;

public class BusArrivalEvent extends EventSimulator {

    public BusArrivalEvent() {
        super("Arrivée d'un bus dans ");
    }

    @Override
    public void execute() {

        Scheduler.add(Scheduler.simulationDate + getExpo(2), new BusArrivalEvent());
        statisticalIndicator.nbBus += 1;
        Scheduler.add(Scheduler.simulationDate, new ControlQueueEvent());
    }


}