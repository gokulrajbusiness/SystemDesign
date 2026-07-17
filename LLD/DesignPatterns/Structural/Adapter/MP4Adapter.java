package LLD.DesignPatterns.Structural.Adapter;

public class MP4Adapter implements MediaPlayer{

    private MP4Player mp4Player;

    public MP4Adapter() {
        this.mp4Player = new MP4Player();
    }

    @Override
    public void play() {
        mp4Player.playmp4();
    }
}
