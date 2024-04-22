
package Models;

/**
 *
 * @author Leoni
 */
public class OrderDetail {
    private String id;
    private String amount;
    private String uPrice;
    private String product;
    private String orderId;

    public OrderDetail(String id, String amount, String uPrice, String product, String orderId) {
        this.id = id;
        this.amount = amount;
        this.uPrice = uPrice;
        this.product = product;
        this.orderId = orderId;
    }
    
    public String[] getList(){
        String[] _lst = {id, amount, uPrice,product,orderId};
        return _lst;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getuPrice() {
        return uPrice;
    }

    public void setuPrice(String uPrice) {
        this.uPrice = uPrice;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    

    

    
}
