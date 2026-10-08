package org.timor;

import java.util.ArrayList;
import java.util.HashMap;

public class EggHistory {
    private HashMap<String, ArrayList<Egg>> history;

    public EggHistory() {
        this.history = new HashMap<>();
    }

    public void add(String style, Egg egg) {
        this.history.putIfAbsent(style, new ArrayList<>());
        this.history.get(style).add(egg);
    }

    public void print() {
        for (String eggType : this.history.keySet()) {
            System.out.println(eggType + ": " + this.history.get(eggType));
        }
    }
}
