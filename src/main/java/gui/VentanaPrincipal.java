package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import domProblema.FormateoTexto;

public class VentanaPrincipal extends JFrame implements ActionListener {

    VentanaFormat v2;
    JPanel panel;
    JTextField cajaTexto;
    JButton botonCarga;
    JLabel etiqueta;

    public VentanaPrincipal() {
        this.setSize(500, 500);
        this.setTitle("Inicio");
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void iniciarComponentes() {
        iniciarPaneles();
        crearCajas();
        crearEtiquetas();
        crearBotones();

    }

    private void iniciarPaneles() {
        panel = new JPanel();

        panel.setLayout(null);

        this.getContentPane().add(panel); //agrega un panel a la ventana

    }
    private void crearEtiquetas(){
        etiqueta = new JLabel("Ingresar nombre del archivo:");
        etiqueta.setBounds(125,40,200,50);
        panel.add(etiqueta);
    }

    private void crearCajas() {
        cajaTexto = new JTextField();
        cajaTexto.setBounds(125, 75, 250, 75);

        panel.add(cajaTexto);

    }

    private void crearBotones() {
        botonCarga = new JButton("Cargar Archivo");

        botonCarga.setBounds(190, 175, 125, 75);
        panel.add(botonCarga);

        //crear accion al boton
        ActionListener accionCarga = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FormateoTexto format = new FormateoTexto();
                String direccion = "Archivos\\"+cajaTexto.getText();
                v2 = new VentanaFormat(direccion);
                v2.setVisible(true);
                dispose();

            }
        };
        botonCarga.addActionListener(accionCarga);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
