package solitaire.player;

import java.io.File;

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
              File soundFile = new File("ressources\\sonVictoire.wav");
              AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
              clip.open(audioIn);
              clip.start(); 
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
      }

    public static void playSoundErreur()
    {
        new Thread(new Runnable() {
            public void run() {
                
              try {
                Clip clip = AudioSystem.getClip();
                File soundFile = new File("ressources\\erreur.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                clip.open(audioIn);
                clip.start(); 
              } catch (Exception e) {
                System.err.println(e.getMessage());
              }
            }
          }).start();
        
    }
}
