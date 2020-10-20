package Core;

public class RepairQueueEvent extends EventSimulator {
    public RepairQueueEvent() {
        super("Accès à la file de réparation");
    }

    @Override
    public void execute() {
        NbBusInRepairQ += 1;
        NbBusRepaired += 1;

        if(RepairCenter < 2) {
            scheduler.add(dateSimu, new AccessRepairEvent());
        }

    }
}
