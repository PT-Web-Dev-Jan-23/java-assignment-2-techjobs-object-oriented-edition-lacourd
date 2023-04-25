package org.launchcode.techjobs.oo;

import java.util.Objects;

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
    @Override
    public int hashCode() {
        return Objects.hash(id);
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
