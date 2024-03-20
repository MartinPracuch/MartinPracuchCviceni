package org.agel.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.agel.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProjectController {

    private final String gitLabApiUrl = "https://gitlab.com/api/v4/projects";
    private final String accessToken ="glpat-NPiDYzBhBbo3J-zjxWyA";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private final ProjectService projectService;

    @Autowired
    public ProjectController(RestTemplate restTemplate, ObjectMapper objectMapper, ProjectService projectService) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.projectService = projectService;
    }

    //processing data logic is in ProjectService class
    @GetMapping("/projects")
    public ResponseEntity<String> getProject() {
        return projectService.getProject();
    }


}