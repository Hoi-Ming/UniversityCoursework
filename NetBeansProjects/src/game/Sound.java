package game;
import city.soi.platform.*;
import sun.audio.*;
import java.io.*;
import java.util.Random;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hoi Ming
 */
public class Sound {
    
    /** Background Music. */
     private static SoundClip backgroundSound; 
     private static SoundClip backgroundSound2;
     private static SoundClip endingSound;
     private static SoundClip pikachuSound;
     
      /** Initialises all sounds */
    public Sound() {
        try {
            backgroundSound = new SoundClip ("Sound/Pokemon.wav");
            backgroundSound2 = new SoundClip ("Sound/Pokemon2.wav");
            endingSound = new SoundClip ("Sound/Ending.wav");
            pikachuSound = new SoundClip ("Sound/Pikachu.wav");
        }
        catch (Exception e) {
            System.out.println("Please try another file, there is an error." + e);
        }
    }
    
     /** Loop background music 1*/
    public void playBackgroundSound() {
        try {
            //backgroundMusic1 = new SoundClip("Sounds/back1.wav");
            backgroundSound.loop();
        } catch (Exception e) {
            System.out.println("Please try another file, there is an error." + e);
        }
    }
    /** Stop music*/
    public void stopBackgroundSound1() {
        try {
            backgroundSound.stop();
        } catch (Exception e) {
            System.out.println("Try another file, error found." + e);
        }
    }
    
         /** Loop background music 2*/
    public void playBackgroundSound2() {
        try {
            //backgroundMusic1 = new SoundClip("Sounds/back1.wav");
            backgroundSound2.loop();
        } catch (Exception e) {
            System.out.println("Please try another file, there is an error." + e);
        }
    }
    /** Stop music*/
    public void stopBackgroundSound2() {
        try {
            backgroundSound2.stop();
        } catch (Exception e) {
            System.out.println("Try another file, error found." + e);
        }
    }
    /** Ending Music*/
    public void playEnding() {
        try {
            endingSound.loop();
        } catch (Exception e) {
            System.out.println("Try another file, error found." + e);
        }
    }
        /** Ending Music*/
    public void stopEnding() {
        try {
            endingSound.stop();
        } catch (Exception e) {
            System.out.println("Try another file, error found." + e);
        }
    }
    /** Sound when collected pikachu*/
    public void playPikachu() {
        try {
            pikachuSound.play();
        } catch (Exception e) {
            System.out.println("Try another file, error found." + e);
        }
    }
        /** Stops all music*/
    public void stopAllMusic() {
        try {
            backgroundSound.stop();
            backgroundSound2.stop();
        } catch (Exception e) {
            System.out.println("Please try another file, there is an error." + e);
        }
    }
    
}
