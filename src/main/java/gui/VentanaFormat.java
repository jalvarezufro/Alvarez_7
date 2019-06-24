/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domProblema.FormateoTexto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author JAVIER
 */
public class VentanaFormat extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextArea cajaTexto;
    private JButton botonFormat;
    private JButton botonOtro;
    private String direccion;

    public VentanaFormat(String direccion) {
        this.setSize(500, 500);
        this.setTitle("Formateo");
        iniciarComponentes(direccion);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void iniciarComponentes(String direccion) {
        iniciarPaneles();
        crearCajas(direccion
        );
        crearBotones(direccion
        );

    }

    private void iniciarPaneles() {
        panel = new JPanel();

        panel.setLayout(null);

        this.getContentPane().add(panel); //agrega un panel a la ventana

    }

    private void crearCajas(String direccion) {
        FormateoTexto format = new FormateoTexto();
        cajaTexto = new JTextArea();
        cajaTexto.setText(format.leer(direccion));
        //cajaTexto.setBounds(85, 240, 340, 150);

        JScrollPane sp = new JScrollPane(cajaTexto);
        sp.setBounds(85, 220, 360, 200);

        panel.add(sp);
    }

    private void crearBotones(String direccion) {
        botonFormat = new JButton("Formateo texto");
        botonOtro = new JButton("Cargar otro");

        //boton 1
        botonFormat.setBounds(85, 100, 125, 75);
        panel.add(botonFormat);
        ActionListener formatListen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FormateoTexto format = new FormateoTexto();
                String textoFormat = format.diferenciarArchivo(direccion);
                cajaTexto.setText(textoFormat);

            }
        };
        botonFormat.addActionListener(formatListen);

        //boton 2
        botonOtro.setBounds(285, 100, 126, 75);
        panel.add(botonOtro);
        ActionListener formatOtro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal volver = new VentanaPrincipal();
                volver.setVisible(true);
                dispose();

            }
        };
        botonOtro.addActionListener(formatOtro);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
