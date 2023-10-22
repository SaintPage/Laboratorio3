//clase para obtener la comisión por venta también siendo hija de la clase Producto
public class Dulce extends Producto {
    //Atributos:
    private String sabor;
    private String marca;

    // Metodos:

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
