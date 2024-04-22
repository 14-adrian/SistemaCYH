
package Models;

/**
 *
 * @author Leoni
 */
// {"ID", "Fecha", "Camarero", "Cliente", "Estado", "Accion"};
public class Order {
    private String id;
    private String date;
    private String waiter;
    private String client;
    private String state;
    private String action;

    public Order(String id, String date, String waiter, String client, String state, String action) {
        this.id = id;
        this.date = date;
        this.waiter = waiter;
        this.client = client;
        this.state = state;
        this.action = action;
    }
    
    public String[] getList(){
        String[] _lst = {id, date, waiter,client,state,action};
        return _lst;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
