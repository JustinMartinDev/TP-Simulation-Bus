package Core;

public class DepartureRepairCenter extends EventSimulator{
    public DepartureRepairCenter() {
        super("Départ du centre de réparation");
    }

    @Override
    public void execute() {
        RepairCenter -= 1;

        if(NbBusInRepairQ == 0) {
            scheduler.add(dateSimu, new AccessRepairEvent());
        }

    }
}
