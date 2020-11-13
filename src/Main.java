import Event.Scheduler;

public class Main {


    public static void main (String[] args){
        double sumAireControlQ=0f;
        double sumAireRepairQ=0f;
        double sumAireRepairCenter=0d;

        for (int i = 0; i < 500; i++) {
            Scheduler scheduler = new Scheduler(160);
            scheduler.start();

            sumAireControlQ += scheduler.getAireControlQ();
            sumAireRepairQ += scheduler.getAireRepairQ();
            sumAireRepairCenter += scheduler.getAireRepairCenter();
        }

        System.out.println("Average aireControlQ = " + sumAireControlQ/500);
        System.out.println("Average aireRepairQ = " + sumAireRepairQ/500);
        System.out.println("Average aireRepairCenter = " + sumAireRepairCenter/500);

        //start echéncier
    }


}

