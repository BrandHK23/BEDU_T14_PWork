public class Galleta extends HeladoDecorator{
    private final Helado helado;

    public Galleta(Helado helado) {
        this.helado = helado;
    }

    @Override
    public String getDesc() {
        return helado.getDesc() + ", Galleta (+$15)";
    }

    @Override
    public double getPrice() {
        return helado.getPrice() + 15.0;
    }
}
