package LLD.DesignPatterns.Structural.Facade;

public class EntertainmentSystemFacade {

    TV tv;
    MusicSystem musicSystem;

    EntertainmentSystemFacade(){
        tv = new TV();
        musicSystem = new MusicSystem();

    }


    void turnOnEU()
    {
        tv.turnOn();
        musicSystem.play();
    }
}
