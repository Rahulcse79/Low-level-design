import java.util.*;

class Scorpio implements IScorpioPrototype {
    
    ScorpioEngine scorpioEngine = new ScorpioEngine();
    
    @Override
    public void start() {
        System.out.println("Started");
    }
    
    @Override
    public IScorpioPrototype clone() {
        return new Scorpio();
    }
    
    @Override
    public void setEngine(ScorpioEngine scorpioEngine) {
        this.scorpioEngine = scorpioEngine;   
    }
}

class ScorpioEngine {
    
}

class ScorpioNEngine extends ScorpioEngine {
    
}

interface IScorpioPrototype {
    
    public IScorpioPrototype clone();
    void setEngine(ScorpioEngine scorpioEngine);
    public void start();
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        
        IScorpioPrototype prototype = new Scorpio();
        IScorpioPrototype scorpioN = prototype.clone();
        scorpioN.setEngine(new ScorpioNEngine());
    }
}
