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
        utilizationRepairCenterRate = Scheduler.aireRepairCenter/(2 * Scheduler.dateMax);


        System.out.println("Temps d'attente moyen avant contrôle = "+ statisticalIndicator.nbBus);
        System.out.println("Temps d'attente moyen avant réparation = "+ statisticalIndicator.nbBusRepaired);
    }

    protected static double getNext(int param){
        return Math.log(1 - new Random().nextDouble()) / (-param);
    }
}
