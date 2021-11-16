package BoxProject;

import java.util.ArrayList;

public class BoxContainer {
    ArrayList<Box> boxes = new ArrayList<>();

    public BoxContainer(){}

    public void add(Box b) {
        boxes.add(b);
    }

    public String toString() {
        String msg = "";
        for (Box b : boxes) {
            msg += b + "\n";
        }
        return msg;
    }
}
