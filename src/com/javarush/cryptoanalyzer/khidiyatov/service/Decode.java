package com.javarush.cryptoanalyzer.khidiyatov.service;

import com.javarush.cryptoanalyzer.khidiyatov.entity.Result;
import com.javarush.cryptoanalyzer.khidiyatov.exception.ApplicationException;

import static com.javarush.cryptoanalyzer.khidiyatov.repository.ResultCode.ERROR;
import static com.javarush.cryptoanalyzer.khidiyatov.repository.ResultCode.OK;

public class Decode implements Function {
    @Override
    public Result execute(String[] parameters) {
        try {
            // TODO finish Decode
        } catch (Exception e) {
            new Result(ERROR, new ApplicationException("Decode operation finish with Exception", e));
        }
        return new Result(OK);
    }
}
