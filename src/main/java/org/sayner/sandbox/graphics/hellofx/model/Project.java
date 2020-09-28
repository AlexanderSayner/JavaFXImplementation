package org.sayner.sandbox.graphics.hellofx.model;

import java.time.LocalDate;

public class Project {
    private int id;

    private String name;

    private LocalDate open_date;

    private LocalDate release_date;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public LocalDate getOpen_date(){
        return this.open_date;
    }

    public void setOpen_date(LocalDate open_date){
        this.open_date = open_date;
    }

    public LocalDate getRelease_date(){
        return this.release_date;
    }

    public void setRelease_date(LocalDate release_date){
        this.release_date = release_date;
    }
}
