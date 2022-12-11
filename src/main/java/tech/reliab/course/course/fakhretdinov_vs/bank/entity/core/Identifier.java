package tech.reliab.course.course.fakhretdinov_vs.bank.entity.core;


import java.io.Serializable;

public class Identifier implements Serializable {

    private final long id;

    public Identifier(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}