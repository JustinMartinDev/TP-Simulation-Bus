package Core;

public class DepartureControlEvent extends EventSimulator{
    public DepartureControlEvent() {
        super("Départ de la zone de contrôle");
    }

    @Override
    public void execute() {
        ControlCenter = true;

        if(NbBusInControlQ == 0) {
            scheduler.add(dateSimu, new AccessControlEvent());
        }

        double repair = Math.random();

        if(repair < 0.3) {
            scheduler.add(dateSimu, new RepairQueueEvent());
        }

    }
}
