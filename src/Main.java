import Event.EndSimulationEvent;
import Event.Scheduler;

public class Main {


    public static void main (String[] args){
        double sumWaitingTimeBeforeControl=0d;
        double sumWaitingTimeBeforeRepair=0d;
        double sumUtilizationRepairCenterRate=0d;

        for (int i = 0; i < 500; i++) {
            Scheduler scheduler = new Scheduler(15);
            scheduler.start();

            sumWaitingTimeBeforeControl += EndSimulationEvent.averageWaitingTimeBeforeControl;
            sumWaitingTimeBeforeRepair += EndSimulationEvent.averageWaitingTimeBeforeRepair;
            sumUtilizationRepairCenterRate += EndSimulationEvent.utilizationRepairCenterRate;
        }

        System.out.println("Moyenne TpsAttMoyAvtCtrl = " + sumWaitingTimeBeforeControl/500);
        System.out.println("Moyenne TpsAttMoyAvtRep = " + sumWaitingTimeBeforeRepair/500);
        System.out.println("Moyenne TauxUtilisationCentreRep = " + sumUtilizationRepairCenterRate/500);
        //start echéncier
    }


}

