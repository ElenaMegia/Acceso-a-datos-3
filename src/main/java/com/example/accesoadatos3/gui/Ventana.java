package com.example.accesoadatos3.gui;


import com.example.accesoadatos3.base.Tenista;
import com.example.accesoadatos3.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {

    private JFrame frmCine;
    private JLabel lbEstado;
    private JMenuBar menuBar;
    private JMenu mnArchivo;
    private JMenuItem mntmNewMenuItem;
    private JToolBar toolBar;
    private JTabbedPane tabbedPane;
    private JPanel tabtenistas;
    private JPanel tabentrenadores;
    private JPanel tabtrofeos;
    private JButton btAnadir;
    private JButton btModificar;
    private JButton btEliminar;
    private JButton btGuardar;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane_1;
    private JScrollPane scrollPane_2;
    private JTable table;
    private JTable table_1;
    private JTable table_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana window = new Ventana();
                    window.frmCine.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Ventana() {
        initialize();
        inicializar();
    }

    private void inicializar() {

        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            cargarDatos();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /*
     * TODO
     */
    private void cargarDatos() {

    }

    private void alta() {

        switch (tabbedPane.getSelectedIndex()) {
            case 0:
                altaTenista();
                break;
            case 1:
                altaEntrenador();
                break;
            case 2:
                altaTrofeo();
                break;
            default:
        }
    }

    private void altaTenista() {

        JTenista jTenista = new JTenista();
        if (jTenista.mostrarDialogo() == JTenista.Accion.CANCELAR)
            return;

        Tenista tenista = jTenista.getTenista();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(tenista);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /*
     * TODO
     */
    private void altaEntrenador() {

    }

    /*
     * TODO
     */
    private void altaTrofeo() {

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmCine = new JFrame();
        frmCine.setTitle("Cine");
        frmCine.setBounds(100, 100, 580, 477);
        frmCine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCine.getContentPane().add(getLbEstado(), BorderLayout.SOUTH);
        frmCine.getContentPane().add(getToolBar(), BorderLayout.NORTH);
        frmCine.getContentPane().add(getTabbedPane(), BorderLayout.CENTER);
        frmCine.setJMenuBar(getMenuBar());
    }

    public JLabel getLbEstado() {
        if (lbEstado == null) {
            lbEstado = new JLabel("Cine ");
        }
        return lbEstado;
    }
    public JMenuBar getMenuBar() {
        if (menuBar == null) {
            menuBar = new JMenuBar();
            menuBar.add(getMnArchivo());
        }
        return menuBar;
    }
    public JMenu getMnArchivo() {
        if (mnArchivo == null) {
            mnArchivo = new JMenu("Archivo");
            mnArchivo.add(getMntmNewMenuItem());
        }
        return mnArchivo;
    }
    public JMenuItem getMntmNewMenuItem() {
        if (mntmNewMenuItem == null) {
            mntmNewMenuItem = new JMenuItem("Salir");
        }
        return mntmNewMenuItem;
    }
    public JToolBar getToolBar() {
        if (toolBar == null) {
            toolBar = new JToolBar();
            toolBar.add(getBtAnadir());
            toolBar.add(getBtModificar());
            toolBar.add(getBtEliminar());
            toolBar.add(getBtGuardar());
        }
        return toolBar;
    }
    public JTabbedPane getTabbedPane() {
        if (tabbedPane == null) {
            tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            tabbedPane.addTab("Tenistas", null, getTabTenistas(), null);
            tabbedPane.addTab("Entrenadores", null, getTabEntrenadores(), null);
            tabbedPane.addTab("Trofeos", null, getTabTrofeos(), null);
        }
        return tabbedPane;
    }
    public JPanel getTabTenistas() {
        if (tabtenistas == null) {
            tabtenistas = new JPanel();
            tabtenistas.setLayout(new BorderLayout(0, 0));
            tabtenistas.add(getScrollPane(), BorderLayout.CENTER);
        }
        return tabtenistas;
    }
    public JPanel getTabEntrenadores() {
        if (tabentrenadores == null) {
            tabentrenadores = new JPanel();
            tabentrenadores.setLayout(new BorderLayout(0, 0));
            tabentrenadores.add(getScrollPane_1(), BorderLayout.CENTER);
        }
        return tabentrenadores;
    }
    public JPanel getTabTrofeos() {
        if (tabtrofeos == null) {
            tabtrofeos = new JPanel();
            tabtrofeos.setLayout(new BorderLayout(0, 0));
            tabtrofeos.add(getScrollPane_2(), BorderLayout.CENTER);
        }
        return tabtrofeos;
    }
    public JButton getBtAnadir() {
        if (btAnadir == null) {
            btAnadir = new JButton("A�adir");
            btAnadir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    alta();
                }
            });
        }
        return btAnadir;
    }
    public JButton getBtModificar() {
        if (btModificar == null) {
            btModificar = new JButton("Modificar");
        }
        return btModificar;
    }
    public JButton getBtEliminar() {
        if (btEliminar == null) {
            btEliminar = new JButton("Eliminar");
        }
        return btEliminar;
    }
    public JButton getBtGuardar() {
        if (btGuardar == null) {
            btGuardar = new JButton("Guardar");
        }
        return btGuardar;
    }
    public JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }
    public JScrollPane getScrollPane_1() {
        if (scrollPane_1 == null) {
            scrollPane_1 = new JScrollPane();
            scrollPane_1.setViewportView(getTable_1());
        }
        return scrollPane_1;
    }
    public JScrollPane getScrollPane_2() {
        if (scrollPane_2 == null) {
            scrollPane_2 = new JScrollPane();
            scrollPane_2.setViewportView(getTable_2());
        }
        return scrollPane_2;
    }
    public JTable getTable() {
        if (table == null) {
            table = new JTable();
        }
        return table;
    }
    public JTable getTable_1() {
        if (table_1 == null) {
            table_1 = new JTable();
        }
        return table_1;
    }
    public JTable getTable_2() {
        if (table_2 == null) {
            table_2 = new JTable();
        }
        return table_2;
    }
}
