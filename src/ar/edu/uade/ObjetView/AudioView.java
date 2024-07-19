package ar.edu.uade.vista;

public class AudioView {
    private String nombreUsuario;
    private String nombreAudio;
    private String tipoAudio;
    private String nombreAutor;
    private int duracion;
    private float tasaCompresion;

    public AudioView(String nombreUsuario, String nombreAudio, String tipoAudio, String nombreAutor, int duracion, float tasaCompresion) {
        this.nombreUsuario = nombreUsuario;
        this.nombreAudio = nombreAudio;
        this.tipoAudio = tipoAudio;
        this.nombreAutor = nombreAutor;
        this.duracion = duracion;
        this.tasaCompresion = tasaCompresion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreAudio() {
        return nombreAudio;
    }

    public String getTipoAudio() {
        return tipoAudio;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public int getDuracion() {
        return duracion;
    }

    public float getTasaCompresion() {
        return tasaCompresion;
    }
}
