package StatePattern;

//State Interface
interface AudioPlayerState {
    void play();
    void pause();
    void stop();
}

// Concrete state classes
class PlayingState implements AudioPlayerState {
    @Override
    public void play() {
        System.out.println("Already playing the audio.");
    }

    @Override
    public void pause() {
        System.out.println("Pausing the audio.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the audio.");
    }
}

class PausedState implements AudioPlayerState {
    @Override
    public void play() {
        System.out.println("Resuming the audio.");
    }

    @Override
    public void pause() {
        System.out.println("Already paused the audio.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the audio.");
    }
}

class StoppedState implements AudioPlayerState {
    @Override
    public void play() {
        System.out.println("Playing the audio.");
    }

    @Override
    public void pause() {
        System.out.println("Audio is stopped. Cannot pause.");
    }

    @Override
    public void stop() {
        System.out.println("Already stopped the audio.");
    }
}

// AudioPlayer Context class
class AudioPlayer {
    private AudioPlayerState currentState;

    public AudioPlayer() {
        // Initialize with a default state
        currentState = new StoppedState();
    }

    public void setState(AudioPlayerState state) {
        currentState = state;
    }

    public void play() {
        currentState.play();
    }

    public void pause() {
        currentState.pause();
    }

    public void stop() {
        currentState.stop();
    }
}

// Usage example
public class StatePatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        // Initial state: Stopped
        audioPlayer.play();  // Output: Playing the audio.
        audioPlayer.pause(); // Output: Audio is stopped. Cannot pause.

        // Change state to Playing
        audioPlayer.setState(new PlayingState());
        audioPlayer.play();  // Output: Already playing the audio.
        audioPlayer.pause(); // Output: Pausing the audio.

        // Change state to Paused
        audioPlayer.setState(new PausedState());
        audioPlayer.play();  // Output: Resuming the audio.
        audioPlayer.stop();  // Output: Stopping the audio.

        // Change state to Stopped
        audioPlayer.setState(new StoppedState());
        audioPlayer.pause(); // Output: Audio is stopped. Cannot pause.
        audioPlayer.stop();  // Output: Already stopped the audio.
    }
}
