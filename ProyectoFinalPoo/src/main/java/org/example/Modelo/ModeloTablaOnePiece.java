package org.example.Modelo;

import org.example.Persistencia.OnePieceDAO;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaOnePiece implements TableModel {
    public static final int COLUMNAS = 6;
    private ArrayList<OnePiece> datos;
    private OnePieceDAO opd;

    public ModeloTablaOnePiece() {
        opd = new OnePieceDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaOnePiece(ArrayList<OnePiece> datos) {
        this.datos = datos;
        opd = new OnePieceDAO();
    }


    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Edad";
            case 3:
                return "Estatura";
            case 4:
                return "Enemigos";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return Integer.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OnePiece tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getEdad();
            case 3:
                return tmp.getEstatura();
            case 4:
                return tmp.getEnemigos();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).setId();
                break;
            case 1:
                datos.get(rowIndex).setNombre( (String) aValue );
                break;
            case 2:
                datos.get(rowIndex).setEdad(Integer.parseInt((String) aValue));
                break;
            case 3:
                datos.get(rowIndex).setEstatura(Integer.parseInt((String) aValue));
                break;
            case 4:
                datos.get(rowIndex).setEnemigos( (String) aValue );
                break;
            case 5:
                datos.get(rowIndex).setUrl( (String) aValue );
                break;
            default:
                System.out.println("No se modifica nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos(){
        try {
            ArrayList<OnePiece> tirar = opd.obtenertodo();
            System.out.println(tirar);
            datos = opd.obtenertodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

    }

    public boolean agregarPersonaje(OnePiece onePiece){
        boolean resultado = false;
       try {
           if (opd.insertar(onePiece)){
                datos.add(onePiece);
                resultado = true;
           }else {
               resultado = false;
           }
       }catch (SQLException sqle){
           System.out.println(sqle.getMessage());
       }

        return resultado;
    }

    public boolean borrarPer (String index){
        boolean resultado = true;

        try {
            if (opd.delete(index)){
                System.out.println("Se elimino correctamente");
                resultado = true;
            }else {
                System.out.println("No se pudo eliminar");
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public boolean actualizarDatos(OnePiece onePiece){
        boolean resultado = false;

        try {
            if (opd.update(onePiece)){
                System.out.println("Se modifico correctamente");
                resultado = true;
            }else {
                System.out.println("No se pudo modificar");
                resultado = false;
            }
        }catch (SQLException slqe){
            System.out.println(slqe.getMessage());
        }
        return resultado;
    }


    public OnePiece getPersonajeAtIndex(int idx){
        return  datos.get(idx);
    }
}
