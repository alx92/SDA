package org.example.controller;

import org.example.entity.ApodEntity;
import org.example.model.ApodModel;
import org.example.service.ApodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/api")
public class ApodController {

    @Autowired
    ApodService apodService;

    //APOD Controllers

    @GetMapping("/apods")
    public ResponseEntity<?> getApodList() {
        return ResponseEntity.ok(apodService.getApodList());
    }

    // TODO - change get mapping endpoints to be just one endpoint
    // make an endpoint that takes today's date and then change the date when the user enters input
    // also change in frontend the get apod and getApodByDate to only one method that take today's date

    @GetMapping("/apod/")
    public ApodModel getApod() {
       return apodService.getApod(LocalDate.now().toString());
    }

    @GetMapping("/apod/{date}")
    public ResponseEntity<ApodModel> getApod(@PathVariable String date) {
        if (date == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(apodService.getApod(date));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addApod(String date) {
        ApodModel apodModel = apodService.getApod(date);

        ApodEntity apodEntity = new ApodEntity();

        apodEntity.setTitle(apodModel.getTitle());
        apodEntity.setExplanation(apodModel.getExplanation());
        apodEntity.setUrl(apodModel.getUrl());
        apodEntity.setDate(apodModel.getDate());
        apodEntity.setMediaType(apodModel.getMediaType());

        return ResponseEntity.ok(apodService.createApod(apodEntity));
    }

}

