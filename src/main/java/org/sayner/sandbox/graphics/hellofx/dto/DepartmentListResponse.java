package org.sayner.sandbox.graphics.hellofx.dto;

import org.sayner.sandbox.graphics.hellofx.model.Department;

import java.util.List;

public class DepartmentListResponse {
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
