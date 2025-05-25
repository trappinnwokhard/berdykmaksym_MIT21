package practica.abstract;

public class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the piano.");
    }
}