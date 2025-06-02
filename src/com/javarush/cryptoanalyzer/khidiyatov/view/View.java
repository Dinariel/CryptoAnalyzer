package com.javarush.cryptoanalyzer.khidiyatov.view;

import com.javarush.cryptoanalyzer.khidiyatov.entity.Result;

public interface View {

    // 0 - инструкция, 1 - откуда брать, 2 - куда положить
    String[] getParameters();

    void printResult(Result result);
}
