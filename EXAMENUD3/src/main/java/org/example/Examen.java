package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void ejercicio1() {
        Scanner entry = new Scanner(System.in);
        Random random = new Random();
        //Matriz del carton
        Integer[][] carton = new Integer[3][3];

        //Genero la cantidad aleatorias de bolas que habra y el vector que contendra las bolas
        int no_balls = random.nextInt(30)+10;
        Integer[] balls = new Integer[no_balls];

        //Asigno un valor aleatorio a cada bola dentro del vector y en caso de ser repetido, se vuelve a generar un numero hasta no ser repetido.
        int check;
        for (int i = 0; i < balls.length; i++) {
            do {
                check = random.nextInt(90) + 1;
            } while (Arrays.asList(balls).contains(check));
            balls[i] = check;
        }

        System.out.println("BIENVENIDO AL BINGO");
        System.out.println(no_balls + " bolas extraidas hasta ahora: " + Arrays.toString(balls));
        //Pido los numeros de cada fila en formato N-N-N, con el metodo .matches() en caso de que no sea el formato correcto, salta mensaje de error y te saca del programa
        System.out.println("Introduce los dato de tu carton (N-N-N)");
        for (int i = 0; i < carton.length; i++) {
            System.out.println("Fila " + (i+1));
            String row_number = entry.nextLine();
            if (!row_number.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}")) {
                System.out.println("FORMATO INCORRECTO. ERROR.");
                return;
            }
            //Con split y el separador "-" meto la fila en un vector auxiliar para despues recorrer el carton y ir metiendo cada valor.
            String[] row_numbers = row_number.split("-");
            for (int j = 0; j < carton[0].length; j++) {
                carton[i][j] = Integer.parseInt(row_numbers[j]);
            }
        }
        //Mostrar el carton introducido recorriendo la matriz
        System.out.println("DATOS DEL CARTON INTRODUCIDO");
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                System.out.print(carton[i][j] + " ");
            }
            System.out.print("\n");
        }
        //Bucle for que recorre cada celda del carton y la busca en el vector de las bolas.
        //Uso 2 variables booleanas para guardar si no encuentra la bola.
        //Una para cada linea que se reinicia a true en cada vuelta del bucle "i" y otra para el bingo total que no se reinicia.
        System.out.println();
        System.out.println("PREMIOS:");
        System.out.println();
        boolean number_matches = true;
        for (int i = 0; i < carton.length; i++) {
            boolean row_matches = true;
            for (int j = 0; j < carton[0].length; j++) {
                if (!Arrays.asList(balls).contains(carton[i][j])) {
                    row_matches = false;
                    number_matches = false;
                    break;
                }
            }
            //En caso de que ya no pueda ser un bingo, muestra las lineas que has acertado
            if (!number_matches) {
                if (row_matches) {
                    System.out.println("LINEA " + i + ": CORRECTA !!!");
                } else {
                    System.out.println("LINEA " + i + ": NO");
                }
            }

        }
        //Si todo coinicide dice bingo, si no pues no
        if (number_matches) {
            System.out.println("HAY BINGO!!!");
        } else {
            System.out.println("No hay bingo.");
        }
    }
}
