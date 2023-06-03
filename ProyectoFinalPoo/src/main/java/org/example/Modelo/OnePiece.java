package org.example.Modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class OnePiece {
    private int id;
    private String nombre;
    private int edad;
    private int estatura;
    private String enemigos;
    private String url;

    public OnePiece() {
    }

    public OnePiece(int id, String nombre, int edad, int estatura, String enemigos, String url) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
        this.enemigos = enemigos;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public String getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(String enemigos) {
        this.enemigos = enemigos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "OnePiece{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", estatura=" + estatura +
                ", enemigos='" + enemigos + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen()throws MalformedURLException {
        URL urlImage = new URL(this.url);
        return new ImageIcon(urlImage);
    }

}
