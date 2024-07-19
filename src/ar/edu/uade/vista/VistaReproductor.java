package ar.edu.uade.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaReproductor extends JFrame {
    private JTextField nombreUsuarioField;
    private JButton buscarButton;
    private JTextArea resultadoArea;

    public VistaReproductor() {
        setTitle("Reproductor de Audio");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel label = new JLabel("Nombre de Usuario:");
        nombreUsuarioField = new JTextField(20);
        buscarButton = new JButton("Buscar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nombreUsuarioField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        add(buscarButton, gbc);

        resultadoArea = new JTextArea(15, 30);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);
    }

    public String getNombreUsuario() {
        return nombreUsuarioField.getText();
    }

    public void setResultado(List<AudioView> audioViews) {
        StringBuilder resultado = new StringBuilder();
        for (AudioView audioView : audioViews) {
            resultado.append("Nombre de usuario: ").append(audioView.getNombreUsuario()).append("\n");
            resultado.append("Nombre del audio: ").append(audioView.getNombreAudio()).append("\n");
            resultado.append("Tipo de audio: ").append(audioView.getTipoAudio()).append("\n");
            resultado.append("Nombre del autor: ").append(audioView.getNombreAutor()).append("\n");
            resultado.append("Duración: ").append(audioView.getDuracion()).append("\n");
            resultado.append("Tasa de compresión: ").append(audioView.getTasaCompresion()).append("\n\n");
        }
        resultadoArea.setText(resultado.toString());
    }

    public void addBuscarListener(ActionListener listener) {
        buscarButton.addActionListener(listener);
    }
}
