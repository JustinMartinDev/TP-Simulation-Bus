package Core;

import Core.EventSimulator;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;




public class Scheduler {

    private static TreeMap<Double, ArrayList<EventSimulator>> listEvent;
    public static double simulationDate;
    public static double dateMax;

    public static double aireControlQ=0f;
    public static double aireRepairQ=0f;
    public static double aireRepairCenter;



    public Scheduler(double dateMax){
        listEvent = new TreeMap<>();
        Scheduler.dateMax = dateMax;
    }


    public void start(){
        simulationDate = 0;
        new StartSimulationEvent().execute();

        while(!listEvent.isEmpty()){
            calcArea(listEvent.firstKey());
            simulationDate = listEvent.firstKey();
            for (EventSimulator event: listEvent.get(simulationDate)) {
                event.execute();
            }

            listEvent.remove(simulationDate);

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
            if (listEvent.containsKey(dbl)){
                listEvent.get(dbl).add(event);
            } else {
                ArrayList< EventSimulator> list = new ArrayList<>();
                list.add(event);
                listEvent.put(dbl, list);
            }
        }
    }

    public String toString() {
        String str = "";

        for (Map.Entry<Double,ArrayList<EventSimulator>> entry: listEvent.entrySet()) {
            for (EventSimulator event: entry.getValue()) {
                str +=  "Key : " + entry.getKey() + " / Value : " + event.toString();
            }
        }

        return str;
    }
}
