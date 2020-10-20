package Core;

public class AccessControlEvent extends EventSimulator {
    public AccessControlEvent() {
        super("Accès au contrôle");
    }

    @Override
    public void execute() {

        NbBusInControlQ -= 1;

        ControlCenter = false;

        scheduler.add(dateSimu + getUni(1.0/4.0, 13.0/12.0), new DepartureControlEvent());

    }
}
