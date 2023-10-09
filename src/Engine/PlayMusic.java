package Engine;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayMusic {
    Long currentFrame;
    Clip clip;
    String status;
    AudioInputStream audioInputStream;
    String filePath; // Now an instance variable instead of static

    // Constructor now accepts the audio file path as a parameter
    public PlayMusic(String audioFilePath) 
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.filePath = audioFilePath;

        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(Config.RESOURCES_PATH + filePath));

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void main(String[] args) {
        try {
            // Now we pass the file path directly to the constructor
            PlayMusic audioPlayer = new PlayMusic("Resources/TheJourneyBegins.wav");

            audioPlayer.play();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. stop");
                int c = sc.nextInt();
                audioPlayer.gotoChoice(c);
                if (c == 3)
                    break;
            }
            sc.close();
        }

        catch (Exception e) {
            System.out.println("Error with playing sound.");
            e.printStackTrace();
        }
    }

    // Work as the user enters his choice
    private void gotoChoice(int c) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        switch (c) {
            case 1:
                pause();
                break;
            case 2:
                resumeAudio();
                break;
            case 3:
                stop();
                break;
        }
    }

    // Method to play the audio
    public void play() {
        // start the clip
        clip.start();
        status = "play";
    }

    // Method to pause the audio
    public void pause() {
        if (status.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    // Method to resume the audio
    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (status.equals("play")) {
            System.out.println("Audio is already being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    // Method to reset audio stream
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(Config.RESOURCES_PATH + filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

	public Object getClip() {
		return null;
	}
}
