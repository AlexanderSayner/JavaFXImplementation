package org.sayner.sandbox.graphics.hellofx.dto;

import org.sayner.sandbox.graphics.hellofx.model.Project;

import java.util.List;

public class ProjectListResponse {
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
