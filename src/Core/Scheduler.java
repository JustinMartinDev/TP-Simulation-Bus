package Core;

import Core.EventSimulator;
import javafx.collections.transformation.SortedList;
import javafx.util.Pair;

import java.util.*;


public class Scheduler {

    //private static TreeMap<Double, ArrayList<EventSimulator>> listEvent;
    private static ArrayList<Pair<Double,EventSimulator>> listEvent;
    public static double simulationDate;
    public static double dateMax;

    public static double aireControlQ=0f;
    public static double aireRepairQ=0f;
    public static double aireRepairCenter;



    public Scheduler(double dateMax){
        listEvent = new ArrayList<Pair<Double, EventSimulator>>();
        Scheduler.dateMax = dateMax;
    }


    public void start(){
        simulationDate = 0;
        new StartSimulationEvent().execute();

        while(!listEvent.isEmpty()){
            calcArea(listEvent.get(0).getKey());
            simulationDate = listEvent.get(0).getKey();
            listEvent.get(0).getValue().execute();

            listEvent.remove(0);

            Collections.sort(listEvent, new Comparator<Pair<Double,EventSimulator>>() {
                @Override
                public int compare(Pair<Double,EventSimulator> o1, Pair<Double,EventSimulator> o2) {
                    return (o1.getKey().compareTo(o2.getKey()));
                }
            });


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
            listEvent.add(new Pair<>(dbl, event));

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
}
