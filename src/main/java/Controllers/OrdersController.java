package Controllers;

import Forms.Caja;
import Forms.CustomPopUp.GlassPanePopup;
import Models.ConexionDB;
import Models.Order;
import Models.OrderDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Leoni
 */
public class OrdersController {

    private Order order;
    private OrderDetail orderDetail;
    private ConexionDB cn = new ConexionDB();
    private ResultSet rs;
    private Caja cj;

    public OrdersController(Caja _cj) {
        this.cj = _cj;
    }

    public Object[][] orderList() {
        Object[][] _lista = {
            {"ID", "Fecha", "Camarero", "Cliente", "Estado", "Accion"},};
        ArrayList<Order> arrayList = new ArrayList<Order>();
        java.sql.Connection con2 = null;
        PreparedStatement pst = null;

        try {

            con2 = cn.getConnection();
            pst = con2.prepareStatement("""
                                        SELECT o.order_id, o.order_datetime, u.user_name, CONCAT(c.client_name, ' ',c.client_lastName) AS Cliente, o.order_status  
                                        FROM orders_table o 
                                        INNER JOIN users_table u ON u.user_id = o.users_table_user_id
                                        INNER JOIN clients_table c ON c.client_id = o.clients_table_client_id;""");
            rs = pst.executeQuery();
            while (rs.next()) {

                arrayList.add(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), "Cobrar"));
            }

        } catch (Exception e) {
            //cj.error("Ha ocurrido un error con la conexion, por favor contactar al desarrolador!!");
        }

        _lista = agregarArray(_lista, arrayList);

        return _lista;
    }


    // Método para agregar un array a una matriz bidimensional
    public static Object[][] agregarArray(Object[][] matriz, ArrayList<Order> array) {
        Object[][] nuevaMatriz = new Object[array.size()][6];
        // Copiar los elementos existentes de la matriz original
        for (int i = 0; i < array.size(); i++) {
            nuevaMatriz[i] = array.get(i).getList();
        }
        return nuevaMatriz;
    }
    
    public void setOrderState(String _id){
        java.sql.Connection con2 = null;
        PreparedStatement pst = null;
        try {

            con2 = cn.getConnection();
            pst = con2.prepareStatement("""
                                        UPDATE `orders_table` 
                                        SET `order_status` = 'en preparacion' 
                                        WHERE `orders_table`.`order_id` = """+ _id + ";");
            pst.execute();

        } catch (Exception e) {
            //cj.error("Ha ocurrido un error con la conexion, por favor contactar al desarrolador!!");
        }
    }
    
    public String getOrderDetails(String _id){
        String cadena = "";
        java.sql.Connection con2 = null;
        PreparedStatement pst = null;
        try {

            con2 = cn.getConnection();
            pst = con2.prepareStatement("""
                                        SELECT d.orderDetails_id, d.orderDetails_amount, d.orderDetails_unitPrice, m.item_name, c.client_name, u.user_name, o.order_datetime, o.order_id 
                                        FROM order_details_table d 
                                        INNER JOIN orders_table o ON o.order_id = d.orders_table_order_id 
                                        INNER JOIN menu_table m ON m.item_id = d.menu_table_item_id
                                        INNER JOIN clients_table c ON o.clients_table_client_id = c.client_id
                                        INNER JOIN users_table u ON o.users_table_user_id = u.user_id 
                                        WHERE o.order_id = """ + _id + ";" );
            rs = pst.executeQuery();
            boolean count = true;
            while (rs.next()) {
                if(count){
                    cadena = cadena.concat("ID Orden: " + rs.getString(8) +
                        "\nID Pedido: " + rs.getString(1) +
                        "\nCliente: " + rs.getString(5) +
                        "\nCamarero: " + rs.getString(6) +
                                "\n-----------------------------------------------------------------------------");
                    count = false;
                }
                cadena = cadena.concat(
                        "\nFecha: " + rs.getString(7) +
                        "\nNombre Producto: " + rs.getString(4) +
                        "\nCantidad: " + rs.getString(2) +
                        "\nPrecio Unitario: " + rs.getString(3) +
                        "\n-----------------------------------------------------------------------------"
                        );
            }

        } catch (Exception e) {
            //cj.error("Ha ocurrido un error con la conexion, por favor contactar al desarrolador!!");
        }
        
        return cadena;
    }
}
