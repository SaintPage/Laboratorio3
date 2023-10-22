/* Angel de Jesús Mérida Jiménez Carné: 23661
Programa que se encarga de cargar los productos de una tienda con el fin de mostrar las 4 opciones pricipales
 utilizando arraylist, y csv.
 */


import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import com.opencsv.CSVReader;

//Para compilar: javac -cp ".;./lib/commons-lang3-3.13.0.jar;./lib/opencsv-5.8.jar" Main.java Bebida.java Producto.java Dulce.java Snack.java
// Para ejecutar el programa: java -cp ".;./lib/opencsv-5.8.jar;./lib/commons-lang3-3.13.0.jar" Main

public class Main {
    public static void main(String[] args){
        boolean salir = false;

        //Creamos arrayList
        ArrayList<Producto> productos = new ArrayList<Producto>();
        
        try{
            productos.clear();
            //Leemos el archivo csv
            CSVReader csvReader = new CSVReader(new FileReader("./files/productos.csv"));
            int count = 0;
            String[] fila = null;
            while( (fila = csvReader.readNext()) !=null){
                if (count == 0){
                    count++;
                    continue;
                }

                //Validamos la categoria
                String categoria = fila[6];
                Producto aux;

                //Agregamos cada atributo al csv
                if(categoria.equals("Bebida")){
                    aux = new Bebida();
                    ((Bebida)aux).setMililitros(Integer.parseInt(fila[7]));
                    ((Bebida)aux).setTipo(fila[8]);
                }
                else if(categoria.equals("Snack") ){
                    aux = new Snack();
                    ((Snack)aux).setGramos(Integer.parseInt(fila[9]));
                    ((Snack)aux).setSabor(fila[10]);
                    ((Snack)aux).setTamanio(fila[11]);
                }
                else {
                    aux = new Dulce();
                    ((Dulce)aux).setSabor(fila[12]);
                    ((Dulce)aux).setMarca(fila[13]);
                }
                
                //Agregamos los atributos de los productos
                aux.setId(Integer.parseInt(fila[0]));
                aux.setNombre(fila[1]);
                aux.setCantidadDisponible(Integer.parseInt(fila[2]));
                aux.setCantidadVendidios(Integer.parseInt(fila[3]));
                aux.setEstado(Boolean.parseBoolean(fila[4]));
                aux.setPrecio(Double.parseDouble(fila[5]));
                aux.setCategoria(fila[6]);
                
                productos.add(aux);
            }
            System.out.println("Archivos correctamente cargados");
        
        }
        catch(Exception e){ 
            System.out.println("Error");
            e.printStackTrace();
        }
        
        while (!salir){
            mostrarMenu();
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option){
                //Opción 1 para buscar un producto por medio del id.
                case 1:
                    //mensaje
                    System.out.println("Ingrese el ID del producto");
                    //El usuario escribe el id del prducto
                    int id = sc.nextInt();
                    System.out.println("El producto es: ");
                    //iteramos para imprimir el id buscado
                    for(int i=0; i<productos.size(); i++){
                        if(id == productos.get(i).getId()){
                            System.out.println(productos.get(i));
                        }
                    }
                    break;

                //Opción 2 para istar los productos de una categoría
                case 2:
                    Scanner scc = new Scanner(System.in);
                    System.out.println("Ingrese la categoria que quiere listar");
                    //Pedimos la categoría que desea listar
                    String categoria = scc.nextLine();
                    //Mostramos los productos
                    System.out.println("Los productos son:");
                    //Iteramos las categorias
                    for(int i=0; i<productos.size(); i++){
                        if(categoria.equals(productos.get(i).getCategoria())){
                            System.out.println(productos.get(i));
                        }
                    }
                    break;
                
                // Opción 3 mostrar las ventas totales y comisiones hechas
                case 3:
                    //creamos dos variables respectivas
                    double ventas = 0;
                    double comision = 0;
                    //iteramos
                    for(int i=0; i<productos.size(); i++){
                        //acorto codigo 
                        Producto productoAux = productos.get(i);
                        //le sumamos la variable ventas el de precio del producto por la cantidad de productos vendidos
                        ventas = ventas+ productoAux.getPrecio()* productoAux.getCantidadVendidios();
                        //si es dulce agregamos la comisión con el 20%
                        if(productoAux.getCategoria().equals("Dulce")){
                            comision = comision+ productoAux.getPrecio()* productoAux.getCantidadVendidios()*0.2;
                        }
                    }
                    //mostramos en patntalla las ventas y la comisión
                    System.out.println("Las ventas son: Q"+ ventas);
                    System.out.println("La comision total es: Q"+ comision);
                    break;
                case 4:
                    ArrayList<Producto> bebidas = new ArrayList<Producto>();
                    ArrayList<Producto> snacks = new ArrayList<Producto>();
                    ArrayList<Producto> dulces = new ArrayList<Producto>();
                    //Creamos variables resptivas
                    int totalBebidas = 0;
                    int totalSnacks = 0;
                    int totalDulces = 0;
                    double ventas2 = 0;
                    double comision2 = 0;
                    
                    //iteramos para obtener el total de bebidas/snacks/dulces y su cantidad disponible
                    for(int i=0; i<productos.size(); i++){
                        Producto productoAux = productos.get(i);
                        if(productoAux.getCategoria().equals("Bebida")){
                            totalBebidas = totalBebidas+ productoAux.getCantidadDisponible();
                            bebidas.add(productoAux);
                        }
                        else if(productoAux.getCategoria().equals("Snack")){
                            totalSnacks = totalSnacks+ productoAux.getCantidadDisponible();
                            snacks.add(productoAux);
                        }
                        else {
                            dulces.add(productoAux);
                            totalDulces = totalDulces+productoAux.getCantidadDisponible();
                            comision2 = comision2+ productoAux.getPrecio()*productoAux.getCantidadVendidios()*0.2;
                        }
                        ventas2 = ventas2+ productoAux.getCantidadVendidios()*productoAux.getPrecio();
                    }
                    //Mostar el listado de categorias con sus productos
                    System.out.println("1. Listado de categorias con el total de productos");
                    System.out.println("    a. Bebidas-"+totalBebidas);
                    System.out.println("    b. Snacks-"+totalSnacks);
                    System.out.println("    c. Dulces-"+totalSnacks);

                    //Mostar listado productos por categoria
                    System.out.println("2. Listado de productos por categoria");
                    for(int i=0; i<bebidas.size(); i++){
                        Producto bebidaAux = bebidas.get(i);
                        if(bebidaAux.getCategoria().equals("Bebida")){
                            System.out.println("   "+bebidaAux);
                        }
                    }
                    for(int i=0; i<snacks.size(); i++){
                        Producto snackAux = snacks.get(i);
                        if(snackAux.getCategoria().equals("Snack")){
                            System.out.println("   "+snackAux);
                        }
                    }
                    for(int i=0; i<dulces.size(); i++){
                        Producto dulceAux = dulces.get(i);
                        if(dulceAux.getCategoria().equals("Dulce")){
                            System.out.println("   "+dulceAux);
                        }
                    }

                    //Mostrar total de ventas
                    System.out.println("3. Total de ventas:");
                    System.out.println("    a. Ventas totales Q"+ventas2);
                    System.out.println("    b. Porcentaje por categoria dulces Q"+comision2);
                    

                    break;
                case 5:
                    sc.close();
                    salir = true;
                    break;
                default:
                System.out.println("Esa opcion no existe");
            }
            System.out.println("-------------");
        }
    }
    //opciones del menú
    public static void mostrarMenu(){
        System.out.println("Menu");
        System.out.println("Elija una opcion");
        System.out.println("1. Buscar un producto por id");
        System.out.println("2. Listar los productos de una categoria");
        System.out.println("3. Mostrar las ventas totales");
        System.out.println("4. Mostrar informe");
        System.out.println("5. Salir");
    }
    
}
