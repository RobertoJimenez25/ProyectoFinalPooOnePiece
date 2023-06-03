package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaOnePiece extends JFrame {

    //Etiquetas
    private JLabel lblid;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblEstatura;
    private JLabel lblEnemigos;
    private JLabel lblURL;
    private JLabel foto;

    private JLabel Separacion;
    private JLabel lblNombreEdit;
    private JLabel lblEdadEdit;
    private JLabel lblEstaturaEdit;
    private JLabel lblEnemigosEdit;
    private JLabel lblUrlEdit;

    //Texto
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtEstatura;
    private JTextField txtEnemigos;
    private JTextField txtUrl;

    private JTextField txtnombreEdit;
    private JTextField txtedadEdit;
    private JTextField txtestaturaEdit;
    private JTextField txtenemigosEdit;
    private JTextField txturlEdit;

    //Otros
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnActualizar;
    private JButton btnBorrar;

    private JTable tblOnePiece;
    private JScrollPane scrollPane;
    private GridLayout layout;

    //Panels
    private JPanel panel1; //Formulario de captura
    private JPanel panel2; //Tabla
    private JPanel panel3; //Imagen
    private JPanel panel4; //Edicion

    public VentanaOnePiece(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);
        //Panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(146, 231, 146, 245));
        //Elementos
        lblid = new JLabel("ID: ");
        lblNombre = new JLabel("Nombre: ");
        lblEdad = new JLabel("Edad: ");
        lblEstatura = new JLabel("Estatura: ");
        lblEnemigos = new JLabel("Enemigos: ");
        lblURL = new JLabel("URL de la foto: ");
        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtNombre = new JTextField(30);
        txtEdad = new JTextField(3);
        txtEstatura = new JTextField(6);
        txtEnemigos= new JTextField(40);
        txtUrl = new JTextField(40);
        btnAgregar = new JButton("Agregar");
        //Agregar
        panel1.add(lblid);
        panel1.add(txtId);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblEdad);
        panel1.add(txtEdad);
        panel1.add(lblEstatura);
        panel1.add(txtEstatura);
        panel1.add(lblEnemigos);
        panel1.add(txtEnemigos);
        panel1.add(lblURL);
        panel1.add(txtUrl);
        panel1.add(btnAgregar);


        //Panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(174, 218, 174, 245));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblOnePiece = new JTable();
        scrollPane = new JScrollPane(tblOnePiece);
        panel2.add(scrollPane);


        //Panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(174, 218, 174, 245));
        foto = new JLabel("----");
        panel3.add(foto);


        //Panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(146, 231, 146, 245));
        //Elementos
        Separacion = new JLabel("-----------------------------------------------------------------------------------");
        lblNombreEdit = new JLabel("Escribe el nuevo Nombre: ");
        lblEdadEdit = new JLabel("Escribe la nueva Edad: ");
        lblEstaturaEdit = new JLabel("Escribe la nueva Estatura: ");
        lblEnemigosEdit = new JLabel("Escribe los nuevos Enemigos: ");
        lblUrlEdit = new JLabel("Escribe el nuevo URL: ");
        txtnombreEdit = new JTextField(30);
        txtedadEdit = new JTextField(3);
        txtestaturaEdit = new JTextField(6);
        txtenemigosEdit = new JTextField(40);
        txturlEdit = new JTextField(40);
        btnActualizar = new JButton("Actualizar");
        btnBorrar = new JButton("Borrar");
        //Agrgar
        panel4.add(btnBorrar);
        panel4.add(Separacion);
        panel4.add(lblNombreEdit);
        panel4.add(txtnombreEdit);
        panel4.add(lblEdadEdit);
        panel4.add(txtedadEdit);
        panel4.add(lblEstaturaEdit);
        panel4.add(txtestaturaEdit);
        panel4.add(lblEnemigosEdit);
        panel4.add(txtenemigosEdit);
        panel4.add(lblUrlEdit);
        panel4.add(txturlEdit);
        panel4.add(btnActualizar);



        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblid() {
        return lblid;
    }

    public void setLblid(JLabel lblid) {
        this.lblid = lblid;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblEdad() {
        return lblEdad;
    }

    public void setLblEdad(JLabel lblEdad) {
        this.lblEdad = lblEdad;
    }

    public JLabel getLblEstatura() {
        return lblEstatura;
    }

    public void setLblEstatura(JLabel lblEstatura) {
        this.lblEstatura = lblEstatura;
    }

    public JLabel getLblEnemigos() {
        return lblEnemigos;
    }

    public void setLblEnemigos(JLabel lblEnemigos) {
        this.lblEnemigos = lblEnemigos;
    }

    public JLabel getLblURL() {
        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {
        this.lblURL = lblURL;
    }

    public JLabel getFoto() {
        return foto;
    }

    public void setFoto(JLabel foto) {
        this.foto = foto;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(JTextField txtEdad) {
        this.txtEdad = txtEdad;
    }

    public JTextField getTxtEstatura() {
        return txtEstatura;
    }

    public void setTxtEstatura(JTextField txtEstatura) {
        this.txtEstatura = txtEstatura;
    }

    public JTextField getTxtEnemigos() {
        return txtEnemigos;
    }

    public void setTxtEnemigos(JTextField txtEnemigos) {
        this.txtEnemigos = txtEnemigos;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTable getTblOnePiece() {
        return tblOnePiece;
    }

    public void setTblOnePiece(JTable tblOnePiece) {
        this.tblOnePiece = tblOnePiece;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JLabel getSeparacion() {
        return Separacion;
    }

    public void setSeparacion(JLabel separacion) {
        Separacion = separacion;
    }

    public JLabel getLblNombreEdit() {
        return lblNombreEdit;
    }

    public void setLblNombreEdit(JLabel lblNombreEdit) {
        this.lblNombreEdit = lblNombreEdit;
    }

    public JLabel getLblEdadEdit() {
        return lblEdadEdit;
    }

    public void setLblEdadEdit(JLabel lblEdadEdit) {
        this.lblEdadEdit = lblEdadEdit;
    }

    public JLabel getLblEstaturaEdit() {
        return lblEstaturaEdit;
    }

    public void setLblEstaturaEdit(JLabel lblEstaturaEdit) {
        this.lblEstaturaEdit = lblEstaturaEdit;
    }

    public JLabel getLblEnemigosEdit() {
        return lblEnemigosEdit;
    }

    public void setLblEnemigosEdit(JLabel lblEnemigosEdit) {
        this.lblEnemigosEdit = lblEnemigosEdit;
    }

    public JLabel getLblUrlEdit() {
        return lblUrlEdit;
    }

    public void setLblUrlEdit(JLabel lblUrlEdit) {
        this.lblUrlEdit = lblUrlEdit;
    }

    public JTextField getTxtnombreEdit() {
        return txtnombreEdit;
    }

    public void setTxtnombreEdit(JTextField txtnombreEdit) {
        this.txtnombreEdit = txtnombreEdit;
    }

    public JTextField getTxtedadEdit() {
        return txtedadEdit;
    }

    public void setTxtedadEdit(JTextField txtedadEdit) {
        this.txtedadEdit = txtedadEdit;
    }

    public JTextField getTxtestaturaEdit() {
        return txtestaturaEdit;
    }

    public void setTxtestaturaEdit(JTextField txtestaturaEdit) {
        this.txtestaturaEdit = txtestaturaEdit;
    }

    public JTextField getTxtenemigosEdit() {
        return txtenemigosEdit;
    }

    public void setTxtenemigosEdit(JTextField txtenemigosEdit) {
        this.txtenemigosEdit = txtenemigosEdit;
    }

    public JTextField getTxturlEdit() {
        return txturlEdit;
    }

    public void setTxturlEdit(JTextField txturlEdit) {
        this.txturlEdit = txturlEdit;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }


    public void limpiar(){
        txtNombre.setText("");
        txtEdad.setText("");
        txtEstatura.setText("");
        txtEnemigos.setText("");
        txtUrl.setText("");
    }
}
