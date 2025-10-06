package solucion_semaforo;

import java.util.concurrent.Semaphore;

public class SolucionSemaforo {
    public static void main(String[] args) {
        Object c1 = new Object();
        Object c2 = new Object();
        Object c3 = new Object();
        Object c4 = new Object();

        // Semáforo que permite solo a 1 coche pasar a la vez
        GestorSemaforo gestorSemaforo = new GestorSemaforo();

        CocheSemaforo cocheB = new CocheSemaforo(c2, 2, c3, 3, "Coche B", gestorSemaforo);
        CocheSemaforo cocheC = new CocheSemaforo(c3, 3, c4, 4, "Coche C", gestorSemaforo);
        CocheSemaforo cocheD = new CocheSemaforo(c4, 4, c1, 1, "Coche D", gestorSemaforo);
        CocheSemaforo cocheA = new CocheSemaforo(c1, 1, c2, 2, "Coche A", gestorSemaforo);

        cocheA.start();
        cocheB.start();
        cocheC.start();
        cocheD.start();

    }
}