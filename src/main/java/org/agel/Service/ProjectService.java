package org.agel.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

//handles processing information from API
@Service
public class ProjectService {
    private final String gitLabApiUrl = "https://gitlab.com/api/v4/projects";
    private final String accessToken ="glpat-NPiDYzBhBbo3J-zjxWyA";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ProjectService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    //method for getting projects from API
    public ResponseEntity<String> getProject() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer" + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange((gitLabApiUrl), HttpMethod.GET, entity, String.class);

            // formating the json response into better readle version
            String formattedResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response.getBody());

            return ResponseEntity.ok(formattedResponse);

        } catch (Exception e) { //error handling
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch projects from GitLab API");
        }
    }
}


