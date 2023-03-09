public class Topping extends HeladoDecorator{
    private final Helado helado;

    public Topping(Helado helado) {
        this.helado = helado;
    }

    @Override
    public String getDesc() {
        return helado.getDesc() + ", Topping (+$20)";
    }

    public double getPrice() {
        return helado.getPrice() + 20.0;
    }
}
