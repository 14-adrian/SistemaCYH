
package Controllers;

import static Controllers.OrdersController.agregarArray;
import Forms.Informes;
import Models.ConexionDB;
import Models.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

/**
 *
 * @author Leoni
 */
public class ReportsController  {
    private Informes inf;
    private ConexionDB cn = new ConexionDB();
    private ResultSet rs;
    
    public ReportsController(Informes _inf){
        this.inf = _inf;
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
                                        WHERE u.user_name LIKE '""" + _cam + "%' AND o.order_status = 'entregado' OR o.order_status = 'fallido' ;");
            rs = pst.executeQuery();
            while (rs.next()) {

                arrayList.add(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), "Detalles"));
            }

        } catch (Exception e) {
            //cj.error("Ha ocurrido un error con la conexion, por favor contactar al desarrolador!!");
        }

        _lista = agregarArray(_lista, arrayList);

        return _lista;
    }
    
    public String getDailyDetails() {
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
                                        SELECT DATE_FORMAT(ord.order_datetime, '%Y-%M-%d'), SUM(od.orderDetails_unitPrice*od.orderDetails_amount), ord.order_status
                                        FROM `order_details_table` od
                                        INNER JOIN orders_table ord 
                                        ON od.orders_table_order_id = ord.order_id
                                        WHERE DATE(ord.order_datetime) = CURDATE()
                                        AND ord.order_status = 'entregado'; """);
            rs = pst.executeQuery();
            boolean count = true;
            while (rs.next()) {
                if (count) {
                    cadena = cadena.concat("CHICHARRONES Y MAS"
                            + "\nFecha: " + rs.getString(1)
                            + "\nIVA:  " 
                            + "\nGravado: " 
                            + "\n-----------------------------------------------------------------------------");
                    count = false;
                }
                precio = Double.parseDouble(rs.getString(2));
                cadena = cadena.concat(
                        
                            "\nGravado: " 
                        + "\t" + formato.format(precio)
                        
                );
            }
            cadena = cadena.concat("\n-----------------------------------------------------------------------------"
                    +"\n\n*GRACIAS POR SU VISITA*"
                );

        } catch (Exception e) {
            //cj.error("Ha ocurrido un error con la conexion, por favor contactar al desarrolador!!");
        }

        return cadena;
    }
}
