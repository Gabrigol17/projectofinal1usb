package com.example.proyectofinaljava;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import javax.swing.*;

/**
 *
 * @author sebas
 */
public class gab {
    // Mapa (1 = muro, 0 = camino)

    static int mapa[][] = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
        {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
        {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    // Posición inicial del jugador
    static int jugadorFila = 1;
    static int jugadorCol = 1;
    static int MetaFila = 14;
    static int MetaCol = 1;

    public static void main(String[] args) {
        // Colocamos el jugador en el mapa
        mapa[jugadorFila][jugadorCol] = 9;

        boolean jugando = true;
        while (jugando) {
            String mapatext = mostrarMapa();
            String movimiento = JOptionPane.showInputDialog(mapatext+ "\nCONTROLES:\n" +
                    "  W - Arriba\n" +
                    "  S - Abajo\n" +
                    "  A - Izquierda\n" +
                    "  D - Derecha\n" +
                    "  E - Salir\n\n" +
                    "Ingrese movimiento (W/A/S/D/E):");
            String opcion = (movimiento.toLowerCase());
            switch (opcion) {
                case "w":
                    mover(-1, true);
                    break;
                case "s":
                    mover(1, true);
                    break;
                case "a":
                    mover(-1, false);
                    break;
                case "d":
                    mover(1, false);
                    break;
                case "e":
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

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (mapa[i][j] == 0) {
                    texto += "      ";

                } else if (mapa[i][j] == 9) {
                    texto += "    9";
                } else if (mapa[i][j] == 3) {
                    texto += "    w";
                } else {
                    texto += "     /";

                }
            }
            texto += "\n";
        }
        return texto;
    }

    public static boolean validarMovimiento(int nuevafila, int nuevacolumna, int mapa[][]) {
        // Verificar límites del mapa
        if (nuevafila < 0) {
            return false;
        }
        if (nuevacolumna < 0) {
            return false;
        }
        if (nuevafila > 14) {
            return false;
        }
        if (nuevacolumna > 14) {
            return false;
        }

        // Verificar si la celda es un muro o obstaculo
        if (mapa[nuevafila][nuevacolumna] == 1) {
            return false;
        }

        return true;
    }

    public static void mover(int move, boolean eje) {
        int nuevafila = 0;
        int nuevacolumna = 0;
        if (eje == true) {
            nuevafila = jugadorFila + move;
            nuevacolumna = jugadorCol;
        } else {
            nuevafila = jugadorFila;
            nuevacolumna = jugadorCol + move;
        }
        boolean puedeMover = validarMovimiento(nuevafila, nuevacolumna, mapa);
        if (puedeMover == true) {
            // Actualizar posición del jugador en el mapa
            mapa[jugadorFila][jugadorCol] = 0; // Dejar camino
            mapa[nuevafila][nuevacolumna] = 9; // Nueva posición del jugador
            // Actualizar coordenadas del jugador

            jugadorFila = nuevafila;
            jugadorCol = nuevacolumna;

        }
        if (puedeMover == false) {
            JOptionPane.showMessageDialog(null, "Movimiento no válido. Hay un muro o estás fuera de los límites.");
        }
    }

    public static void movimento_INVALIDO(boolean puedeMover) {
        if (puedeMover == false) {
            JOptionPane.showMessageDialog(null, "Movimiento no válido. Hay un muro o estás fuera de los límites.");
        }

    }

    public static void win() {
        if (MetaCol == jugadorCol && MetaFila == jugadorFila) {
            JOptionPane.showMessageDialog(null, "You won");
        }
    }
}