package org.launchcode.cheesemvc.models;

import java.util.HashMap;

public class Cheese {
    public static HashMap<String, Cheese> cheeses;
    private String name;
    private String description;

    public Cheese(String aName, String aDescription) {
        this.name = aName;
        this.description = aDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }
}
