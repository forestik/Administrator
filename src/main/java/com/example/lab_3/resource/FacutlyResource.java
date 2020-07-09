package com.example.lab_3.resource;

import com.example.lab_3.entity.Faculty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FacutlyResource {
    private static final String BILL_SERVICE_URL = "http://localhost:6060";

    private final RestTemplate restTemplate;

    public FacutlyResource() {
        this.restTemplate = new RestTemplate();
    }

    public Faculty findFacultyById(final Long facultyId) {
        Faculty faculty = restTemplate.getForObject(BILL_SERVICE_URL + "/administrator/findbyid" + "?id=" + facultyId, Faculty.class);
        return faculty;

    }

    public Faculty saveFaculty(final Faculty faculty) {
        Faculty faculty1= restTemplate.postForObject(BILL_SERVICE_URL + "/abiturient/save", faculty, Faculty.class);
        return faculty1;
    }

}
