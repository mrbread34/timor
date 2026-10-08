package org.timor;

public class Timer {
    private int minutes;
    private int seconds;
    private int initialSeconds;

    public Timer(int initialSeconds) {
        this.initialSeconds = initialSeconds;
        this.minutes = (int) Math.floor((double) this.initialSeconds / 60);
        this.seconds = this.initialSeconds % 60;
    }

    private void calculateTime() {
        if (this.seconds == 0 && this.minutes > 0) {
            this.minutes--;
            this.seconds = 60;
        }
        this.seconds--;
    }

    public void decrement() {
        System.out.print(this);
        while (this.minutes > 0 || this.seconds > 0) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            this.calculateTime();
            System.out.print("\r" + this);
        }
        System.out.println("\nTime's Up!");
    }

    @Override
    public String toString() {
        return this.minutes + ":" + (this.seconds >= 10 ? this.seconds : "0" + this.seconds);
    }
}
