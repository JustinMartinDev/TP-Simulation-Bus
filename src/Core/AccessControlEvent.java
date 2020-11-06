package Core;

public class AccessControlEvent extends EventSimulator {
    public AccessControlEvent() {
        super("Accès au contrôle");
    }

    @Override
    public void execute() {

        statisticalIndicator.NbBusInControlQ -= 1;

        statisticalIndicator.ControlCenter = true;

        scheduler.add(dateSimu + getUni(1.0/4.0, 13.0/12.0), new DepartureControlEvent());

    }
}
