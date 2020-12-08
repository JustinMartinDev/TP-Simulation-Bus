package Event;

import Core.EventDatePair;

import java.util.*;

public class Scheduler {

    //private static TreeMap<Double, ArrayList<EventSimulator>> listEvent;
    private static ArrayList<EventDatePair> listEvent;
    public static double simulationDate;

    public static double aireControlQ=0f;
    public static double aireRepairQ=0f;
    public static double aireRepairCenter=0f;

    public static double dateMax = 0d;
    public static int nbMaxBus = 0;
    public static StringBuilder stringCSV;

    public Scheduler(double dateMax){
        listEvent = new ArrayList<EventDatePair>();
        Scheduler.dateMax = dateMax;
    }

    public Scheduler(int nbMaxBus){
        listEvent = new ArrayList<EventDatePair>();
        Scheduler.nbMaxBus = nbMaxBus;
    }

    public void start(){
        simulationDate = 0f;

        stringCSV = new StringBuilder();

        add(simulationDate, new StartSimulationEvent());
        while(!listEvent.isEmpty()){

            if(nbMaxBus > 0 && EventSimulator.statisticalIndicator.nbBus >= nbMaxBus){
                new EndSimulationEvent().execute();
                break;
            }

            EventDatePair eventPairToRelease = listEvent.get(0);
            calcArea(eventPairToRelease.getDateToRelease());
            simulationDate = eventPairToRelease.getDateToRelease();
            eventPairToRelease.getEvent().execute();

            if(listEvent.size() > 0)
                listEvent.remove(0);

            listEvent.sort(Comparator.comparing(EventDatePair::getDateToRelease));
        }
        System.out.println("Data 5b: " + stringCSV);
    }

    public void calcArea(double dateEvent){
        aireControlQ += (dateEvent - simulationDate)*EventSimulator.statisticalIndicator.NbBusInControlQ;
        aireRepairQ += (dateEvent - simulationDate)*EventSimulator.statisticalIndicator.NbBusInRepairQ;
        aireRepairCenter += (dateEvent - simulationDate)*EventSimulator.statisticalIndicator.RepairCenter;
    }

    public static void clear(){
        listEvent.clear();
    }

    public static void add(Double dbl, EventSimulator event){
        if(nbMaxBus>0 && EventSimulator.statisticalIndicator.nbBus < nbMaxBus || dateMax>0 && simulationDate < dateMax)
            listEvent.add(new EventDatePair(dbl, event));
    }

    public void showList(){
        for (EventDatePair event: listEvent){
            System.out.println(event.getDateToRelease() + "===>" + event.getEvent().name);
        }
    }

    public double getAireControlQ() {return aireControlQ;    }

    public double getAireRepairQ() {return aireRepairQ;    }

    public double getAireRepairCenter() {return  aireRepairCenter;}
}
