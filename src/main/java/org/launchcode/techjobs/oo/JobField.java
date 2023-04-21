package org.launchcode.techjobs.oo;

public abstract class JobField {
    int id;
    static int nextId;
    String value;
    JobField() {
        id = nextId;
        nextId++;
    }
    JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }
}
