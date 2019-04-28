import java.util.ArrayList;
import java.util.Iterator;

public class FindGuitarTester {

    public static void main(String[] args) {
        // Set up Rick's guitar inventory
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor", 
                                            Type.ELETRIC, 6, Wood.ALDER, Wood.ALDER);
        ArrayList matchingGuitars = inventory.search(whatErinLikes);
        if (!matchingGuitars.isEmpty()) {
            System.out.println("Erin, you might like these guitars:");
            for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
                Guitar guitar = (Guitar)i.next();
                GuitarSpec spec = guitar.getSpec();
                System.out.println(" We have a " + 
                spec.getBuilder() + " " + spec.getModel() + " " +
                spec.getNumStrings() + "-string " +
                spec.getType() + " guitar:\n  " +
                spec.getBackWood() + " back and sides,\n  " +
                spec.getTopWood() + " top.\nYou can have it for only $" +
                guitar.getPrice() + "!\n ----");
            }
        } else {
            System.out.println("Sorry, Erin. We have nothing for you.");
        }
    }

    private static void initializeInventory(Inventory inventory) {
        //Add guitars to the inventory
        inventory.addGuitar("V1", 123.34, new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELETRIC, 6, Wood.ALDER, Wood.ALDER));
        inventory.addGuitar("V2", 134.56, new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELETRIC, 6, Wood.ALDER, Wood.ALDER));
    }
}
