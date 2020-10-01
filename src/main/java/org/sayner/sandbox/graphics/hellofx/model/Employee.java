        package org.sayner.sandbox.graphics.hellofx.model;
        import java.util.List;

public class Employee
{
    private int id;

    private String firstname;

    private String lastname;

    private String state;

    private String email;

    private List<Role> roles;

    private List<Department> departments;

    private List<Project> projects;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstname(){
        return this.firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return this.lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getState(){
        return this.state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public List<Role> getRoles(){
        return this.roles;
    }

    public void setRoles(List<Role> roles){
        this.roles = roles;
    }

    public List<Department> getDepartments(){
        return this.departments;
    }

    public void setDepartments(List<Department> departments){
        this.departments = departments;
    }

    public List<Project> getProjects(){
        return this.projects;
    }

    public void setProjects(List<Project> projects){
        this.projects = projects;
    }
}
