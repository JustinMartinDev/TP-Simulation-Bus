package Event;

public class DepartureControlEvent extends EventSimulator{
    public DepartureControlEvent() {
        super("Départ de la zone de contrôle");
    }

    @Override
    public void execute() {
        statisticalIndicator.ControlCenter = false;

        if(statisticalIndicator.NbBusInControlQ == 0) {
            Scheduler.add(Scheduler.simulationDate, new AccessControlEvent());
        }

        double repair = Math.random();

        if(repair < 0.3) {
            Scheduler.add(Scheduler.simulationDate, new RepairQueueEvent());
        }

    }
}