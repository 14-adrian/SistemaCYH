package Controllers;

import Forms.Caja;
import Forms.Informes;
import Forms.Pedidos;
import Models.ConexionDB;
import Models.Order;
import Models.OrderDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

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
    private Pedidos ped;
    private Informes rep;

    public OrdersController(Caja _cj) {
        this.cj = _cj;
    }

    public OrdersController(Pedidos _ped) {
        this.ped = _ped;
    }
    
    public OrdersController(Informes _rep) {
        this.rep = _rep;
    }

    public Object[][] orderList(String _cam) {
        Object[][] _lista = {
            {"ID", "Fecha", "Camarero", "Cliente", "Estado", "Accion"},};
        ArrayList<Order> arrayList = new ArrayList<Order>();
        java.sql.Connection con2 = null;
        PreparedStatement pst = null;

        try {

            con2 = cn.getConnection();
            pst = con2.prepareStatement("""
                                        SELECT o.order_id, o.order_datetime, u.user_name, c.client_name, o.order_status  
                                        FROM orders_table o 
                                        INNER JOIN users_table u ON u.user_id = o.users_table_user_id
                                        INNER JOIN clients_table c ON c.client_id = o.clients_table_client_id
                                        WHERE u.user_name LIKE '""" + _cam + "%';");
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

    public void setOrderState(String _id, String _state) {
        java.sql.Connection con2 = null;
        PreparedStatement pst = null;
        try {

            con2 = cn.getConnection();
            pst = con2.prepareStatement("""
                                        UPDATE `orders_table` 
                                        SET `order_status` = '""" + _state
                    + "' WHERE `orders_table`.`order_id` = " + _id + ";");
            pst.execute();

        } catch (Exception e) {
            //cj.error("Ha ocurrido un error con la conexion, por favor contactar al desarrolador!!");
        }
    }

    public String getOrderDetails(String _id) {
        String cadena = "";
        double total = 0.0, precio = 0.0;
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formato = new DecimalFormat("0.00", simbolos);
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
                                        WHERE o.order_id = """ + _id + ";");
            rs = pst.executeQuery();
            boolean count = true;
            while (rs.next()) {
                if (count) {
                    cadena = cadena.concat("CHICHARRONES Y MAS"
                            + "\nFecha: " + rs.getString(7)
                            + "\nID Orden: " + rs.getString(8)
                            + "\n\n-----------------------------------------------------------------------------"
                            + "\nCliente: " + rs.getString(5)
                            + "\nCamarero: " + rs.getString(6)
                            + "\n-----------------------------------------------------------------------------");
                    count = false;
                }
                precio = Double.parseDouble(rs.getString(3));
                cadena = cadena.concat(
                        
                        "\n" + rs.getString(2)
                        + "   " + rs.getString(4)
                        + "\t" + formato.format(precio)
                        
                );
                total += Double.valueOf(rs.getString(3));
            }
            cadena = cadena.concat("\n-----------------------------------------------------------------------------"
                    + "\n\t\tTotal: " + formato.format(total)
                    +"\n\n*GRACIAS POR SU VISITA*"
                );

        } catch (Exception e) {
            //cj.error("Ha ocurrido un error con la conexion, por favor contactar al desarrolador!!");
        }

        return cadena;
    }

    public DefaultTableModel getActualOrders(String _id) {
        java.sql.Connection con2 = null;
        PreparedStatement pst = null;
        DefaultTableModel model = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Hacer que todas las celdas no sean editables
                    return false;
                }
            };
        String[] datos = new String[2];

        model.addColumn("Detalles de la Orden ");
        model.addColumn("Cantidad");

        try {

            con2 = cn.getConnection();
            pst = con2.prepareStatement("""
                                        SELECT CONCAT(m.item_name,'  -  ', od.order_aditionalnotes), od.orderDetails_amount 
                                        FROM `order_details_table` od 
                                        INNER JOIN menu_table m ON m.item_id = od.menu_table_item_id 
                                        WHERE od.orders_table_order_id = """ + _id + ";");
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                model.addRow(datos);
            }
        } catch (Exception e) {
            //cj.error("Ha ocurrido un error con la conexion, por favor contactar al desarrolador!!");
        }
        return model;
    }
    
    public String[] getActualCam(String _id) {
        java.sql.Connection con2 = null;
        PreparedStatement pst = null;
        String datos[] = new String[2];

        try {

            con2 = cn.getConnection();
            pst = con2.prepareStatement("""
                                        SELECT od.orders_table_order_id, u.user_name 
                                        FROM `order_details_table` od 
                                        INNER JOIN menu_table m ON m.item_id = od.menu_table_item_id 
                                        INNER JOIN orders_table o ON o.order_id = od.orders_table_order_id 
                                        INNER JOIN users_table u ON u.user_id = o.users_table_user_id 
                                        WHERE od.orders_table_order_id = """ + _id + ";");
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
            }
        } catch (Exception e) {
            //cj.error("Ha ocurrido un error con la conexion, por favor contactar al desarrolador!!");
        }
        return datos;
    }

    public int getCountActualOrders() {
        int _cant = 0;
         java.sql.Connection con2 = null;
        PreparedStatement pst = null;
        try {

            con2 = cn.getConnection();
            pst = con2.prepareStatement("""
                                        SELECT COUNT(order_id) 
                                        FROM `orders_table` 
                                        WHERE order_status = 'en preparacion';""");
            rs = pst.executeQuery();
            rs.next();
            _cant = rs.getInt(1);
        } catch (Exception e) {
            //cj.error("Ha ocurrido un error con la conexion, por favor contactar al desarrolador!!");
        }
        
        return _cant;
    }
    
    public String[] getIdActualOrders(int _cant){
        int cant =  _cant; //getCountActualOrders();
        String[] _id = new String[cant];
         java.sql.Connection con2 = null;
        PreparedStatement pst = null;
        try {

            con2 = cn.getConnection();
            pst = con2.prepareStatement("""
                                        SELECT order_id 
                                        FROM `orders_table` 
                                        WHERE order_status = 'en preparacion';""");
            rs = pst.executeQuery();
            for (int i = 0; i < cant ; i++) {
                rs.next();
                // Acceder a los datos de cada fila
                _id[i] = rs.getString(1);
                String nombre = rs.getString(1);
                // Puedes acceder a más columnas de la misma manera
                System.out.println("Nombre: " + nombre);
            }
            
        } catch (Exception e) {
            //cj.error("Ha ocurrido un error con la conexion, por favor contactar al desarrolador!!");
        }
        
        return _id;
    }

}
