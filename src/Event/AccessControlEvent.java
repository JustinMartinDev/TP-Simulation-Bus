package Event;

public class AccessControlEvent extends EventSimulator {
    public AccessControlEvent() {
        super("Accès au contrôle");
    }

    @Override
    public void execute() {
        System.out.println(name);
        statisticalIndicator.NbBusInControlQ -= 1;

        statisticalIndicator.ControlCenter = true;

        Scheduler.add(Scheduler.simulationDate + getUni(1.0/4.0, 13.0/12.0), new DepartureControlEvent());

    }
}
