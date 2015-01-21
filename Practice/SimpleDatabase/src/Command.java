package src;

import java.util.HashMap;
import java.util.Map;

/**
 * Command object contains two maps. Handles all the data commands operations
 * @author Yukun
 *
 */
public class Command {
    /* First hash map: K --> variable name, V --> value */
    private Map<String, Integer> mapStrToInt = new HashMap<String, Integer>();
    /* Second hash map K --> value, V --> amount of variables that have this value */
    private Map<Integer, Integer> mapIntToInt = new HashMap<Integer, Integer>();

    /**
     * Default Constructor
     */
    public Command() {
    }

    /**
     * Get the first hash map
     * @return Return the first map
     */
    public Map<String, Integer> getMapStrToInt() {
        return mapStrToInt;
    }

    /**
     * Set the first hash map (Copy all the content)
     * @param mapStrToInt A map from previous Command object
     */
    public void setMapStrToInt(Map<String, Integer> mapStrToInt) {
        this.mapStrToInt.putAll(mapStrToInt);
    }

    /**
     * Get the second hash map
     * @return Return the second map
     */
    public Map<Integer, Integer> getMapIntToInt() {
        return mapIntToInt;
    }

    /**
     * Set the second hash map (Copy all the content)
     * @param mapIntToInt A map from previous Command object
     */
    public void setMapIntToInt(Map<Integer, Integer> mapIntToInt) {
        this.mapIntToInt.putAll(mapIntToInt);
    }

    /**
     * Add or modify a variable to/in the first hasp map, update the second hash map
     * @param name The variable name
     * @param value Its corresponding value
     */
    public void addKey(String name, int value) {
        // Update second hash map
        if (!mapStrToInt.containsKey(name)) {
            // Adding a new variable to the database
            increaseOrAddNewAmountOfIntToIntMap(value);
        } else {
            // Replace the value of an existing variable
            int originalValue = mapStrToInt.get(name);
            decreaseAmountOfIntToIntMap(originalValue);
        }

        // Update first hash map
        mapStrToInt.put(name, value);
    }

    /**
     * Get the corresponding value of the variable
     * @param name The variable name
     * @return Return its corresponding value
     */
    public int getValue(String name) {
        if (mapStrToInt.containsKey(name)) {
            return mapStrToInt.get(name);
        }
        return -1;
    }

    /**
     * Delete the variable entry in the first hash map, update the second one
     * @param name The variable name
     */
    public void removeKey(String name) {
        if (mapStrToInt.containsKey(name)) {
            int value = mapStrToInt.get(name);
            mapStrToInt.remove(name);
            decreaseAmountOfIntToIntMap(value);
        }
    }

    /**
     * Get the amount of variables that have this value in the second hash map
     * @param value A numeric value entered by user
     * @return Returns the amount of variables that have this value
     */
    public int getKeyQuantity(int value) {
        if (mapIntToInt.containsKey(value)) {
            return mapIntToInt.get(value);
        }
        return 0;
    }

    private void decreaseAmountOfIntToIntMap(int value) {
        if (mapIntToInt.containsKey(value)) {
            int amount = mapIntToInt.get(value);
            amount--;
            if (amount <= 0) {
                mapIntToInt.remove(value);
            } else {
                mapIntToInt.put(value, amount);
            }
        }
    }

    private void increaseOrAddNewAmountOfIntToIntMap(int value) {
        if (mapIntToInt.containsKey(value)) {
            int amount = mapIntToInt.get(value);
            amount++;
            mapIntToInt.put(value, amount);
        } else {
            mapIntToInt.put(value, 1);
        }
    }
}

