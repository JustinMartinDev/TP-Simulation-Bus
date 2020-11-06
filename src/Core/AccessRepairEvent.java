package Core;

public class AccessRepairEvent extends EventSimulator{
    public AccessRepairEvent() {
        super("Accès au centre de réparation");
    }

    @Override
    public void execute() {
        statisticalIndicator.NbBusInRepairQ -= 1;
        statisticalIndicator.RepairCenter += 1;

        scheduler.add(dateSimu + getUni(2.1, 4.5), new DepartureRepairCenter());

    }
}
