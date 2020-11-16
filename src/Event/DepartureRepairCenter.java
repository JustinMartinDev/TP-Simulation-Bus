package Event;

public class DepartureRepairCenter extends EventSimulator{
    public DepartureRepairCenter() {
        super("Départ du centre de réparation");
    }

    @Override
    public void execute() {
        System.out.println(name);
        statisticalIndicator.RepairCenter -= 1;

        if(statisticalIndicator.NbBusInRepairQ != 0) {
            Scheduler.add(Scheduler.simulationDate, new AccessRepairEvent());
        }

    }
}
