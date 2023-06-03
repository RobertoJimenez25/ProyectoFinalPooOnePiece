package org.example;
import org.example.Controlador.ControladorOnePiece;
import org.example.vista.VentanaOnePiece;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        VentanaOnePiece view = new VentanaOnePiece("Proyecto Final");
        ControladorOnePiece controller = new ControladorOnePiece(view);

    }
}