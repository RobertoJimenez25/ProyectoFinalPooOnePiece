package org.example.Persistencia;

import org.example.Modelo.OnePiece;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OnePieceDAO implements InterfazDAO {

    public OnePieceDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO onepiece(Nombre,Edad,Estatura,Enemigos,URL) VALUES(?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = Conexion.getInstance("onepieceDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1,((OnePiece)obj).getNombre());
        pstm.setInt(2,((OnePiece)obj).getEdad());
        pstm.setInt(3,((OnePiece)obj).getEstatura());
        pstm.setString(4,((OnePiece)obj).getEnemigos());
        pstm.setString(5,((OnePiece)obj).getUrl());
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE onepiece SET Nombre = ?, Edad = ?, Estatura = ?, Enemigos = ?, URL = ? WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = Conexion.getInstance("onepieceDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((OnePiece)obj).getNombre());
        pstm.setInt(2,((OnePiece)obj).getEdad());
        pstm.setInt(3,((OnePiece)obj).getEstatura());
        pstm.setString(4,((OnePiece)obj).getEnemigos());
        pstm.setString(5,((OnePiece)obj).getUrl());
        pstm.setInt(6,((OnePiece)obj).getId());
        rowCount = pstm.executeUpdate();
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM onepiece WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = Conexion.getInstance("onepieceDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1,Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenertodo() throws SQLException {
        String sql = "SELECT * FROM onepiece";
        ArrayList<OnePiece> resultado = new ArrayList<>();

        Statement stm = Conexion.getInstance("onepieceDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            resultado.add(new OnePiece(rst.getInt(1),rst.getString(2),rst.getInt(3),rst.getInt(4),rst.getString(5),rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String Id) throws SQLException {
        String sql = "SELECT * FROM onepiece WHERE id = ? ;";
        OnePiece onePiece = null;
            PreparedStatement pstm = Conexion.getInstance("onepieceDB.db").getConnection().prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(Id));
            ResultSet rst = pstm.executeQuery();
            if (rst.next()) {
                onePiece = new OnePiece(rst.getInt(1),rst.getString(2),rst.getInt(3),rst.getInt(4),rst.getString(5),rst.getString(6));
                return onePiece;
            }
        return null;
    }

}
