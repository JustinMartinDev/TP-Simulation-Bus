package Event;

import java.util.Random;

public class EndSimulationEvent extends EventSimulator {

    public static double averageWaitingTimeBeforeControl, averageWaitingTimeBeforeRepair, utilizationRepairCenterRate;

    public EndSimulationEvent() {
        super("Fin Simulation");
    }

    @Override
    public void execute() {
        System.out.println(name);

        Scheduler.clear();
        averageWaitingTimeBeforeControl = Scheduler.aireControlQ/statisticalIndicator.nbBus;
        averageWaitingTimeBeforeRepair = Scheduler.aireRepairQ/statisticalIndicator.nbBusRepaired;
        utilizationRepairCenterRate = Scheduler.aireRepairCenter/(2 * 160);

        /*
        System.out.println("Temps d'attente moyen avant contrôle = "+ averageWaitingTimeBeforeControl);
        System.out.println("Temps d'attente moyen avant réparation = "+ averageWaitingTimeBeforeRepair);
        System.out.println("Taux d'utilisation du centre de réparation = "+ utilizationRepairCenterRate);*/
    }

    protected static double getNext(int param){
        return Math.log(1 - new Random().nextDouble()) / (-param);
    }
}
