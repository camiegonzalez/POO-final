package ar.edu.uade.modelo;

import java.util.List;

import ar.edu.uade.modelo.exceptions.AudioNoSoportadoException;

public class Usuario {
    private String username;
    private ListaReproduccion listaReproduccion;

    public Usuario(String username) {
        this.username = username;
        this.listaReproduccion = new ListaReproduccion();
    }

    public boolean sosUsuario(String username) {
        return this.username.equals(username);
    }

    public void reproducirAudio(Audio audio) throws AudioNoSoportadoException {
        this.listaReproduccion.reproducirAudio(audio);
    }

    public float calcularTasaCompresion() {
        return this.listaReproduccion.calcularTasaCompresion();
    }

    public List<Audio> obtenerAudios() {
        return this.listaReproduccion.getAudios();
    }

    public String getUsername() {
        return username;
    }
}
