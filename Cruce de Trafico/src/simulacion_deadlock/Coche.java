package simulacion_deadlock;

import java.io.IOException;

public class Coche extends Thread {
    private Object cuadrante1;
    private Object cuadrante2;
    private int numC1;
    private int numC2;

    public Coche(Object c1, int n1, Object c2, int n2, String nombre) {
        this.cuadrante1 = c1;
        this.cuadrante2 = c2;
        this.numC1 = n1;
        this.numC2 = n2;
        this.setName(nombre);
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (cuadrante1) {
                    System.out.println(getName() + " ocupa cuadrante " + numC1);
                    Thread.sleep(500);


                    // Aviso antes de intentar tomar el segundo cuadrante
                    System.out.println(getName() + " intenta entrar a cuadrante " + numC2);

                    synchronized (cuadrante2) {
                        System.out.println(getName() + " ocupa cuadrante " + numC2 + " y cruza el cruce");
                        Thread.sleep(500);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
