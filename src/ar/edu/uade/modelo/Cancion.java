package ar.edu.uade.modelo;

public class Cancion extends Audio {

    public Cancion(String nombre, String autor, int duracion) {
        super(nombre, autor, duracion);
    }

    @Override
    public boolean sosAudioCompatible(Audio audio) {
        return audio.sosCancion();
    }

    @Override
    public boolean sosCancion() {
        return true;
    }

    @Override
    public float tasaDeCompresion() {
        return this.duracion * 1.5f;
    }

    @Override
    public String getTipo() {
        return "Canción";
    }
}
