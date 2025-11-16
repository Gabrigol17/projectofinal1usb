package com.example.proyectofinaljava;
import javax.swing.JOptionPane;

public class GabriLab {
    // Mapa (1 = muro, 0 = camino)
    static int mapa[][] = {
            {1,1,1,1,1},
            {1,0,0,0,1},
            {1,0,1,0,1},
            {1,0,0,0,1},
            {1,1,1,1,1}
    };

    // Posición inicial del jugador
    static int jugadorFila = 1; 
    static int jugadorCol = 1;

    public static void main(String[] args) {
        // Colocamos el jugador en el mapa
        mapa[jugadorFila][jugadorCol] = 9;

        boolean jugando = true;
        while(jugando){
        String mapatext = mostrarMapa();
        String movimiento = JOptionPane.showInputDialog(mapatext + "\n" + "1. Arriba" +
                "\n2. Abajo" +
                "\n3. Izquierda" +
                "\n4. Derecha" +
                "\n5. Salir" +
                "\nIngrese el número de la dirección a la que desea moverse:");       
        int opcion = Integer.parseInt(movimiento);
        switch (opcion) {
            case 1:
                mover_arriba();
                break;
            case 2:
                mover_abajo();
                break;
            case 3:
                mover_izquierda();
                break;
            case 4:
                mover_derecha();
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Saliendo del juego.");
                jugando = false;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                break;
        }     
        }
    }

    // Función para imprimir el mapa en JOptionPane
    public static String mostrarMapa() {
        String texto = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                texto += mapa[i][j] + " ";
            }
            texto += "\n";
        }
        return texto;
    }
    public static boolean validarMovimiento(int nuevafila, int nuevacolumna, int mapa[][]) {
        // Verificar límites del mapa
        if (nuevafila < 0) return false;
        if (nuevacolumna < 0) return false;
        if (nuevafila  > 4) return false;
        if (nuevacolumna > 4) return false;

        // Verificar si la celda es un muro o obstaculo
        if (mapa[nuevafila][nuevacolumna] == 1) return false;

        return true;
    }

    public static void mover_arriba() {
        int nuevafila = jugadorFila - 1;
        int nuevacolumna = jugadorCol;
        boolean puedeMover = validarMovimiento(nuevafila, nuevacolumna, mapa);
        if (puedeMover == true){
            // Actualizar posición del jugador en el mapa
            mapa[jugadorFila][jugadorCol] = 0; // Dejar camino
            mapa[nuevafila][nuevacolumna] = 9; // Nueva posición del jugador
            // Actualizar coordenadas del jugador

            jugadorFila = nuevafila;
            jugadorCol = nuevacolumna;

        }
        if (puedeMover == false){
            JOptionPane.showMessageDialog(null, "Movimiento no válido. Hay un muro o estás fuera de los límites.");
    }
}
    public static void mover_abajo() {
            int nuevafila = jugadorFila + 1;
            int nuevacolumna = jugadorCol;
            boolean puedeMover = validarMovimiento(nuevafila, nuevacolumna, mapa);
            if (puedeMover == true){
                // Actualizar posición del jugador en el mapa
                mapa[jugadorFila][jugadorCol] = 0; // Dejar camino
                mapa[nuevafila][nuevacolumna] = 9; // Nueva posición del jugador
                // Actualizar coordenadas del jugador

                jugadorFila = nuevafila;
                jugadorCol = nuevacolumna;

            }
            if (puedeMover == false){
                JOptionPane.showMessageDialog(null, "Movimiento no válido. Hay un muro o estás fuera de los límites.");
        }
    }

    public static void mover_izquierda() {
        int nuevafila = jugadorFila;
        int nuevacolumna = jugadorCol - 1;
        boolean puedeMover = validarMovimiento(nuevafila, nuevacolumna, mapa);
        if (puedeMover == true){
            // Actualizar posición del jugador en el mapa
            mapa[jugadorFila][jugadorCol] = 0; // Dejar camino
            mapa[nuevafila][nuevacolumna] = 9; // Nueva posición del jugador
            // Actualizar coordenadas del jugador

            jugadorFila = nuevafila;
            jugadorCol = nuevacolumna;

        }
        if (puedeMover == false){
            JOptionPane.showMessageDialog(null, "Movimiento no válido. Hay un muro o estás fuera de los límites.");
        }
    }

    public static void mover_derecha() {
        int nuevafila = jugadorFila;
        int nuevacolumna = jugadorCol + 1;
        boolean puedeMover = validarMovimiento(nuevafila, nuevacolumna, mapa);
        if (puedeMover == true){
            // Actualizar posición del jugador en el mapa
            mapa[jugadorFila][jugadorCol] = 0; // Dejar camino
            mapa[nuevafila][nuevacolumna] = 9; // Nueva posición del jugador
            // Actualizar coordenadas del jugador

            jugadorFila = nuevafila;
            jugadorCol = nuevacolumna;

        }
        if (puedeMover == false){
            JOptionPane.showMessageDialog(null, "Movimiento no válido. Hay un muro o estás fuera de los límites.");
        }
    }
}

