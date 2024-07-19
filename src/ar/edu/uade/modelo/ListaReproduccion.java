package ar.edu.uade.modelo;

import ar.edu.uade.modelo.exceptions.AudioNoSoportadoException;

import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion {

    private List<Audio> audios;

    public ListaReproduccion() {
        audios = new ArrayList<>();
    }

    public void reproducirAudio(Audio audio) throws AudioNoSoportadoException {
        if (!contengoAudio(audio) && soportoTipoAudio(audio)) {
            this.audios.add(audio);
        } else {
            throw new AudioNoSoportadoException();
        }
    }

    private boolean soportoTipoAudio(Audio audio) {
        if (this.audios.isEmpty()) {
            return true;
        } else {
            return this.audios.get(0).sosAudioCompatible(audio);
        }
    }

    private boolean contengoAudio(Audio audio) {
        return this.audios.contains(audio);
    }

    public float calcularTasaCompresion() {
        float tasaCompresion = 0;
        for (Audio audio : this.audios) {
            tasaCompresion += audio.tasaDeCompresion();
        }
        return tasaCompresion;
    }

    public List<Audio> getAudios() {
        return audios;
    }
}
