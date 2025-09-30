public class MiPila {
    private int[] datos;
    private int tope; // -1 significa vacía

    public MiPila(int capacidad) {
        datos = new int[capacidad];
        tope = -1;
    }

    public int capacidad() {
        return datos.length;
    }

    public int tamano() {
        return tope + 1;
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == datos.length - 1;
    }

    public void apilar(int valor) {
        if (estaLlena()) {
            System.out.println("No se puede apilar: la pila está llena.");
            return;
        }
        tope++;
        datos[tope] = valor;
    }

    public int desapilar() {
        if (estaVacia()) {
            System.out.println("No se puede desapilar: la pila está vacía.");
            return -1; // valor de error simple
        }
        int valor = datos[tope];
        tope--;
        return valor;
    }

    public int espacioDisponible() {
        return capacidad() - tamano();
    }

    public void vaciar() {
        tope = -1;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Pila: (vacía)");
            return;
        }
        System.out.print("Pila (normal): ");
        for (int i = 0; i <= tope; i++) {
            System.out.print(datos[i]);
            if (i < tope) System.out.print(", ");
        }
        System.out.println();
    }
}


