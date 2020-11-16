package Event;

public class ControlQueueEvent extends EventSimulator {
    public ControlQueueEvent() {
        super("Arrivée d'un bus dans la file de contrôle");
    }

    @Override
    public void execute() {
        System.out.println(name);
        statisticalIndicator.NbBusInControlQ += 1;

        if(!statisticalIndicator.ControlCenter)
        {
            Scheduler.add(Scheduler.simulationDate, new AccessControlEvent());
        }
    }
}
