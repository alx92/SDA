package org.example.service;

import org.example.model.ApodModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApodService extends org.example.service.Service {

    public ApodModel getApod(String date) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                "https://api.nasa.gov/planetary/apod?api_key=" +
                    getKey() + "&date=" + date,
                ApodModel.class);
    }
}
