package com.example.lab_3.resource;

import com.example.lab_3.entity.Abiturient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AbiturientResource {
    private static final String BILL_SERVICE_URL = "http://localhost:9090";

    private final RestTemplate restTemplate;

    public AbiturientResource() {
        this.restTemplate = new RestTemplate();
    }

    public Abiturient findAbiturientById(final Long abiturientId) {

        Abiturient abiturient = restTemplate.getForObject(BILL_SERVICE_URL + "/abiturient/findbyid" + "?id=" + abiturientId, Abiturient.class);

        return abiturient;
    }

    public Abiturient saveAbiturient(final Abiturient abiturient) {

        Abiturient abiturient1 = restTemplate.postForObject(BILL_SERVICE_URL + "/abiturient/save", abiturient, Abiturient.class);

        return abiturient1;
    }

}
