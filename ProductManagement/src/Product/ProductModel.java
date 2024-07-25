
package Product;

import java.io.Serializable;

public class ProductModel implements Serializable{
    int id;
    String name;
    int qty = 0;
    double price;

    public ProductModel(int id, String name, int qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public int getQty(){
        return qty;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
