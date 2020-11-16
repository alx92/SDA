package org.example.controller;

import org.example.model.ApodModel;
import org.example.service.ApodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/api")
public class ApodController {

    @Autowired
    ApodService apodService;

    // TODO - change get mapping endpoints to be just one endpoint
    // make an endpoint that takes today's date and then change the date when the user enters input
    // also change in frontend the get apod and getApodByDate to only one method that take today's date

    @GetMapping("/apod")
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
}

