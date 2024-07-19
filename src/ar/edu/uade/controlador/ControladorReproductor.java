package ar.edu.uade.controlador;

import ar.edu.uade.modelo.*;
import ar.edu.uade.vista.AudioView;
import ar.edu.uade.vista.VistaReproductor;
import ar.edu.uade.modelo.exceptions.UsuarioNoEncontradoException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControladorReproductor {
    private ReproductorAudio modelo;
    private VistaReproductor vista;

    public ControladorReproductor(ReproductorAudio modelo, VistaReproductor vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.addBuscarListener(new BuscarListener());
    }

    public class BuscarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nombreUsuario = vista.getNombreUsuario();
            try {
                List<Audio> audios = modelo.obtenerAudiosUsuario(nombreUsuario);
                List<AudioView> audioViews = new ArrayList<>();
                for (Audio audio : audios) {
                    AudioView audioView = new AudioView(
                            nombreUsuario,
                            audio.getNombre(),
                            audio.getTipo(),
                            audio.getAutor(),
                            audio.getDuracion(),
                            audio.tasaDeCompresion()
                    );
                    audioViews.add(audioView);
                }
                vista.setResultado(audioViews);
            } catch (UsuarioNoEncontradoException ex) {
                vista.setResultado(new ArrayList<>()); // Clear results on exception
                JOptionPane.showMessageDialog(vista, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
