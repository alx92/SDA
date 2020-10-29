package org.example.service;

import org.example.entity.ApodEntity;
import org.example.model.ApodModel;
import org.example.repository.ApodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApodService extends org.example.service.Service {

    @Autowired
    private ApodRepository apodRepository;

    public List<ApodEntity> getApodList() {
        return apodRepository.findAll();
    }

//    public ApodEntity getApod(String date) {
//        return apodRepository.findApodEntityByDate(date);
//    }

    public ApodEntity createApod(ApodEntity apodEntity) {
        return apodRepository.save(apodEntity);
    }

    public ApodModel getApod(String date) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                "https://api.nasa.gov/planetary/apod?api_key=" +
                    getKey() + "&date=" + date,
                ApodModel.class);
    }
}
