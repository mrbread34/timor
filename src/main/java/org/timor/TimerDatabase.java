package org.timor;

import java.util.HashMap;

public class TimerDatabase {
    private HashMap<Egg, Integer> database;

    public TimerDatabase() {
        this.database = new HashMap<>();
        this.load();
    }

    public void load() {
        // average claude moment YES IM TOO LAZY
        // soft: runny yolk, set white
        this.database.put(new Egg("soft", "medium"), 330);       // 5:30
        this.database.put(new Egg("soft", "large"), 360);        // 6:00
        this.database.put(new Egg("soft", "extra large"), 390);  // 6:30
        this.database.put(new Egg("soft", "jumbo"), 420);        // 7:00

        // medium: jammy yolk
        this.database.put(new Egg("medium", "medium"), 420);       // 7:00
        this.database.put(new Egg("medium", "large"), 450);        // 7:30
        this.database.put(new Egg("medium", "extra large"), 480);  // 8:00
        this.database.put(new Egg("medium", "jumbo"), 510);        // 8:30

        // hard: fully set yolk
        this.database.put(new Egg("hard", "medium"), 570);       // 9:30
        this.database.put(new Egg("hard", "large"), 600);        // 10:00
        this.database.put(new Egg("hard", "extra large"), 660);  // 11:00
        this.database.put(new Egg("hard", "jumbo"), 720);        // 12:00
    }

    public int getTime(String style, String size) {
        return this.database.get(new Egg(style, size));
    }

    public void addEggData(String style, String size, int seconds) {
        this.database.put(new Egg(style, size), seconds);
    }
}
