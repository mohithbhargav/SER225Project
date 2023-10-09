package Level;

public class Level1 {
    private AudioManager audioManager;

    public Level1() {
        audioManager = new AudioManager();
        startLevel1();  // Start the level and the music when Level1 is instantiated.
    }

    public void startLevel1() {
        audioManager.loadSound("Resources/TheJourneyBegins.wav");
        audioManager.playSound();
    }

    public void endLevel1() {
        audioManager.stopSound();
        audioManager.close();  // release the audio resources when done
    }
    
    // Provide a way for other classes (like Player) to get the AudioManager
    public AudioManager getAudioManager() {
        return audioManager;
    }
}