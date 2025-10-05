package solucion_prioridad;

public class CochePrioridad extends Thread {
    private Object cuadrante1, cuadrante2;
    private int numC1, numC2;
    private int prioridad;

    public CochePrioridad(Object c1, int n1, Object c2, int n2, String nombre, int prioridad) {
        this.cuadrante1 = c1;
        this.cuadrante2 = c2;
        this.numC1 = n1;
        this.numC2 = n2;
        this.setName(nombre);
        this.prioridad = prioridad;
    }

    @Override
    public void run() {
        try {
            // Los coches de menor prioridad esperan un poco para dejar pasar al de mayor prioridad
            Thread.sleep((prioridad - 1) * 1000);

            synchronized (cuadrante1) {
                System.out.println(getName() + " ocupa cuadrante " + numC1);
                Thread.sleep(200);

                System.out.println(getName() + " intenta entrar a cuadrante " + numC2);

                synchronized (cuadrante2) {
                    System.out.println(getName() + " ocupa cuadrante " + numC2 + " y cruza el cruce\n");
                    Thread.sleep(200);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
