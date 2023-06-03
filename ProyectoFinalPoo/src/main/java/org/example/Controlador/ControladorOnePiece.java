package org.example.Controlador;

import org.example.Modelo.ModeloTablaOnePiece;
import org.example.Modelo.OnePiece;
import org.example.vista.VentanaOnePiece;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorOnePiece extends MouseAdapter {
    private VentanaOnePiece view;
    private ModeloTablaOnePiece modelo;

    public ControladorOnePiece(VentanaOnePiece view) {
        this.view = view;
        modelo = new ModeloTablaOnePiece();
        this.view.getTblOnePiece().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblOnePiece().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Boton Cargar
        if (e.getSource() == this.view.getBtnCargar()) {

            modelo.cargarDatos();
            this.view.getTblOnePiece().setModel(modelo);
            this.view.getTblOnePiece().updateUI();
        }

        //Boton Agregar
        if (e.getSource() == this.view.getBtnAgregar()) {
            OnePiece onePiece = new OnePiece();
            onePiece.setId(0);
            onePiece.setNombre(this.view.getTxtNombre().getText());
            onePiece.setEdad(Integer.parseInt(this.view.getTxtEdad().getText()));
            onePiece.setEstatura(Integer.parseInt(this.view.getTxtEstatura().getText()));
            onePiece.setEnemigos(this.view.getTxtEnemigos().getText());
            onePiece.setUrl(this.view.getTxtUrl().getText());
            if (modelo.agregarPersonaje(onePiece)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblOnePiece().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la Base de datos. Por favor revise su conexión",
                        "Error al Insertar", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Tabla
        if (e.getSource() == this.view.getTblOnePiece()) {
            System.out.println("Evento sobre la Tabla");
            int index = this.view.getTblOnePiece().getSelectedRow();
            OnePiece tmp = modelo.getPersonajeAtIndex(index);

            try {
                this.view.getFoto().setIcon(tmp.getImagen());

            } catch (MalformedURLException mfue) {
                System.out.println(e.toString());
            }

        }

        //Boton Actualizar
        if (e.getSource() == this.view.getBtnActualizar()) {

            String nombre = this.view.getTxtnombreEdit().getText();
            String edad = this.view.getTxtedadEdit().getText();
            String estatura = this.view.getLblEstaturaEdit().getText();
            String enemigos = this.view.getTxtenemigosEdit().getText();
            String url = this.view.getTxturlEdit().getText();

            if (nombre.isEmpty() || edad.isEmpty() || estatura.isEmpty() || enemigos.isEmpty() || url.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int row = this.view.getTblOnePiece().getSelectedRow();
            int index = Integer.parseInt(String.valueOf(this.modelo.getValueAt(row, 0)));

            OnePiece onePiece = new OnePiece();

            onePiece.setId(index);
            onePiece.setNombre(this.view.getTxtnombreEdit().getText());
            onePiece.setEdad(Integer.parseInt(this.view.getTxtedadEdit().getText()));
            onePiece.setEstatura(Integer.parseInt(this.view.getTxtestaturaEdit().getText()));
            onePiece.setEnemigos(this.view.getTxtenemigosEdit().getText());
            onePiece.setUrl(this.view.getTxturlEdit().getText());

            if (modelo.actualizarDatos(onePiece)) {
                JOptionPane.showMessageDialog(view, "Se modifico correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblOnePiece().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "Se modifico correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblOnePiece().updateUI();
            }
        }

            //Boton Borrar
            if (e.getSource() == this.view.getBtnBorrar()) {

                int newRow = this.view.getTblOnePiece().getSelectedRow();
                String newindex = String.valueOf(this.modelo.getValueAt(newRow, 0));
                int respuesta = JOptionPane.showConfirmDialog(view, "¿Estas seguro de borrar los datos del personaje?", "Alerta", JOptionPane.INFORMATION_MESSAGE);


                if (respuesta == JOptionPane.YES_NO_OPTION) {
                    modelo.borrarPer(newindex);
                    JOptionPane.showMessageDialog(view, "Se elimino correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo eliminar", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
                }

                modelo.cargarDatos();
                this.view.getTblOnePiece().setModel(modelo);
                this.view.getTblOnePiece().updateUI();

            }
            this.view.limpiar();
        }

    }
