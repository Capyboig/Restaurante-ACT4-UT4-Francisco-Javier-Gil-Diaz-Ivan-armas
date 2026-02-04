package model;
import model.enums.Estado_del_pedido;


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

        //Inicie 2 variables nuevas que necesito para mi metodo, las inicio yo por que son 2 tonterias.
    Estado_del_pedido estadoDelPedido;
    Estado_del_pedido estadoDelPedidoNuevo;


    //Quite aqui los arrays del constructor ya que no necesitamos traer arrays desde la APP, los inicializamos aqui y ya.


    public Pedido(String plato, double precio, int cantidad, Estado_del_pedido estadoDelPedido) {
        this.contadorPlatos = 0;
        this.id_pedido = contadorPlatos++;
        this.plato = plato;
        this.precio = precio;
        this.cantidad = cantidad;
        this.estadoDelPedido = estadoDelPedido;

    }

    public Pedido(Estado_del_pedido estadoDelPedidoNuevo) {
        this.estadoDelPedidoNuevo = estadoDelPedidoNuevo;

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



    public void mostrarResumen() {
        for (int i = 0; i < contadorPlatos; i++) {
            String nombre = listaPlato[i];
            int cantidadResumen = listaCantidad[i];
            double precioUnidad = listaPrecio[i];
            double subTotal = cantidadResumen * precioUnidad;


            System.out.println("############################################################");
            System.out.println("                    RESUMEN PEDIDO");
            System.out.println(" Articulo: " + (i + 1) + ":" + nombre); // Esto de +1 es solo decorativo para que el arituclo no ponga Articulo: 0, si no Articulo: 1
            System.out.println(" Cantidad: " + cantidadResumen + " Precio unitario: " + precioUnidad);
            System.out.println(" SubTotal: " + subTotal + "€");
            System.out.println("Total del pedido: " + calculoTotal() + "€");
            System.out.println("############################################################");

        }
    }


        /*
        Este funciona basicamente inicializando 2 variables nuevas y 2 constructores, 1 constructor se usa para el metodo de cambiarEstado
         */
    public void cambiarEstado(Estado_del_pedido estadoDelPedidoNuevo) {
        if (this.estadoDelPedido == Estado_del_pedido.Listo_para_entregar && this.estadoDelPedidoNuevo == Estado_del_pedido.En_preparacion) {
            System.out.println("[ERROR] No puedes pasar de un estado listo para entregar a un en preparacion.");
        } else if (this.estadoDelPedido == Estado_del_pedido.Entregado){
            System.out.println("[ERROR] El pedido ya fue entregado, no puede cambiar de estado");
        } else {
            this.estadoDelPedido = estadoDelPedidoNuevo;
            System.out.println("[EXITO] Estado actualizado a " + this.estadoDelPedido);
        }
    }
}