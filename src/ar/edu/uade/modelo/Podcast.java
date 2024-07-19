package ar.edu.uade.modelo;

public class Podcast extends Audio {
    private int numeroCapitulo;
    private int cantidadParticipantes;

    public Podcast(String nombre, String autor, int duracion, int numeroCapitulo, int cantidadParticipantes) {
        super(nombre, autor, duracion);
        this.numeroCapitulo = numeroCapitulo;
        this.cantidadParticipantes = cantidadParticipantes;
    }

    @Override
    public boolean sosAudioCompatible(Audio audio) {
        return audio.sosPodcast();
    }

    @Override
    public boolean sosPodcast() {
        return true;
    }

    @Override
    public float tasaDeCompresion() {
        return this.duracion / this.cantidadParticipantes;
    }

    @Override
    public String getTipo() {
        return "Podcast";
    }
}
