package com.example.accesoadatos3.gui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;


import com.example.accesoadatos3.base.Tenista;
import com.toedter.calendar.JDateChooser;

/**
 * Dialog con el que el usuario introduce informaci�n sobre un Actor
 * para insertar o modificar
 * @author Santiago Faci
 * @version 1.0
 */
public class JTenista extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField tfNombre;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_2;

    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String genero;
    private float sueldo;
    private JDateChooser tfFechaNacimiento;

    public enum Accion {
        ACEPTAR, CANCELAR;
    }
    private Accion accion;

    /**
     * Getters y setters para obtener y fijar informaci�n en la ventana
     * @return
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.tfNombre.setText(nombre);
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Accion mostrarDialogo() {
        setVisible(true);

        return accion;
    }

    public Tenista getTenista() {

        Tenista tenista = new Tenista();
        tenista.setNombre(nombre);
        tenista.setFechaNacimiento(fechaNacimiento);

        return tenista;
    }

    /**
     * Se invoca cuando el usuario ha pulsado en Aceptar. Recoge y valida la informaci�n de las cajas de texto
     * y cierra la ventana
     */
    private void aceptar() {

        if (tfNombre.getText().equals(""))
            return;

        nombre = tfNombre.getText();
        fechaNacimiento = tfFechaNacimiento.getDate();

        accion = Accion.ACEPTAR;
        setVisible(false);
    }

    /**
     * Invocado cuando el usuario cancela. Simplemente cierra la ventana
     */
    private void cancelar() {
        accion = Accion.CANCELAR;
        setVisible(false);
    }

    private void inicializar() {
    }

    /**
     * Constructor. Crea la ventana
     */
    public JTenista() {
        setModal(true);
        setTitle("Tenista");
        setBounds(100, 100, 276, 176);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        tfNombre = new JTextField();
        tfNombre.setBounds(100, 22, 138, 20);
        contentPanel.add(tfNombre);
        tfNombre.setColumns(10);

        lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel.setBounds(10, 25, 46, 14);
        contentPanel.add(lblNewLabel);

        lblNewLabel_2 = new JLabel("Fecha Nacimiento");
        lblNewLabel_2.setBounds(10, 53, 89, 14);
        contentPanel.add(lblNewLabel_2);
        contentPanel.add(getTfFechaNacimiento());
        inicializar();
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        aceptar();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cancelar();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
    public JDateChooser getTfFechaNacimiento() {
        if (tfFechaNacimiento == null) {
            tfFechaNacimiento = new JDateChooser();
            tfFechaNacimiento.setBounds(100, 53, 95, 20);
        }
        return tfFechaNacimiento;
    }
}
