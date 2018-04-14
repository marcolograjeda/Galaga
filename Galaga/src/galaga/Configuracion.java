/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Junior
 */
public class Configuracion {
    JCheckBox cbATiempo, cbPuntos, cbVelocidad, cbDTiempo, cbPenalizacion, cbCongelacion;
    String[] elementosFrecuencia = {"Poco Frecuente", "Normal", "Muy Frecuente"};
    JComboBox listaFrecuencia = new JComboBox(elementosFrecuencia);
    String[] elementosVelocidad = {"Normal", "Rápida"};
    JComboBox listaVelocidad = new JComboBox(elementosVelocidad);
    JSpinner spinner = new JSpinner();
    public JDialog crearConfiguracion(boolean aTiempo, boolean puntos, boolean aVelocidad, boolean dTiempo, 
            boolean penalizacion, boolean congelacion, int frecuencia, int nivelVelocidad, int tiempoP){
        JFrame frameConfiguracion = new JFrame();
        frameConfiguracion.setSize(1000,800);
        frameConfiguracion.setLayout(null);
        frameConfiguracion.setResizable(false);
        frameConfiguracion.setTitle("Configuración");
        
        JLabel lblItems = new JLabel("Items");
        lblItems.setBounds(220, 5, 60, 30);
        lblItems.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        
        
        cbATiempo = new JCheckBox("Aumento de Tiempo", aTiempo);
        cbATiempo.setBounds(15, 45, 230, 20);
        cbATiempo.setFont(new Font("Segoe UI", 0, 12));
        
        cbPuntos = new JCheckBox("Puntos Extras", puntos);
        cbPuntos.setBounds(15, 75, 230, 20);
        cbPuntos.setFont(new Font("Segoe UI", 0, 12));
        
        cbVelocidad = new JCheckBox("Aumento de Velocidad", aVelocidad);
        cbVelocidad.setBounds(15, 105, 230, 20);
        cbVelocidad.setFont(new Font("Segoe UI", 0, 12));
        
        cbDTiempo = new JCheckBox("Disminución de Tiempo", dTiempo);
        cbDTiempo.setBounds(15, 135, 230, 20);
        cbDTiempo.setFont(new Font("Segoe UI", 0, 12));
        
        cbPenalizacion = new JCheckBox("Penalización", penalizacion);
        cbPenalizacion.setBounds(15, 165, 230, 20);
        cbPenalizacion.setFont(new Font("Segoe UI", 0, 12));
        
        cbCongelacion = new JCheckBox("Congelación", congelacion);
        cbCongelacion.setBounds(15, 195, 230, 20);
        cbCongelacion.setFont(new Font("Segoe UI", 0, 12));
        
        JDialog dialogConfiguracion = new JDialog(frameConfiguracion);
        dialogConfiguracion.setModal(true);
        dialogConfiguracion.setSize(500, 600);
        
        JLabel lblFrecuencia = new JLabel("Frecuencia");
        lblFrecuencia.setBounds(15, 225, 70, 30);
        lblFrecuencia.setFont(new Font("Segoe UI", 0, 15));
        
        
        listaFrecuencia.setBounds(100, 225, 130, 30);
        listaFrecuencia.setEditable(false);
        listaFrecuencia.setSelectedIndex(frecuencia);
        
        JLabel lblVelocidad = new JLabel("Velocidad");
        lblVelocidad.setBounds(208, 270, 85, 30);
        lblVelocidad.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        JLabel lblNivel = new JLabel("Nivel");
        lblNivel.setBounds(15, 310, 70, 30);
        lblNivel.setFont(new Font("Segoe UI", 0, 15));
        
        
        listaVelocidad.setBounds(100, 310, 130, 30);
        listaVelocidad.setEditable(false);
        listaVelocidad.setSelectedIndex(nivelVelocidad);
        
        JLabel lblDuracion = new JLabel("Duración");
        lblDuracion.setBounds(210, 375, 80, 30);
        lblDuracion.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        JLabel lblTiempo = new JLabel("Tiempo");
        lblTiempo.setBounds(15, 415, 70, 30);
        lblTiempo.setFont(new Font("Segoe UI", 0, 12));
        
        JTextField txtTiempo = new JTextField();
        txtTiempo.setBounds(100, 415, 175, 30);
        
        
        spinner.setBounds(100, 415, 70, 30);
        SpinnerNumberModel nm = new SpinnerNumberModel(tiempoP,1,10,1);
        
        spinner.setModel(nm);
        
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        
        btnGuardar.setBounds(155, 480, 90, 30);
        btnCancelar.setBounds(255, 480, 90, 30);
        
        btnGuardar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed (ActionEvent e){
                    editarConfiguracion();
                }
            }
        );
        
        dialogConfiguracion.add(btnGuardar);
        dialogConfiguracion.add(btnCancelar);
        dialogConfiguracion.add(spinner);
        dialogConfiguracion.add(lblTiempo);
        dialogConfiguracion.add(lblNivel);
        dialogConfiguracion.add(lblFrecuencia);
        dialogConfiguracion.add(listaVelocidad);
        dialogConfiguracion.add(listaFrecuencia);
        dialogConfiguracion.add(cbATiempo);
        dialogConfiguracion.add(cbPuntos);
        dialogConfiguracion.add(cbVelocidad);
        dialogConfiguracion.add(cbDTiempo);
        dialogConfiguracion.add(cbPenalizacion);
        dialogConfiguracion.add(cbCongelacion);
        dialogConfiguracion.add(lblItems);
        dialogConfiguracion.add(lblVelocidad);
        dialogConfiguracion.add(lblDuracion);
        dialogConfiguracion.setLayout(null);
        return dialogConfiguracion;
    }
    
    public void editarConfiguracion(){
        VistaPrincipal vp = new VistaPrincipal();
        vp.editarConfiguracion(cbATiempo.isSelected(), cbPuntos.isSelected(), cbVelocidad.isSelected(), 
                cbDTiempo.isSelected(), cbPenalizacion.isSelected(), cbCongelacion.isSelected(), 
                listaFrecuencia.getSelectedIndex(), listaVelocidad.getSelectedIndex(), spinner.getComponentCount());
    }
}
