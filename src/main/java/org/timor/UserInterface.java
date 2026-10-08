package org.timor;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Timer timer;
    private boolean running;
    private HashMap<String, Runnable> options;
    private TimerDatabase database;
    private EggHistory history;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.options = new HashMap<>();
        this.database = new TimerDatabase();
        this.history = new EggHistory();
        this.populateFoodOptions();

        this.running = true;
    }

    public void start() {
        fancyPrint("something semifunctional i made using hashmaps...");

        while (this.running) {
            System.out.println("\nwhat food is you cookin: (type \"quit\" to quit; \"?\" for help)");
            String userInput = scanner.nextLine().toLowerCase().trim();

            if (options.containsKey(userInput)) {
                options.get(userInput).run();
            } else {
                System.out.println("what dafaq is that");
            }
        }
    }

    public void populateFoodOptions() {
        this.options.clear();
        this.options.put("egg", () -> this.eggOptions());
        this.options.put("eggs", () -> this.eggOptions());
        this.options.put("meatballs", () -> System.out.println("nah i aint coding ts son"));

        this.options.put("?", () -> this.printMenuOptions());

        this.options.put("history", () -> {
            System.out.println("History: ");
            this.history.print();
        });

        this.options.put("quit", () -> {
            System.out.println("yamete kudasai!!");
            this.running = false;
        });
    }

    public void eggOptions() {
        while (true) {
            try {
                System.out.println("\nstyle of egg?? \n[soft/medium/hard]");
                String style = scanner.nextLine().toLowerCase().trim();
                System.out.println("\nsize of egg?? \n[medium/large/extra large/jumbo]");
                String size = scanner.nextLine().toLowerCase().trim();

                System.out.println("\npress enter to start");
                scanner.nextLine();
                this.initialiseTimer(this.database.getTime(style, size));
                this.history.add(style, new Egg(style, size));
                break;

            } catch (Exception e) {
                System.out.println("input something REAL you bum");
                continue;
            }
        }

    }

    public void initialiseTimer(int seconds) {
        this.timer = new Timer(seconds);
        this.timer.decrement();
        System.out.println();
    }

    public void printMenuOptions() {
        System.out.println("available actions: ");
        for (String s : this.options.keySet()) {
            System.out.println("  - " + s);
        }
    }

    public void fancyPrint(String text) {
        char[] letters = text.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i]);
            try {
                Thread.sleep(75);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
