package solucion_prioridad;

public class SolucionPrioridad {
    public static void main(String[] args) {
        Object c1 = new Object();
        Object c2 = new Object();
        Object c3 = new Object();
        Object c4 = new Object();

        CochePrioridad cocheA = new CochePrioridad(c1, 1, c2, 2, "Coche A", 1);
        CochePrioridad cocheB = new CochePrioridad(c2, 2, c3, 3, "Coche B", 2);
        CochePrioridad cocheC = new CochePrioridad(c3, 3, c4, 4, "Coche C", 3);
        CochePrioridad cocheD = new CochePrioridad(c4, 4, c1, 1, "Coche D", 4);

        cocheA.start();
        cocheB.start();
        cocheC.start();
        cocheD.start();

        System.out.println("Los coches han cruzado correctamente");
    }
}

