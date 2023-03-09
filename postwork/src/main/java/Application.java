import java.text.DecimalFormat;


public class Application {
    public static void main(String[] args) {
        DecimalFormat dformat = new DecimalFormat("#.##");
        Helado helado = new HeladoSuave();

        helado = new Cobertura(helado);
        helado = new Galleta(helado);
        helado = new Topping(helado);
        System.out.println("Desc: " + helado.getDesc());
        System.out.println("Price: " + dformat.format(helado.getPrice()));

        Helado otroHelado = new HeladoSuave();
        otroHelado = new Mermelada(otroHelado);
        otroHelado = new Granola(otroHelado);
        otroHelado = new Topping(otroHelado);
        System.out.println("Desc: " + otroHelado.getDesc());
        System.out.println("Price: " + dformat.format(otroHelado.getPrice()));

    }
}
