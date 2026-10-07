package org.timor;

public class Egg {
    private String style;
    private String size;

    public Egg(String style, String size) {
        this.style = style;
        this.size = size;
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





}
