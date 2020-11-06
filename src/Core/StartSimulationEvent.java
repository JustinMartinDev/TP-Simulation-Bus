package Core;

import Core.EndSimulationEvent;
import Core.EventSimulator;

public class StartSimulationEvent extends EventSimulator {
    public StartSimulationEvent() {
        super("Début Simulation");
    }

    @Override
    public void execute() {
        statisticalIndicator.nbBus=0;
        statisticalIndicator.nbBusRepaired=0;

        statisticalIndicator.aireControlQ=0f;
        statisticalIndicator.aireRepairQ=0f;
        statisticalIndicator.aireRepairCenter=0f;

        statisticalIndicator.NbBusInControlQ=0;
        statisticalIndicator.NbBusInRepairQ=0;
        statisticalIndicator.ControlCenter=false;
        statisticalIndicator.RepairCenter=0;

        Scheduler.add(Scheduler.simulationDate+ EndSimulationEvent.getNext(2), new BusArrivalEvent());
        Scheduler.add(Scheduler.simulationDate,new BusArrivalEvent());

        /**
         *
         4. Insérer dans l'échéancier un événement ArrivéeBus à l'instant DateSimu + E(1/2)
         5. Insérer dans l'échéancier un événement Fin à l'instant 160
         */
    }
}
