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

        Scheduler.aireControlQ=0f;
        Scheduler.aireRepairQ=0f;
        Scheduler.aireRepairCenter=0f;

        statisticalIndicator.NbBusInControlQ=0;
        statisticalIndicator.NbBusInRepairQ=0;
        statisticalIndicator.ControlCenter=false;
        statisticalIndicator.RepairCenter=0;

        Scheduler.add(Scheduler.simulationDate+ getExpo(2), new BusArrivalEvent());
        Scheduler.add(Scheduler.simulationDate,new BusArrivalEvent());
        Scheduler.add(Scheduler.dateMax,new EndSimulationEvent());

        /**
         *
         4. Insérer dans l'échéancier un événement ArrivéeBus à l'instant simulationDate + E(1/2)
         5. Insérer dans l'échéancier un événement Fin à l'instant 160
         */
    }
}
