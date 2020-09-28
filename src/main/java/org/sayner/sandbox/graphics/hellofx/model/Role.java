package org.sayner.sandbox.graphics.hellofx.model;

public class Role {
    private int id;

    private String role;

    private String skillLevel;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getRole(){
        return this.role;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getSkillLevel(){
        return this.skillLevel;
    }

    public void setSkillLevel(String skillLevel){
        this.skillLevel = skillLevel;
    }
}
