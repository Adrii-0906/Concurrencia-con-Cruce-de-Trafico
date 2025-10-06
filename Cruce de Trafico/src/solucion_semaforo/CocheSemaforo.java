package solucion_semaforo;


public class CocheSemaforo extends Thread {
    private Object cuadrante1, cuadrante2;
    private int numC1, numC2;
    private GestorSemaforo gestor;

    public CocheSemaforo(Object c1, int n1, Object c2, int n2, String nombre, GestorSemaforo gestor) {
        this.cuadrante1 = c1;
        this.numC1 = n1;
        this.cuadrante2 = c2;
        this.numC2 = n2;
        this.setName(nombre);
        this.gestor = gestor;
    }

    @Override
    public void run() {
        synchronized (cuadrante1) {
            synchronized (cuadrante2) {
                gestor.entrar(numC1, numC2, getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gestor.salir(numC1, numC2, getName());
            }
        }
    }

}