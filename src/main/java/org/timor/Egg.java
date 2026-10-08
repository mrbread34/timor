package org.timor;

public class Egg {
    private String style;
    private String size;
    private final int id;
    private static int nextId = 1;

    public Egg(String style, String size) {
        this.style = style;
        this.size = size;
        this.id = this.nextId;
        this.nextId++;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (!(object instanceof Egg)) {
            return false;
        }

        Egg eggObject = (Egg) object;
        return this.style.equals(eggObject.style) && this.size.equals(eggObject.size);
    }

    @Override
    public int hashCode() {
        if (this.style == null) {
            return this.size.hashCode();
        }
        return this.size.hashCode() + this.style.hashCode();
    }


    @Override
    public String toString() {
        return "Egg #" + this.id + ": [Size: " + this.size + ", Style: " + this.style + "]";
    }





}
