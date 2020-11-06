package Core;

import Core.EventSimulator;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;




public class Scheduler {

    private TreeMap<Double, ArrayList<EventSimulator>> listEvent;
    double dateMax;



    public Scheduler(double dateMax){
        listEvent = new TreeMap<>();
        this.dateMax = dateMax;
    }




    public void addEvent(Double dbl, EventSimulator event){
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
