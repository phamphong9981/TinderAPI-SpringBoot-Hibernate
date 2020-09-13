package com.example.tinder.model;

import java.io.Serializable;
import java.util.Objects;

public class CompositeID implements Serializable {
    private int id1;
    private int id2;

    public int getId1() {
        return id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeID that = (CompositeID) o;
        return id1 == that.id1 &&
                id2 == that.id2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id1, id2);
    }
}
