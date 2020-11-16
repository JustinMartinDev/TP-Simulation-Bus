package Event;

import Core.EventDatePair;

import java.util.*;

public class Scheduler {

    //private static TreeMap<Double, ArrayList<EventSimulator>> listEvent;
    private static ArrayList<EventDatePair> listEvent;
    public static double simulationDate;
    public static double dateMax;

    public static double aireControlQ=0f;
    public static double aireRepairQ=0f;
    public static double aireRepairCenter=0f;


    public Scheduler(double dateMax){
        listEvent = new ArrayList<EventDatePair>();
        Scheduler.dateMax = dateMax;
    }

    public void start(){
        simulationDate = 0f;
        add(simulationDate, new StartSimulationEvent());

        while(!listEvent.isEmpty()){
            EventDatePair eventPairToRelease = listEvent.get(0);
            calcArea(eventPairToRelease.getDateToRelease());
            simulationDate = eventPairToRelease.getDateToRelease();
            eventPairToRelease.getEvent().execute();

            if(listEvent.size() > 0)
                listEvent.remove(0);

            listEvent.sort(Comparator.comparing(EventDatePair::getDateToRelease));
        }

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
        if(dbl <= dateMax){
            listEvent.add(new EventDatePair(dbl, event));

//            if (listEvent.containsKey(dbl)){
//                listEvent.get(dbl).add(event);
//            } else {
//                ArrayList< EventSimulator> list = new ArrayList<>();
//                list.add(event);
//                listEvent.put(dbl, list);
//            }
        }
    }

    public String toString() {
        String str = "";

//        for (Map.Entry<Double,ArrayList<EventSimulator>> entry: listEvent.entrySet()) {
//            for (EventSimulator event: entry.getValue()) {
//                str +=  "Key : " + entry.getKey() + " / Value : " + event.toString();
//            }
//        }

        return str;
    }

    public double getAireControlQ() {return aireControlQ;    }

    public double getAireRepairQ() {return aireRepairQ;    }

    public double getAireRepairCenter() {return  aireRepairCenter;}
}
