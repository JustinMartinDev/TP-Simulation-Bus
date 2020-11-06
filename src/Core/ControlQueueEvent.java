package Core;

public class ControlQueueEvent extends EventSimulator {
    public ControlQueueEvent() {
        super("Arrivée d'un bus dans la file de contrôle");
    }

    @Override
    public void execute() {

        statisticalIndicator.NbBusInControlQ += 1;

        if(!statisticalIndicator.ControlCenter)
        {
            Scheduler.add(Scheduler.simulationDate, new AccessControlEvent());
        }
    }
}
