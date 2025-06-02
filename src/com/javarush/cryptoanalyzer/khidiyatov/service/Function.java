package com.javarush.cryptoanalyzer.khidiyatov.service;

import com.javarush.cryptoanalyzer.khidiyatov.entity.Result;

public interface Function {
    Result execute(String[] parameters);
}
