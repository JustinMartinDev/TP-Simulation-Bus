package Core;

public abstract class EventSimulator {
    public String name;

    public EventSimulator(String name){
        this.name = name;
    }

    public abstract void execute();
}
