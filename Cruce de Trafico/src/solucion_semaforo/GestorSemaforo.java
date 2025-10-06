package solucion_semaforo;

public class GestorSemaforo {
    private boolean[] cuadrantes = new boolean[4];

    public synchronized boolean puedePasar(int primerCuadrante, int segundoCuadrante) {
        // Si alguno de los cuadrantes está ocupado, no puede pasar
        return !cuadrantes[primerCuadrante - 1] && !cuadrantes[segundoCuadrante - 1];
    }

    public synchronized void entrar(int primerCuadrante, int segundoCuadrante, String nombre) {
        while (!puedePasar(primerCuadrante, segundoCuadrante)) {
            try {
                wait(); // espera hasta que se liberen
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Ocupa los cuadrantes
        cuadrantes[primerCuadrante - 1] = true;
        cuadrantes[segundoCuadrante - 1] = true;
        System.out.println(nombre + " pasa por el cruce (ocupa cuadrantes " + primerCuadrante + " y " + segundoCuadrante + ")");
    }

    public synchronized void salir(int primerCuadrante, int segundoCuadrante, String nombre) {
        // Libera los cuadrantes
        cuadrantes[primerCuadrante - 1] = false;
        cuadrantes[segundoCuadrante - 1] = false;
        System.out.println(nombre + " sale del cruce (libera cuadrantes " + primerCuadrante + " y " + segundoCuadrante + ")");
        notifyAll(); // avisa a los demás coches
    }
}
