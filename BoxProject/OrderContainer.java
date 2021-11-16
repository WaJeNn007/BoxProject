package BoxProject;

import java.util.ArrayList;

public class OrderContainer {
    ArrayList<Order> OrderList;

    public OrderContainer(){}
    
    public String toString() {
        String msg = "";
        for (Order o : this.OrderList) {
            msg += String.format("%d", o.getLength());
        }
        return msg;
    }
}
