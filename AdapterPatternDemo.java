// Target interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adapter class
class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

// Adapter class
class MediaPlayerAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaPlayerAdapter(AdvancedMediaPlayer advancedMediaPlayer) {
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

// Client code
public class AdapterPatternDemo {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayerAdapter(new AdvancedMediaPlayer());

        mediaPlayer.play("vlc", "sample.vlc");
        mediaPlayer.play("mp4", "sample.mp4");
    }
}
