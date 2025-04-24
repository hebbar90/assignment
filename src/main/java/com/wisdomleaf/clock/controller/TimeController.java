package com.wisdomleaf.clock.controller;

import com.wisdomleaf.clock.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/speak")
    public ResponseEntity<String> getTimeInWords(@RequestParam String time) {
        return ResponseEntity.ok(timeService.convertTimeToWords(time));
    }
}
