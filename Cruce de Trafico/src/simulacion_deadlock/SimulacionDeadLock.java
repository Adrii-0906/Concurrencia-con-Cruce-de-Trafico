package simulacion_deadlock;

public class SimulacionDeadLock {
    public static void main(String[] args) {
        Object cuadrante1 = new Object();
        Object cuadrante2 = new Object();
        Object cuadrante3 = new Object();
        Object cuadrante4 = new Object();

        // Creamos los coches indicando también los números de cuadrante
        Coche cocheA = new Coche(cuadrante1, 1, cuadrante2, 2, "Coche A");
        Coche cocheB = new Coche(cuadrante2, 2, cuadrante3, 3, "Coche B");
        Coche cocheC = new Coche(cuadrante3, 3, cuadrante4, 4, "Coche C");
        Coche cocheD = new Coche(cuadrante4, 4, cuadrante1, 1, "Coche D");

        // Iniciamos los coches cocheA.start();
        cocheA.start();
        cocheB.start();
        cocheC.start();
        cocheD.start();

        // Esperamos 8 segundos máximo
        try {
            cocheA.join(2000);
            cocheB.join(2000);
            cocheC.join(2000);
            cocheD.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Como los coches no avanzan, damos por hecho que hay deadlock
        System.out.println("Deadlock detectado: los coches no pueden avanzar");
        System.exit(0);
    }
}
