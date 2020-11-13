package Core;

import Event.EventSimulator;

public class EventDatePair {
        private Double dateToRelease;
        private EventSimulator event;

        public EventDatePair(Double dateToRelease, EventSimulator event){
            this.event = event;
            this.dateToRelease = dateToRelease;
        }

        public Double getDateToRelease(){ return dateToRelease; }
        public EventSimulator getEvent(){ return event; }
}
