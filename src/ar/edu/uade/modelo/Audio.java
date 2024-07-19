package ar.edu.uade.modelo;

public abstract class Audio {
    private String nombre;
    private String autor;
    protected int duracion;

    protected Audio(String nombre, String autor, int duracion) {
        this.nombre = nombre;
        this.autor = autor;
        this.duracion = duracion;
    }

    public abstract boolean sosAudioCompatible(Audio audio);

    public abstract float tasaDeCompresion();

    public boolean sosAudio(String nombreAudio) {
        return this.nombre.equals(nombreAudio);
    }

    public boolean sosPodcast() {
        return false;
    }

    public boolean sosCancion() {
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public int getDuracion() {
        return duracion;
    }

    public abstract String getTipo();
}
