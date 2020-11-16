package Event;

public class RepairQueueEvent extends EventSimulator {
    public RepairQueueEvent() {
        super("Accès à la file de réparation");
    }

    @Override
    public void execute() {
        System.out.println(name);
        statisticalIndicator.NbBusInRepairQ += 1;
        statisticalIndicator.nbBusRepaired += 1;

        if(statisticalIndicator.RepairCenter < 2) {
            Scheduler.add(Scheduler.simulationDate, new AccessRepairEvent());
        }

    }
}
