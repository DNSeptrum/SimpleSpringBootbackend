package com.example.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateService {

    private final RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public Rate saveRate(Rate rate) {
        return rateRepository.save(rate);
    }

    // Inne metody serwisu zgodnie z potrzebami
}