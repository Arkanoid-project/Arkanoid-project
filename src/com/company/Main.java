package com.company;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException, LineUnavailableException {
        File file = new File("Shawn Mendes, Camila Cabello - Señorita.mp3");
        if (file.exists()) {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("Shawn Mendes, Camila Cabello - Señorita.mp3");
            //for external storage Path
            assert is != null;
            AudioInputStream sound = new AudioInputStream((TargetDataLine) is);
            Clip clip;
            // load the sound into memory (a Clip)
            clip = AudioSystem.getClip();
            clip.open(sound);
        }
        Window window = new Window();
    boolean isLvlCreated = false;
    }
}
