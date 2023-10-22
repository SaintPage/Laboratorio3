//clase hija de producto con sus atributos respectivos
public class Bebida extends Producto {
    //Atributos:
    private int mililitros;
    private String tipo;

    //Metodos

    public int getMililitros() {
        return mililitros;
    }

    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
