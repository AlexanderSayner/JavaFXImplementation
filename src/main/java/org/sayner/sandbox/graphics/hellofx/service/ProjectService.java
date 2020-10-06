package org.sayner.sandbox.graphics.hellofx.service;

import org.sayner.sandbox.graphics.hellofx.HelloFXApplication;
import org.sayner.sandbox.graphics.hellofx.dto.ProjectListResponse;
import org.sayner.sandbox.graphics.hellofx.model.Project;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class ProjectService extends AbstractRestClient{
    public ProjectService(WebClient webClient) {
        super(webClient, HelloFXApplication.OBJECT_MAPPER, getLogger(ProjectService.class));
    }

    public List<Project> getList() {
        logger.info("Sending request for project list data");
        return ((ProjectListResponse) sendGetRequest("/api/project", ProjectListResponse.class))
                .getProjects();
    }
/*
    public List<FullProjectDto> getFullProjectInfo(){
        final List<Project> projects = ((ProjectListResponse) sendGetRequest("/api/project", ProjectListResponse.class))
                .getProjects();

        for (Project project : projects) {

        }
    }
*/
//    public void update(Project project, String newName) {
//        sendPutRequest("/api/project/{id}", project.getId(), new DepartmentDto(newName), Department.class);
//    }
//
//    public void add(String name){
//        sendPostRequest("/api/project",new DepartmentDto(name),Department.class);
//    }
}
