package Level;

public class Level2 {
    private AudioManager audioManager;

    public Level2() {
        audioManager = new AudioManager();
        startLevel2(); // Start the level and the music when Level1 is instantiated.
    }

    public void startLevel2() {
        audioManager.loadSound("Resources/TimeWindow.wav");
        audioManager.playSound();
    }

    public void endLevel2() {
        audioManager.stopSound();
        audioManager.close(); // release the audio resources when done
    }

    // Provide a way for other classes (like Player) to get the AudioManager
    public AudioManager getAudioManager() {
        return audioManager;
    }
}