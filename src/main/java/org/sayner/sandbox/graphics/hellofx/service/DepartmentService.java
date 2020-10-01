package org.sayner.sandbox.graphics.hellofx.service;

import org.sayner.sandbox.graphics.hellofx.HelloFXApplication;
import org.sayner.sandbox.graphics.hellofx.dto.DepartmentDto;
import org.sayner.sandbox.graphics.hellofx.dto.DepartmentListResponse;
import org.sayner.sandbox.graphics.hellofx.model.Department;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class DepartmentService extends AbstractRestClient {
    public DepartmentService(WebClient webClient) {
        super(webClient, HelloFXApplication.OBJECT_MAPPER, getLogger(DepartmentService.class));
    }

    public List<Department> getList() {
        logger.info("Sending request for department list data");
        return ((DepartmentListResponse) sendGetRequest("/api/department", DepartmentListResponse.class))
                .getDepartments();
    }

    public void update(Department department, String newName) {
        sendPutRequest("/api/department/{id}", department.getId(), new DepartmentDto(newName), Department.class);
    }

    public void add(String name){
        sendPostRequest("/api/department",new DepartmentDto(name),Department.class);
    }
}
