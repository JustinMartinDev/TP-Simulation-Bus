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
        averageWaitingTimeBeforeControl = Scheduler.aireControlQ/(statisticalIndicator.nbBus-statisticalIndicator.NbBusInControlQ);
        averageWaitingTimeBeforeRepair = Scheduler.aireRepairQ/(statisticalIndicator.nbBusRepaired-statisticalIndicator.NbBusInControlQ);
        utilizationRepairCenterRate = Scheduler.aireRepairCenter/(2 * Scheduler.simulationDate);

        System.out.println("Temps d'attente moyen avant contrôle = "+ averageWaitingTimeBeforeControl);
        System.out.println("Temps d'attente moyen avant réparation = "+ averageWaitingTimeBeforeRepair);
    }

    protected static double getNext(int param){
        return Math.log(1 - new Random().nextDouble()) / (-param);
    }
}
