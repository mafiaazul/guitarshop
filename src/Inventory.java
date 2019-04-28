import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {

    private ArrayList guitars;

    public Inventory() {
        guitars = new ArrayList();
    }

    public void addGuitar (String serialNumber, double price, GuitarSpec guitarSpec) {
        Guitar guitar = new Guitar(serialNumber, price, guitarSpec);
    
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar)i.next();
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public ArrayList search(GuitarSpec searchSpec) {
        ArrayList matchingGuitars = new ArrayList();
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar)i.next();
            if (guitar.getSpec().matches(searchSpec))
                matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }
}