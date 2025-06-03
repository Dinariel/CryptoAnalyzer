package com.javarush.cryptoanalyzer.khidiyatov.service;

import com.javarush.cryptoanalyzer.khidiyatov.entity.Result;
import com.javarush.cryptoanalyzer.khidiyatov.exception.ApplicationException;

import static com.javarush.cryptoanalyzer.khidiyatov.entity.FileManager.readFile;
import static com.javarush.cryptoanalyzer.khidiyatov.entity.FileManager.writeFile;
import static com.javarush.cryptoanalyzer.khidiyatov.repository.ResultCode.ERROR;
import static com.javarush.cryptoanalyzer.khidiyatov.repository.ResultCode.OK;
import static com.javarush.cryptoanalyzer.khidiyatov.service.Encode.encode;

public class Decode implements Function {
    @Override
    public Result execute(String[] parameters) {
        try {
            // TODO finish Decode
            String text = readFile(parameters[1]);

            int key = Integer.parseInt(parameters[3]);

            writeFile(encode(text, -key), parameters[2]);
        } catch (Exception e) {
            return new Result(ERROR, new ApplicationException("Decode operation finish with Exception", e));
        }
        return new Result(OK);
    }
}
