package BoxProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Box {
    public int maxLength;
    public String name;
    public ArrayList<Order> list = new ArrayList<>();
    public Scanner scanner;

    public Box() { 
        try {
            scanner =  new Scanner(new File("Orders.txt"));
            maxLength = scanner.nextInt();
            scanner.close();
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        }
    }

    public Box fillBox(OrderContainer oc) {
        Box b = new Box();
        Iterator<Order> itr = oc.OrderList.iterator();
        while (itr.hasNext()) {
            Order o = itr.next();
            if (o.getLength() + sumAll(b.list) > maxLength) {
                continue;
            }
            else if (o.getLength() > maxLength) {
                continue;
            }
            else {
                b.list.add(o);
                itr.remove();
            }
        }
        return b;
    }

    public static int sumAll(ArrayList<Order> list) {
        int sum = 0;
        for (Order o : list) {
            sum += o.getLength();
        }
        return sum; 
    }

    public String toString() {
        String msg = "";
        
        for (Order o : this.list) {
            msg += String.format("%d, ",o.getLength());
        }
        return msg;
    }

}
