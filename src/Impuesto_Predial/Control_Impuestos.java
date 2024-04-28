/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impuesto_Predial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ANDRES GARCES
 */
public class Control_Impuestos {

    //Declaro el ArrayList
    ArrayList viviendas = new ArrayList();

    //Declaro el Arreglo
    int[] numerosMatricula;

    Scanner scan = new Scanner(System.in);

    int contadorViviendas = 0;

    //Método para Añadir los datos a la Lista
    void registrarVivienda() {
        contadorViviendas++;
        System.out.println("\n****VIVIENDA " + contadorViviendas + "****\n");

        //Pedir los Datos de la Vivienda
        System.out.print("Digite el Número de Matrícula Inmobiliaria: ");
        int matricula = scan.nextInt();
        scan.nextLine();
        System.out.print("Digite la Dirección: ");
        String direccion = scan.nextLine();
        System.out.print("Digite el Nombre del Propietario: ");
        String nombre = scan.nextLine();
        System.out.print("Digite el Apellido del Propietario: ");
        String apellido = scan.nextLine();
        System.out.print("Digite el Barrio: ");
        String barrio = scan.nextLine();

        //Crear un objeto de tipo Impuesto
        Impuesto tax = new Impuesto();

        //Se le setea la información al Objeto
        tax.setMatricula(matricula);
        tax.setDireccion(direccion);
        tax.setNombre(nombre);
        tax.setApellido(apellido);
        tax.setBarrio(barrio);

        //Agregar el Objeto a la Lista
        viviendas.add(tax);

        //Actualizar el Arreglo de Números de Matrícula
        actualizarArregloMatriculas(); //Llamar al Método para actualizar los Números de Matrícula

        System.out.println("Datos de la Vivienda registrados!!");
    }

    //Método para actualizar el Arreglo de los Números de Matrícula
    void actualizarArregloMatriculas() {
        numerosMatricula = new int[viviendas.size()];
        for (int i = 0; i < viviendas.size(); i++) {
            Impuesto arregloMatriculas = (Impuesto) viviendas.get(i);
            numerosMatricula[i] = arregloMatriculas.getMatricula();
        }
    }

    //Método para Listar los Números de Matrícula
    void listarMatriculas() {
        System.out.println("Listado de los Números de Matrícula\n");
        for (int i = 0; i < numerosMatricula.length; i++) {
            System.out.print(numerosMatricula[i] + " / ");
        }
        System.out.println();
    }

    //Método para Buscar por el Número de Matrícula - Búsqueda Lineal
    void buscarPorMatriculaLineal() {
        System.out.print("Digite el Número de Matrícula de la Vivienda para Buscarla: ");
        int matriculaBuscar = scan.nextInt();

        boolean bandera = false;
        for (int i = 0; i < viviendas.size(); i++) {
            Impuesto HousingEncontrada = (Impuesto) viviendas.get(i);

            //Tomó el Número de Matrícula del Objeto y la comparo
            if (HousingEncontrada.getMatricula() == matriculaBuscar) {
                System.out.println("\n****Datos de la Vivienda Encontrada****");
                System.out.println("Dirección: " + HousingEncontrada.getDireccion());
                System.out.println("Nombre del Propietario: " + HousingEncontrada.getNombre());
                System.out.println("Apellido del Propietario: " + HousingEncontrada.getApellido());
                System.out.println("Barrio: " + HousingEncontrada.getBarrio());
                bandera = true;
            }
        }

        if (bandera == false) {
            System.out.println("La Vivienda no está registrada!!");
        }
    }

    //Método para Buscar por el Apellido - Búsqueda Lineal
    void buscarPorApellido() {
        System.out.print("Digite el Apellido del Propietario para Buscar la Vivienda: ");
        scan.nextLine();
        String apellidoBuscar = scan.nextLine();

        boolean bandera = false;
        for (int i = 0; i < viviendas.size(); i++) {
            Impuesto HousingEncontrada = (Impuesto) viviendas.get(i);

            //Tomó el Apellido del Objeto y la comparo
            if (apellidoBuscar.equals(HousingEncontrada.getApellido())) {
                System.out.println("\n****Datos de la Vivienda Encontrada****");
                System.out.println("Número de Matrícula Inmobiliaria: " + HousingEncontrada.getMatricula());
                System.out.println("Dirección: " + HousingEncontrada.getDireccion());
                System.out.println("Nombre del Propietario: " + HousingEncontrada.getNombre());
                System.out.println("Barrio: " + HousingEncontrada.getBarrio());
                bandera = true;
            }
        }

        if (bandera == false) {
            System.out.println("La Vivienda no está registrada!!");
        }
    }

    //Algoritmo de Ordenamiento por Burbuja
    void ordenarporBurbuja(int arreglo[]) {
        int n = arreglo.length;
        int aux = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                //Cambia la condición para ordenar de forma ascendente
                if (arreglo[j] > arreglo[j + 1]) {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }
        }
    }

    //Algoritmo de Ordenamiento por Insercción
    public void ordenarPorInserccion(int datos[]) {
        int insercion; //Variable temporal para contener el elemento a insertar

        //Itera a través de datos.length - 1 elementos
        for (int siguiente = 1; siguiente < datos.length; siguiente++) {

            //Almacena el valor en el elemento actual
            insercion = datos[siguiente];

            //Inicializa ubicación para colocar el elemento
            int moverElemento = siguiente;

            //Busca un lugar para colocar el elemento actual
            while (moverElemento > 0 && datos[moverElemento - 1] > insercion) {

                //Desplaza el elemento una posición a la derecha
                datos[moverElemento] = datos[moverElemento - 1];
                moverElemento--;
            } //Fin de while

            datos[moverElemento] = insercion; //Coloca el elemento insertado
            //ImprimirPasada(siguiente, moverElemento); //Imprime la pasada del algoritmo
        }
    }

    //Método para Buscar la Vivienda por el Número de Matrícula - Búsqueda Binaria
    void buscarporMatriculaBinaria() {
        System.out.print("Digite el Número de Matrícula a Buscar: ");
        int numBuscado = scan.nextInt();

        //Llamó al Método del algortimo de Búsqueda Binaria
        int datoRet = this.busquedaBinaria(numBuscado);

        if (datoRet == -1) {
            System.out.println("Numero de Matrícula no Encontrado!!");
        } else {
            for (int i = 0; i < viviendas.size(); i++) {
                Impuesto HousingEncontrada = (Impuesto) viviendas.get(i);

                //Tomó el Barrio del Objeto y la comparo
                if (HousingEncontrada.getMatricula() == numBuscado) {
                    System.out.println("Número de Matrícula Encontrado, en la Posición: " + datoRet);
                    System.out.println("\n****Datos de la Vivienda Encontrada****");
                    System.out.println("Dirección: " + HousingEncontrada.getDireccion());
                    System.out.println("Nombre del Propietario: " + HousingEncontrada.getNombre());
                    System.out.println("Apellido del Propietario: " + HousingEncontrada.getApellido());
                    System.out.println("Barrio: " + HousingEncontrada.getBarrio());
                }
            }
        }
    }

    //Algortimo de Búsqueda Binaria
    public int busquedaBinaria(int elementoBusqueda) {
        int inferior = 0; //Extremo inferior del área de búsqueda
        int superior = numerosMatricula.length - 1; //Extremo superior del área de búsqueda
        int medio = (inferior + superior + 1) / 2; //Elemento medio
        int ubicacion = -1; //Devuelve el valor; -1 si no lo encontró

        do {
            if (elementoBusqueda == numerosMatricula[medio]) {
                ubicacion = medio; //La ubicación es el elemento medio actual
            } //El elemento medio es demasiado alto
            else if (elementoBusqueda < numerosMatricula[medio]) {
                superior = medio - 1; //Elimina la mitad superior
            } else //El elemento medio es demasiado bajo
            {
                inferior = medio + 1; //Elimina la mitad inferior
            }
            medio = (inferior + superior + 1) / 2; //Recalcula el elemento medio
        } while ((inferior <= superior) && (ubicacion == -1));

        return ubicacion; //Devuelve
    }

    //Menú de Opciones
    void Menu() {
        int opc;
        do {
            System.out.println("\n****MENÚ DE OPCIONES****\n");
            System.out.println("1. Registrar los Datos de la Vivienda");
            System.out.println("2. Listar los Números de Matrícula");
            System.out.println("3. Buscar Vivienda por el Número de Matrícula - Búsqueda Lineal");
            System.out.println("4. Buscar Vivienda por el Apellido del Propietario");
            System.out.println("5. Ordenar por Burbuja los Números de Matrícula");
            System.out.println("6. Ordenar por Inserción los Números de Matrícula");
            System.out.println("7. Buscar Vivienda por el Número de Matrícula - Búsqueda Binaria");
            System.out.println("8. Salir del Programa");
            System.out.print("\nDigite una opción: ");
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    this.registrarVivienda();
                    break;
                case 2:
                    this.listarMatriculas();
                    break;
                case 3:
                    this.buscarPorMatriculaLineal();
                    break;
                case 4:
                    this.buscarPorApellido();
                    break;
                case 5:
                    this.ordenarporBurbuja(numerosMatricula);
                    System.out.println();
                    System.out.println("Números de Matrícula ordenados por Método de Burbuja");
                    break;
                case 6:
                    this.ordenarPorInserccion(numerosMatricula);
                    System.out.println();
                    System.out.println("Números de Matrícula ordenados por Método de Inserción");
                    break;
                case 7:
                    this.buscarporMatriculaBinaria();
                    break;
            }
        } while (opc != 8);
    }
}
