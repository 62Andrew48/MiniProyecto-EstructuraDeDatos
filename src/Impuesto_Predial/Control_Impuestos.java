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

    //Declaro el ArrayList para almacenar las Viviendas
    ArrayList viviendas = new ArrayList();

    //Declaro el Arreglo para almacenar los Números de Matrícula
    long[] numerosMatricula;

    //Se utiliza para leer la entrada del usuario desde la consola estándar (System.in)
    Scanner scan = new Scanner(System.in);

    int contadorViviendas = 0;

    //Case 1: Método para Añadir los datos a la Lista
    void registrarVivienda() {
        contadorViviendas++;
        System.out.println("\n****VIVIENDA " + contadorViviendas + "****\n");

        //Pedir los Datos de la Vivienda
        System.out.print("Digite el Número de Matrícula Inmobiliaria: ");
        long matricula = scan.nextLong();
        scan.nextLine();
        System.out.print("Digite la Dirección: ");
        String direccion = scan.nextLine();
        System.out.print("Digite el Nombre del Propietario: ");
        String nombre = scan.nextLine();
        System.out.print("Digite el Apellido del Propietario: ");
        String apellido = scan.nextLine();
        System.out.print("Digite el Barrio: ");
        String barrio = scan.nextLine();

        //Crear un Objeto de tipo Impuesto
        Impuesto impuesto = new Impuesto();

        //Se le setea la información al Objeto Impuesto
        impuesto.setMatricula(matricula);
        impuesto.setDireccion(direccion);
        impuesto.setNombre(nombre);
        impuesto.setApellido(apellido);
        impuesto.setBarrio(barrio);

        //Agregar el Objeto a la Lista
        viviendas.add(impuesto);

        //Actualizar el Arreglo de Números de Matrícula
        actualizarArregloMatriculas(); //Llamar al Método para actualizar los Números de Matrícula

        System.out.println("Datos de la Vivienda registrados!!");
    }

    //Método para actualizar el Arreglo de los Números de Matrícula
    void actualizarArregloMatriculas() {
        numerosMatricula = new long[viviendas.size()];
        for (int i = 0; i < viviendas.size(); i++) {
            Impuesto arregloMatriculas = (Impuesto) viviendas.get(i);
            numerosMatricula[i] = arregloMatriculas.getMatricula();
        }
    }//Relacionado con el Case 4: Listar Números de Matrícula

    //Case 2: Método para Buscar por el Número de Matrícula - Búsqueda Lineal
    void buscarPorMatriculaLineal() {
        System.out.print("Digite el Número de Matrícula de la Vivienda para Buscarla: ");
        long matriculaBuscar = scan.nextLong();

        boolean bandera = false;
        for (int i = 0; i < viviendas.size(); i++) {
            Impuesto ViviendaEncontrada = (Impuesto) viviendas.get(i);

            //Tomó el Número de Matrícula del Objeto y la comparo
            if (ViviendaEncontrada.getMatricula() == matriculaBuscar) {
                System.out.println("\n****Datos de la Vivienda Encontrada****");
                System.out.println("Dirección: " + ViviendaEncontrada.getDireccion());
                System.out.println("Nombre del Propietario: " + ViviendaEncontrada.getNombre());
                System.out.println("Apellido del Propietario: " + ViviendaEncontrada.getApellido());
                System.out.println("Barrio: " + ViviendaEncontrada.getBarrio());
                bandera = true;
            }
        }

        if (bandera == false) {
            System.out.println("La Vivienda no está registrada!!");
        }
    }

    //Case 3: Método para Buscar por el Apellido - Búsqueda Lineal
    void buscarPorApellido() {
        System.out.print("Digite el Apellido del Propietario para Buscar la Vivienda: ");
        scan.nextLine();
        String apellidoBuscar = scan.nextLine();

        boolean bandera = false;
        for (int i = 0; i < viviendas.size(); i++) {
            Impuesto ViviendaEncontrada = (Impuesto) viviendas.get(i);

            //Tomó el Apellido del Objeto y la comparo
            if (apellidoBuscar.equals(ViviendaEncontrada.getApellido())) {
                System.out.println("\n****Datos de la Vivienda Encontrada****");
                System.out.println("Número de Matrícula Inmobiliaria: " + ViviendaEncontrada.getMatricula());
                System.out.println("Dirección: " + ViviendaEncontrada.getDireccion());
                System.out.println("Nombre del Propietario: " + ViviendaEncontrada.getNombre());
                System.out.println("Barrio: " + ViviendaEncontrada.getBarrio());
                bandera = true;
            }
        }

        if (bandera == false) {
            System.out.println("La Vivienda no está registrada!!");
        }
    }

    //Case 4: Método para Listar los Números de Matrícula
    void listarMatriculas() {
        System.out.println("Listado de los Números de Matrícula\n");
        for (int i = 0; i < numerosMatricula.length; i++) {
            System.out.print(numerosMatricula[i] + " / ");
        }
        System.out.println();
    }

    //Case 5: Algoritmo de Ordenamiento por Burbuja
    void ordenarporBurbuja(long arreglo[]) {
        long n = arreglo.length;
        long aux = 0;

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

    //Case 6: Algoritmo de Ordenamiento por Inserción
    public void ordenarPorInsercion(long datos[]) {
        long insercion; //Variable temporal para contener el elemento a insertar

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

    //Case 7: Método para Buscar la Vivienda por el Número de Matrícula - Búsqueda Binaria
    void buscarporMatriculaBinaria() {
        System.out.print("Digite el Número de Matrícula a Buscar: ");
        long numBuscado = scan.nextLong();

        //Llamó al Método del algortimo de Búsqueda Binaria
        long datoRet = this.busquedaBinaria(numBuscado);

        if (datoRet == -1) {
            System.out.println("Número de Matrícula no Encontrado!!");
        } else {
            for (int i = 0; i < viviendas.size(); i++) {
                Impuesto ViviendaEncontrada = (Impuesto) viviendas.get(i);

                //Tomó el Número de Matrícula del Objeto y la comparo
                if (ViviendaEncontrada.getMatricula() == numBuscado) {
                    System.out.println("Número de Matrícula Encontrado, en la Posición: " + datoRet);
                    System.out.println("\n****Datos de la Vivienda Encontrada****");
                    System.out.println("Dirección: " + ViviendaEncontrada.getDireccion());
                    System.out.println("Nombre del Propietario: " + ViviendaEncontrada.getNombre());
                    System.out.println("Apellido del Propietario: " + ViviendaEncontrada.getApellido());
                    System.out.println("Barrio: " + ViviendaEncontrada.getBarrio());
                }
            }
        }
    }

    //Algortimo de Búsqueda Binaria
    public int busquedaBinaria(long elementoBusqueda) {
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
    void menu() {
        int opc = 0;
        do {
            System.out.println("\n****MENÚ DE OPCIONES****\n");
            System.out.println("1. Registrar los Datos de la Vivienda");
            System.out.println("2. Buscar Vivienda por el Número de Matrícula - Búsqueda Lineal");
            System.out.println("3. Buscar Vivienda por el Apellido del Propietario");
            System.out.println("4. Listar los Números de Matrícula de las Viviendas");
            System.out.println("5. Ordenar por Burbuja los Números de Matrícula");
            System.out.println("6. Ordenar por Inserción los Números de Matrícula");
            System.out.println("7. Buscar Vivienda por el Número de Matrícula - Búsqueda Binaria");
            System.out.println("8. Salir del Programa\n");
            System.out.print("Digite una opción: ");
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    this.registrarVivienda();
                    break;
                case 2:
                    this.buscarPorMatriculaLineal();
                    break;
                case 3:
                    this.buscarPorApellido();
                    break;
                case 4:
                    this.listarMatriculas();
                    break;
                case 5:
                    this.ordenarporBurbuja(numerosMatricula);
                    System.out.println();
                    System.out.println("Números de Matrícula ordenados por Método de Burbuja");
                    break;
                case 6:
                    this.ordenarPorInsercion(numerosMatricula);
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
