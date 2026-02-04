package model;

public class Pedido {

    int contadorPlatos;
    int id_pedido;
    String plato;
    double precio;
    int cantidad;
    String listaPlato[];
    double listaPrecio[];
    int listaCantidad[];
    String nombre_cliente[];

    /*
     * 1.- Contador de platos
     * 2.- id_pedido auto incremental
     * 3.- plato
     * 4.- precio
     * 5.- cantidad
     * 
     * Y esto creado en arrays:
     * listaPlato String
     * listaPrecio double
     * listaCantidad int
     * nombre-cliente String
     * 
     * Acuerdate de pre establecer el limite a 5
     * 
     * 
     * Los metodos abajo fallan por que no hay datos, acuerdate de crearlos despues.
     */

    public Pedido(String plato, double precio, int cantidad) {
        this.contadorPlatos = 0;
        this.id_pedido = contadorPlatos++;
        this.plato = plato;
        this.precio = precio;
        this.cantidad = cantidad;
        this.listaPlato = new String[5];
        this.listaPrecio = new double[5];
        this.listaCantidad = new int[5];
        this.nombre_cliente = new String[5];
    }

    public void agregarArticulo() {
        if (cantidad > 5) {
            System.out.println("[ERROR] Hay una cantidad de articulos mayor al maximo");

        } else {
            this.listaPlato[id_pedido] = plato;
            this.listaPrecio[id_pedido] = precio;
            this.listaCantidad[id_pedido] = cantidad;

            this.contadorPlatos++;
        }
    }

    public double calculoTotal() {

        // Aqui solo iniciamos el valor para guardar el total
        double precioTotal = 0;
        // Esto es solo un bucle para calcular el precio del plato por la cantidad del
        // mismo plato pedido.
        for (int i = 0; i < this.contadorPlatos; i++) {
            precioTotal += (this.listaPrecio[i] * this.listaCantidad[i]);
        }

        return precioTotal;
    }

}