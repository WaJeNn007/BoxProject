package BoxProject;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Driver {

    static OrderContainer oc1 = new OrderContainer();
    static BoxContainer bc = new BoxContainer();

    public static void main(String args[]) {
        try {
        File file = new File("Orders.txt");
        oc1.OrderList = sortList(file);
        while (!oc1.OrderList.isEmpty()) {
            bc.add(new Box().fillBox(oc1));
        }
        File file2 = new File("Boxes.txt");
        PrintWriter writer = new PrintWriter(file2);
        writer.println(bc);
        writer.close();
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        }   

    }

    public static ArrayList<Order> sortList(File file) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                scanner.nextLine();
                Order o = new Order(scanner.nextInt());
                orders.add(o);    
            }
            scanner.close();
        } catch(FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        }
        Collections.sort(orders, Collections.reverseOrder());
        
        return orders; 
    }

    
}