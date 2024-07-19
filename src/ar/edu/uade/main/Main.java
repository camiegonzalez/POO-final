package ar.edu.uade.main;

import ar.edu.uade.controlador.ControladorReproductor;
import ar.edu.uade.modelo.ReproductorAudio;
import ar.edu.uade.modelo.exceptions.AudioNoEncontradoException;
import ar.edu.uade.modelo.exceptions.AudioNoSoportadoException;
import ar.edu.uade.modelo.exceptions.UsuarioNoEncontradoException;
import ar.edu.uade.vista.VistaReproductor;

public class Main {
    public static void main(String[] args) throws Exception {
        // Configuración inicial
        ReproductorAudio.getInstance().crearUsuario("nacho");
        ReproductorAudio.getInstance().agregarCancion("El final es donde parti", "La Renga", 4);
        ReproductorAudio.getInstance().agregarPodcast("El cambio climatico", "Ambientacast", 60, 1, 3);

        reproducirAudio("nacho", "El final es donde parti");
        reproducirAudio("nacho", "El final es donde parti");
        reproducirAudio("nacho", "El cambio climatico");

        System.out.println("Tasa de compresion: " + ReproductorAudio.getInstance().calcularTasaCompresion("nacho"));

        // Inicializar la interfaz gráfica
        ReproductorAudio modelo = ReproductorAudio.getInstance();
        VistaReproductor vista = new VistaReproductor();
        ControladorReproductor controlador = new ControladorReproductor(modelo, vista);
        vista.setVisible(true);
    }

    private static void reproducirAudio(String username, String nombreAudio) {
        try {
            ReproductorAudio.getInstance().reproducirAudio(username, nombreAudio);
        } catch (UsuarioNoEncontradoException | AudioNoEncontradoException | AudioNoSoportadoException e) {
            System.out.println(e.getMessage() + ": " + nombreAudio);
        }
    }
}
