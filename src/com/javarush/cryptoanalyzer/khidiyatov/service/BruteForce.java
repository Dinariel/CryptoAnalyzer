package com.javarush.cryptoanalyzer.khidiyatov.service;

import com.javarush.cryptoanalyzer.khidiyatov.entity.Result;
import com.javarush.cryptoanalyzer.khidiyatov.exception.ApplicationException;

import static com.javarush.cryptoanalyzer.khidiyatov.constants.CryptoAlphabet.ALPHABET;
import static com.javarush.cryptoanalyzer.khidiyatov.entity.FileManager.readFile;
import static com.javarush.cryptoanalyzer.khidiyatov.entity.FileManager.writeFile;
import static com.javarush.cryptoanalyzer.khidiyatov.repository.ResultCode.ERROR;
import static com.javarush.cryptoanalyzer.khidiyatov.repository.ResultCode.OK;
import static com.javarush.cryptoanalyzer.khidiyatov.service.Encode.encode;

public class BruteForce implements Function {
    @Override
    public Result execute(String[] parameters) {

        try {
            String text = readFile(parameters[1]);
            int countMatch = 0;
            int key = 0;

            for (int i = 0; i < ALPHABET.length; i++) {
                String encode = encode(text, i);
                String[] split = encode.split(".[.,;:!?]\\s");
                if (countMatch < split.length) {
                    countMatch = split.length;
                    key = i;
                }
            }

            if (countMatch == 0) {
                return new Result(ERROR, new ApplicationException("Key not found by BruteForce operation"));
            }

            writeFile(encode(text, key), parameters[2]);

        } catch (Exception e) {
            return new Result(ERROR, new ApplicationException("Decode operation finish with Exception", e));
        }

        return new Result(OK);
    }

}
