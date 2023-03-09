import java.text.DecimalFormat;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        DecimalFormat dformat = new DecimalFormat("#.##");
        Helado helado = new HeladoSuave();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Estas comprando un helado suave ($30)");
        while (true) {
            System.out.println("Deseas agregarle algo?");
            System.out.println("[1] Cobertura (+$20)");
            System.out.println("[2] Granola (+$10");
            System.out.println("[3] Topping (+$20)");
            System.out.println("[4] Mermelada (+$10");
            System.out.println("[5] Galleta (+$15");
            System.out.println("[6] Ver orden y total");
            System.out.println("[7] Salir");

            System.out.print(">");
            int respuesta = scanner.nextInt();

            if (respuesta == 7) {
                break;
            }

            switch (respuesta) {
                case 1:
                    helado = new Cobertura(helado);
                    System.out.println("Se agrego Cobertura");
                    break;
                case 2:
                    helado = new Granola(helado);
                    System.out.println("Se agrego Granola");
                    break;
                case 3:
                    helado = new Topping(helado);
                    System.out.println("Se agrego Topping");
                    break;
                case 4:
                    helado = new Mermelada(helado);
                    System.out.println("Se agrego Mermelada");
                    break;
                case 5:
                    helado = new Galleta(helado);
                    System.out.println("Se agrego Galleta");
                    break;
                case 6:
                    System.out.println("La orden de tu helado es: " + helado.getDesc());
                    System.out.println("Precio total: $" + dformat.format(helado.getPrice()));
                    break;
                default:
                    System.out.println("Favor de escoger un opcion valida");

            }
        }

    }
}
