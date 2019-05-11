import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Inventory {

    private List inventory;

    public Inventory() {
        inventory = new LinkedList();
    }

    public void addInstrument (String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = null;

        if (spec instanceof GuitarSpec) {
            instrument = new Guitar(serialNumber, price, (GuitarSpec)spec);
        } else if (spec instanceof MandolinSpec) {
            instrument = new Mandolin(serialNumber, price, (MandolinSpec)spec);
        }
        
        inventory.add(instrument);
    }

    public Instrument get(String serialNumber) {
        for (Iterator i = inventory.iterator(); i.hasNext(); ) {
            Instrument instrument = (Instrument)i.next();
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }
    
    public ArrayList search(GuitarSpec searchSpec) {
        ArrayList matchingGuitars = new ArrayList();

        for (Iterator i = inventory.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar)i.next();
            if (guitar.getSpec().matches(searchSpec))
                matchingGuitars.add(guitar);
        }

        return matchingGuitars;
    }

    public ArrayList search(MandolinSpec searchSpec) {
        ArrayList matchingMandolins = new ArrayList();

        for (Iterator i = inventory.iterator(); i.hasNext(); ) {
            Mandolin mandolin = (Mandolin)i.next();
            if (mandolin.getSpec().matches(searchSpec))
                matchingMandolins.add(mandolin);
        }

        return matchingMandolins;
    }

}