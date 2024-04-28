/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impuesto_Predial;

/**
 *
 * @author ANDRES GARCES
 */
public class Impuesto {

    //Declarar Atributos
    private int Matricula;
    private String Direccion;
    private String Nombre;
    private String Apellido;
    private String Barrio;

    //Getters & Setters
    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getBarrio() {
        return Barrio;
    }

    public void setBarrio(String barrio) {
        Barrio = barrio;
    }
}
