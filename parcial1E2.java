import java.util.Scanner;

public class parcial1E2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero mayor que 1: ");
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Error: debe ingresar un número mayor o igual a 1.");
        } else {
            escaleraAscendente(n);
            escaleraDescendenteRecursiva(n - 1);
        }

        sc.close();
    }

    public static void escaleraAscendente(int n) {
        for (int i = 1; i <= n; i++) {
            imprimirLinea(i);
        }
    }

    public static void escaleraDescendente(int nivel) {
        for (int i = nivel; i >= 1; i--) {
            imprimirLinea(i);
        }
    }

    public static void escaleraDescendenteRecursiva(int nivel) {
        if (nivel < 1) return;
        imprimirLinea(nivel);
        escaleraDescendenteRecursiva(nivel - 1);
    }

    public static void imprimirLinea(int nivel) {
        for (int i = 1; i <= nivel; i++) {
            System.out.print(i + (i < nivel ? " " : ""));
        }
        System.out.println();
    }

    public static void imprimirLinea(int nivel, char simbolo) {
        for (int i = 1; i <= nivel; i++) {
            System.out.print(simbolo + (i < nivel ? " " : ""));
        }
        System.out.println();
    }
}
