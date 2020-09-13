package com.example.tinder.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

@Entity
@IdClass(CompositeID.class)
@Table(name = "Match", schema = "dbo", catalog = "tinder")
public class MatchEntity {
    private int id1;
    private int id2;
    private int type;

    @Basic
    @Column(name = "id1")
    @Id
    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }


    @Basic
    @Column(name = "id2")
    @Id
    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchEntity that = (MatchEntity) o;
        return id1 == that.id1 &&
                id2 == that.id2 &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id1, id2, type);
    }
}
