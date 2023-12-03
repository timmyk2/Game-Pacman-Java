/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


/**
 *
 * @author acer
 */
public class BackgroundMusicPlayer  {
    private Clip clip;
    private FloatControl volumeControl;   
    public void playMusic(String musicFilePath) {
        try {
            File file = new File(musicFilePath);
            if (file.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
               volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                clip.start();

            } else {
                System.out.println("File not found: " + musicFilePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playMusic() {
        if (clip != null) {
            clip.start();
        }
    }

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void setVolume(float volume) {
          // Chuyển đổi giá trị âm lượng từ JSlider thành phần giảm âm lượng của BackgroundMusicPlayer
      if (volumeControl != null) {
            float range = volumeControl.getMaximum() - volumeControl.getMinimum();
            float gain = (range * volume) + volumeControl.getMinimum();
            volumeControl.setValue(gain);
        } else {
            System.out.println("Error: volumeControl is null");
        }
    }
}
