//clase de snack que es hija de producto con sus atributos respectivos
public class Snack extends Producto {
    //Atributos:

    private int gramos;
    private String sabor;
    private String tamanio;

    //Metodos:
    public int getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
}
