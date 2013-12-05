package solitaire.player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Player
{          
    public static void playSoundVictoire() {
        new Thread(new Runnable() {
          public void run() {
              
            try {
                Clip clip = AudioSystem.getClip();
                InputStream audioSrc = getClass().getResourceAsStream("/sonVictoire.wav");
                InputStream bufferedIn = new BufferedInputStream(audioSrc);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
                clip.open(audioStream);
                clip.start(); 
            } catch (Exception e) {
                System.err.println("\n erreur avec le son sonVictoire.wav. " + e.getMessage());
            }
          }
        }).start();
      }

    public static synchronized void playSoundErreur()
    {
        new Thread(new Runnable() {
            public void run() {
                
              try {
                Clip clip = AudioSystem.getClip();
                InputStream audioSrc = getClass().getResourceAsStream("/erreur.wav");
                InputStream bufferedIn = new BufferedInputStream(audioSrc);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
                clip.open(audioStream);
                clip.start(); 
              } catch (Exception e) {
                System.err.println("\n erreur avec le son erreur.wav. " + e.getMessage());
              }
            }
          }).start();
        
    }
}
