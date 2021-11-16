package BoxProject;

public class Order implements Comparable{
    private int length;

    public Order(int length) {
        this.length = length;
    }

    public int compareTo(Object obj) {
        Order o = (Order)obj;
        if (this.getLength() < o.getLength()) {
            return -1;
        }
        else if (this.getLength() > o.getLength()) {
            return 1;
        }
        
        return 0;
    }

    public int getLength() {
        return this.length;
    }

    public String toString() {
        return String.format("Order Length: %d", this.length);
    }

}
