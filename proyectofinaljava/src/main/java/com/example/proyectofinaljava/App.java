package com.example.proyectofinaljava;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        int posj_y=1;
        int posj_x=1;

        int posf_y=1, posf_x=14, posi_x, posi_y, i, j;

        int mapa1[][] = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,0,0,0,0,0,1,0,1,0,1},
            {1,1,1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,1,0,0,0,1,0,1},
            {1,0,1,1,1,1,1,0,1,1,1,1,1,0,1},
            {1,0,1,0,0,0,1,0,0,0,0,0,1,0,1},
            {1,0,1,0,1,0,1,1,1,1,1,0,1,0,1},
            {1,0,0,0,1,0,0,0,0,1,0,0,1,0,1},
            {1,1,1,0,1,1,1,1,0,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,1,1,1,1,1,1,1,1,0,1},
            {1,0,1,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,0,1,0,1,1,1,1,1,1,1,0,1,0,1},
            {1,0,0,0,1,0,0,0,0,0,1,0,0,0,1},
            {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
        int mapa2[][] = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,0,1,0,0,1,0,0,1,0,0,1},
            {1,0,1,0,1,1,0,1,1,0,1,1,0,1,1},
            {1,0,0,0,0,0,0,1,0,0,0,1,0,0,1},
            {1,1,1,1,1,0,1,1,1,1,0,1,1,0,1},
            {1,0,0,0,1,0,0,0,0,1,0,0,0,0,1},
            {1,0,1,0,1,1,1,1,0,1,1,1,0,1,1},
            {1,0,1,0,0,0,0,1,0,0,0,1,0,0,0},
            {1,0,1,1,1,1,0,1,1,1,0,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,0,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,1,0,0,0,1,0,0,1},
            {1,0,1,1,1,1,0,1,1,1,0,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}


        };
        showMap(mapa1);

    }


    public static void showMap(int M[][]){
        int i,j;
        String mapa = "";
        for(i=0; i<15; i++){
            for(j=0; j<15; j++){
                mapa += M[i][j] + " ";
            }
            mapa += "\n";
        }
        JOptionPane.showMessageDialog(null, mapa);

    }
    

     public static void move_left(int posj_y, int posj_x, int posf_y, int posf_x, int map[][]) {

        if (map[posj_x-1][posj_y] != 1) {
            JOptionPane.showMessageDialog(null, "el jugador se movio arriba");
            map[posj_x][posj_y] = 0;
            map[posj_x-1][posj_y] = 9;
            posj_y -= 1;

            
            win(posj_y, posj_x, posf_y, posf_x, map);

        
        } else {
            JOptionPane.showMessageDialog(null, "no se puede es un muro intente otra vez");
        }

    }

    public static void move_rigth(int posj_y, int posj_x, int posf_y, int posf_x, int map[][]) {

        if (map[posj_x+1][posj_y] != 1) {
            JOptionPane.showMessageDialog(null, "el jugador se movio arriba");
            map[posj_x][posj_y] = 0;
            map[posj_x+1][posj_y] = 9;
            posj_y += 1;
            
            win(posj_y, posj_x, posf_y, posf_x, map);
        
        } else {
            JOptionPane.showMessageDialog(null, "no se puede es un muro intente otra vez");
        }

    }


    public static void move_up(int posj_y, int posj_x, int posf_y, int posf_x, int map[][]) {

        if (map[posj_x][posj_y + 1] != 1) {
            JOptionPane.showMessageDialog(null, "el jugador se movio arriba");
            map[posj_x][posj_y] = 0;
            map[posj_x][posj_y + 1] = 9;
            posj_y += 1;
            
            win(posj_y, posj_x, posf_y, posf_x, map);
        
        } else {
            JOptionPane.showMessageDialog(null, "no se puede es un muro intente otra vez");
        }

    }

    public static void move_down(int posj_y, int posj_x, int posf_y, int posf_x, int map[][]) {

        if (map[posj_x][posj_y - 1] != 1) {
            JOptionPane.showMessageDialog(null, "el jugador se movio arriba");
            map[posj_x][posj_y] = 0;
            map[posj_x][posj_y - 1] = 9;
            posj_y -= 1;
            
            win(posj_y, posj_x, posf_y, posf_x, map);
        
        } else {
            JOptionPane.showMessageDialog(null, "no se puede es un muro intente otra vez");
        }

    }


    public static void win(int posj_y, int posj_x, int posf_y, int posf_x, int map[][]) {
        if (posj_y == posf_y && posj_x == posf_x) {
            JOptionPane.showMessageDialog(null, "Ganaste");
        }
    }


}
