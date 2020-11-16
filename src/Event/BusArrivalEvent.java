package Event;

public class BusArrivalEvent extends EventSimulator {

    public BusArrivalEvent() {
        super("Arrivée d'un bus dans le systeme");
    }

    @Override
    public void execute() {
        System.out.println(name);

        Scheduler.add(Scheduler.simulationDate + getExpo(2), new BusArrivalEvent());
        statisticalIndicator.nbBus += 1;
        Scheduler.add(Scheduler.simulationDate, new ControlQueueEvent());
    }


}