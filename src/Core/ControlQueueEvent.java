package Core;

public class ControlQueueEvent extends EventSimulator {
    public ControlQueueEvent() {
        super("Arrivée d'un bus dans la file de contrôle");
    }

    @Override
    public void execute() {

        NbBusInControlQ += 1;

        if(ControlCenter == true)
        {
            scheduler.add(dateSimu, new AccessControlEvent());
        }
    }
}
