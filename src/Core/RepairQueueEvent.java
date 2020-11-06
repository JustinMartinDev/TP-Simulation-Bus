package Core;

public class RepairQueueEvent extends EventSimulator {
    public RepairQueueEvent() {
        super("Accès à la file de réparation");
    }

    @Override
    public void execute() {
        statisticalIndicator.NbBusInRepairQ += 1;
        statisticalIndicator.nbBusRepaired += 1;

        if(statisticalIndicator.RepairCenter < 2) {
            scheduler.add(dateSimu, new AccessRepairEvent());
        }

    }
}
