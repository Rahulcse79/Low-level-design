interface ICar {
    
    float baseWeight = 1500;
    void start();
    void stop();
    float getWeight();
}

class Scorpio implements ICar {
    
    @Override
    public void start() { System.out.println("Scorpio is starting.."); }
    
    @Override
    public void stop() { System.out.println("Scorpio is stop.."); }
    
    @Override
    public float getWeight() { return baseWeight; }
}

abstract class ScorpioDecorator implements ICar {
    
}

class BulletProof extends ScorpioDecorator {
    
    ICar scorpio;
    
    public BulletProof( ICar meriScorpio ) {
        this.scorpio = meriScorpio;
    }
    
    @Override
    public void start() {
        scorpio.start();
    }
    
    @Override
    public void stop() {
        scorpio.stop();
    }
    
    @Override
    public float getWeight() {
        return 300f + scorpio.getWeight();
    }
}

public class Main {
    public static void main(String[] args) {
        ICar scorpio = new Scorpio();
        ICar BulletProofScorpio = new BulletProof(scorpio);
        System.out.println("Normal Scorpio weight: " + scorpio.getWeight());
        float totalWeight = BulletProofScorpio.getWeight();
        System.out.println("Printing weight: " + totalWeight);
    }
}
