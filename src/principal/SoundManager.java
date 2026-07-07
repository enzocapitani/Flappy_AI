package principal;

import java.net.URL;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {

    private static final HashMap<String, Clip> clips = new HashMap<>();
    
    public static void load(String nome, String caminho){
        try {
            URL url = SoundManager.class.getResource(caminho);
            
            if(url == null){
                System.out.println("Arquivo : "+caminho+" não encontrado");
                return;
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);

            Clip clip = AudioSystem.getClip();
            clip.open(audio);

            clips.put(nome, clip);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void play(String nome){
        Clip clip = clips.get(nome);

        if(clip == null) return;

        //clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }

    public static void loop(String nome){
         Clip clip = clips.get(nome);

        if (clip == null)
            return;

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void stop(String nome) {

        Clip clip = clips.get(nome);

        if (clip != null)
            clip.stop();
    }

    public static void stopAll() {

        for (Clip clip : clips.values())
            clip.stop();
    }

}
