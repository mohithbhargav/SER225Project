package Level;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<String> items; // Stores the items by their names or IDs
    private int limit; // The maximum number of items the inventory can hold

    public Inventory(int limit) {
        this.items = new ArrayList<>();
        this.limit = limit;
    }

    // Adds an item to the inventory if there is space
    public boolean addItem(String item) {
        if (items.size() < limit) {
            items.add(item);
            return true; // Item successfully added
        }
        return false; // Inventory is full
    }

    // Removes an item from the inventory
    public boolean removeItem(String item) {
        return items.remove(item);
    }

    // Checks if the inventory contains a specific item
    public boolean hasItem(String item) {
        return items.contains(item);
    }

    // Gets a list of all items in the inventory
    public List<String> getItems() {
        return items;
    }

    // Returns the current number of items in the inventory
    public int getItemCount() {
        return items.size();
    }

    // Draws the inventory on the screen
    public void drawInventory(/* parameters for drawing, like Graphics object */) {

        
    }
}
