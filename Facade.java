class Projector {
    public void on() { System.out.println("Projector on"); }
    public void setInput(String input) { System.out.println("Projector input set to " + input); }
    public void off() { System.out.println("Projector off"); }
}

class DVDPlayer {
    public void on() { System.out.println("DVD Player on"); }
    public void play(String movie) { System.out.println("Playing movie: " + movie); }
    public void stop() { System.out.println("Stopping DVD"); }
    public void off() { System.out.println("DVD Player off"); }
}

class SurroundSoundSystem {
    public void on() { System.out.println("Surround sound on"); }
    public void setVolume(int level) { System.out.println("Volume set to " + level); }
    public void off() { System.out.println("Surround sound off"); }
}

class Lights {
    public void on() { System.out.println("Lights on"); }
    public void dim(int level) { System.out.println("Lights dimmed to " + level + "%"); }
    public void off() { System.out.println("Lights off"); }
}

class HomeTheaterFacade {
    private Projector projector;
    private DVDPlayer dvdPlayer;
    private SurroundSoundSystem surroundSoundSystem;
    private Lights lights;
    
    public HomeTheaterFacade(Projector projector, DVDPlayer dvdPlayer, SurroundSoundSystem surroundSoundSystem, Lights lights) {
        this.projector = projector;
        this.dvdPlayer = dvdPlayer;
        this.surroundSoundSystem = surroundSoundSystem;
        this.lights = lights;
    }
    
    public void playMovie(String movie)
    {
        System.out.println("\n --- Starting Movie Night ---");
        lights.on();
        lights.dim(20);
        dvdPlayer.on();
        dvdPlayer.play(movie);
        surroundSoundSystem.on();
        surroundSoundSystem.setVolume(8);
        projector.on();
        projector.setInput("DVD");
    }
    
    public void stopMovie() {
        System.out.println("\n --- Stop movie ---");
        lights.off();
        dvdPlayer.off();
        surroundSoundSystem.off();
        projector.off();
    }
}

public class Main {
    public static void main(String[] args) {
        Projector projector = new Projector();
        DVDPlayer dvdPlayer = new DVDPlayer();
        SurroundSoundSystem surroundSoundSystem = new SurroundSoundSystem();
        Lights lights = new Lights();
        
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, dvdPlayer, surroundSoundSystem, lights);
        homeTheater.playMovie("Mela");
        homeTheater.stopMovie();
    }
}
