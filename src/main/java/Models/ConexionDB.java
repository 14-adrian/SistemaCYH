package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import javax.swing.JOptionPane;

public class ConexionDB {

    Connection con;
    DBController db = new DBController();

    public ConexionDB() {
        String filePath = "DBConfig.xml";
        List<String> data = db.readConfig(filePath);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://"+data.get(0)+"/"+ data.get(1), data.get(2), data.get(3));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "ERROR" + e);

        }
    }

    public Connection getConnection() {
        return con;
    }

//    public static void main(String[] args) {
//        ConexionDB cn = new ConexionDB();
//        Statement st;
//        ResultSet rs;
//        try {
//            st = cn.con.createStatement();
//            rs = st.executeQuery("select * from users_table");
//            while (rs.next()) {
//                System.out.println(rs.getInt("user_id") + " " + rs.getString("user_name") + " " + rs.getString("user_password") + "   " + rs.getString("user_role"));
//            }
//            cn.con.close();
//        } catch (Exception e) {
//            System.err.println("Error:" + e);
//        }
//
//    }
}
