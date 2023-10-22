// clase padre que contiene toda la información ncesaria para empezar a programar
public class Producto {
    //Atributos
    protected int id;
    protected String nombre;
    protected int cantidadDisponible;
    protected int cantidadVendidios;
    protected boolean estado;
    protected double precio;
    protected String categoria;

    //Metodos:


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadVendidios() {
        return cantidadVendidios;
    }

    public void setCantidadVendidios(int cantidadVendidios) {
        this.cantidadVendidios = cantidadVendidios;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return "Nombre: " + this.nombre +" Precio: Q"+this.precio+" Categoría: "+this.categoria;
    }

}
