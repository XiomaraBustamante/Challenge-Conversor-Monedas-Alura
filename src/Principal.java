import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("******************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");

            opcion = lectura.nextInt();
            // Dentro del main, después de 'opcion = lectura.nextInt();'
            ConsultaMoneda consulta = new ConsultaMoneda();

            switch (opcion) {
                case 1:
                    convertir("USD", "ARS", consulta, lectura);
                    break;
                case 2:
                    convertir("ARS", "USD", consulta, lectura);
                    break;
                case 3:
                    convertir("USD", "BRL", consulta, lectura);
                    break;
                case 4:
                    convertir("BRL", "USD", consulta, lectura);
                    break;
                case 5:
                    convertir("USD", "COP", consulta, lectura);
                    break;
                case 6:
                    convertir("COP", "USD", consulta, lectura);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        System.out.println("Finalizando el programa. ¡Gracias!");
    }


    public static void convertir(String base, String target, ConsultaMoneda consulta, Scanner lectura) {
        System.out.println("Ingrese el valor que desea convertir:");
        double cantidad = lectura.nextDouble();
        Moneda moneda = consulta.buscaMoneda(base, target);
        System.out.println("El valor " + cantidad + " [" + base + "] corresponde al valor final de =>>> " +
                (cantidad * moneda.conversion_rate()) + " [" + target + "]");
    }
}