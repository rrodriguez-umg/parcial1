import java.util.Scanner;

public class parcial1E1{

    static double[] temperaturas = new double[7];
    static boolean datosIngresados = false;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarTemperaturas();
                    break;
                case 2:
                    if (datosIngresados) {
                        mostrarTemperaturas();
                    } else {
                        System.out.println("Debe ingresar primero las temperaturas.");
                    }
                    break;
                case 3:
                    if (datosIngresados) {
                        double maxima = obtenerMaxima(temperaturas);
                        int indiceMax = obtenerIndiceMaxima(temperaturas);
                        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
                        mostrarMaxima(maxima);
                        mostrarMaxima(maxima, dias[indiceMax]);
                    } else {
                        System.out.println("Debe ingresar primero las temperaturas.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                case 5:
                    if (datosIngresados) {
                        double suma = sumaRecursiva(temperaturas, 0);
                        System.out.println("La suma total de las temperaturas es: " + suma);
                    } else {
                        System.out.println("Debe ingresar primero las temperaturas.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Ingresar temperaturas");
        System.out.println("2. Mostrar todas las temperaturas");
        System.out.println("3. Mostrar temperatura máxima");
        System.out.println("4. Salir");
        System.out.println("5. Sumar todas las temperaturas ");
        System.out.print("Seleccione una opción: ");
    }

    public static void ingresarTemperaturas() {
        System.out.println("Ingrese las temperaturas máximas de los 7 días:");
        for (int i = 0; i < 7; i++) {
            System.out.print("Día " + (i + 1) + ": ");
            temperaturas[i] = scanner.nextDouble();
        }
        datosIngresados = true;
    }

    public static void mostrarTemperaturas() {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        System.out.println("\nTemperaturas registradas:");
        for (int i = 0; i < 7; i++) {
            System.out.println(dias[i] + ": " + temperaturas[i] + "°C");
        }
    }

    public static double obtenerMaxima(double[] arreglo) {
        double max = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > max) {
                max = arreglo[i];
            }
        }
        return max;
    }

    public static int obtenerIndiceMaxima(double[] arreglo) {
        int indice = 0;
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > arreglo[indice]) {
                indice = i;
            }
        }
        return indice;
    }

    public static void mostrarMaxima(double temperatura) {
        System.out.println("Temperatura máxima registrada: " + temperatura + "°C");
    }

    public static void mostrarMaxima(double temperatura, String dia) {
        System.out.println("Temperatura máxima registrada fue de " + temperatura + "°C el día " + dia);
    }

    public static double sumaRecursiva(double[] arreglo, int indice) {
        if (indice >= arreglo.length) {
            return 0;
        } else {
            return arreglo[indice] + sumaRecursiva(arreglo, indice + 1);
        }
    }
}

