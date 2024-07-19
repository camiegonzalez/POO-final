package ar.edu.uade.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.modelo.exceptions.AudioNoEncontradoException;
import ar.edu.uade.modelo.exceptions.AudioNoSoportadoException;
import ar.edu.uade.modelo.exceptions.UsuarioNoEncontradoException;

public class ReproductorAudio {
    private static final ReproductorAudio INSTANCE = new ReproductorAudio();
    private List<Usuario> usuarios;
    private List<Audio> audios;

    private ReproductorAudio() {
        usuarios = new ArrayList<>();
        audios = new ArrayList<>();
    }

    public static ReproductorAudio getInstance() {
        return INSTANCE;
    }

    public void reproducirAudio(String username, String nombreAudio)
            throws UsuarioNoEncontradoException, AudioNoEncontradoException, AudioNoSoportadoException {
        Usuario usuario = buscarUsuario(username);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException();
        }
        Audio audio = buscarAudio(nombreAudio);
        if (audio == null) {
            throw new AudioNoEncontradoException();
        }

        usuario.reproducirAudio(audio);
    }

    private Usuario buscarUsuario(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.sosUsuario(username)) {
                return usuario;
            }
        }
        return null;
    }

    private Audio buscarAudio(String nombreAudio) {
        for (Audio audio : audios) {
            if (audio.sosAudio(nombreAudio)) {
                return audio;
            }
        }
        return null;
    }

    public void crearUsuario(String string) {
        usuarios.add(new Usuario(string));
    }

    public void agregarCancion(String nombre, String autor, int duracion) {
        audios.add(new Cancion(nombre, autor, duracion));
    }

    public void agregarPodcast(String nombre, String autor, int duracion, int numeroCapitulo, int cantidadParticipantes) {
        audios.add(new Podcast(nombre, autor, duracion, numeroCapitulo, cantidadParticipantes));
    }

    public float calcularTasaCompresion(String username) throws UsuarioNoEncontradoException {
        Usuario usuario = buscarUsuario(username);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException();
        }
        return usuario.calcularTasaCompresion();
    }

    public List<Audio> obtenerAudiosUsuario(String username) throws UsuarioNoEncontradoException {
        Usuario usuario = buscarUsuario(username);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException();
        }
        return usuario.obtenerAudios();
    }
}
