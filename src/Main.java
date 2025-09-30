import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        MiPila pila = new MiPila(9);

        int opcion;
        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = leerEntero(scanner);

            switch (opcion) {
                case 1: // Apilar dato
                    System.out.print("Ingresa un número para apilar: ");
                    int valor = leerEntero(scanner);
                    pila.apilar(valor);
                    pila.mostrar();
                    break;

                case 2: // Desapilar
                    int borrado = pila.desapilar();
                    if (borrado != -1) {
                        System.out.println("Dato desapilado: " + borrado);
                    }
                    pila.mostrar();
                    break;

                case 3: // Mostrar pila
                    pila.mostrar();
                    break;

                case 4: // Tamaño actual
                    System.out.println("Tamaño actual: " + pila.tamano());
                    break;

                case 5: // Espacio disponible / llena
                    int espacio = pila.espacioDisponible();
                    if (espacio == 0) {
                        System.out.println("La pila está llena. No se pueden agregar más datos.");
                    } else {
                        System.out.println("Se pueden agregar " + espacio + " datos más.");
                    }
                    break;

                case 6: // números aleatorios
                    System.out.print("¿Cuántos números aleatorios desea apilar? ");
                    int n = leerEntero(scanner);
                    int espacioLibre = pila.espacioDisponible();
                    int aInsertar = Math.min(n, espacioLibre);
                    for (int i = 0; i < aInsertar; i++) {
                        int aleatorio = (int)(Math.random() * 100);
                        pila.apilar(aleatorio);
                    }
                    if (n > aInsertar) {
                        System.out.println("Solo se apilaron " + aInsertar + " porque la pila se llenó.");
                    }
                    pila.mostrar();
                    break;

                case 7: // Vaciar pila
                    pila.vaciar();
                    System.out.println("Pila vaciada.");
                    pila.mostrar();
                    break;

                case 8: // Demo con java.util.Stack
                    demoStacks();
                    break;

                case 0: // Salir
                    System.out.println("¡asta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("===== MENÚ PILA =====");
        System.out.println("1. Apilar un dato");
        System.out.println("2. Desapilar un dato");
        System.out.println("3. Mostrar pila");
        System.out.println("4. Mostrar tamaño actual");
        System.out.println("5. Mostrar espacio disponible / si está llena");
        System.out.println("6. Llenar con N números aleatorios (0..99)");
        System.out.println("7. Vaciar pila");
        System.out.println("8. Crear dos pilas e invertir 7 datos en la segunda");
        System.out.println("0. Salir");
    }

    private static int leerEntero(Scanner scanner) {

        while (!scanner.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void demoStacks() {
        System.out.println("Crear dos pilas e invertir 7 datos en la segunda");
        Stack<Integer> pila1 = new Stack<>();
        Stack<Integer> pila2 = new Stack<>();


        for (int i = 1; i <= 7; i++) {
            pila1.push(i);
        }
        System.out.println("pila1 (la normal): " + pila1);


        while (!pila1.isEmpty()) {
            int x = pila1.pop();
            pila2.push(x);
        }
        System.out.println("pila2 (invertida): " + pila2);
        System.out.println("Nota: después de invertir, pila1 queda vacía.");
    }
}
