package com.javarush.cryptoanalyzer.khidiyatov.service;

import com.javarush.cryptoanalyzer.khidiyatov.entity.Result;
import com.javarush.cryptoanalyzer.khidiyatov.exception.ApplicationException;

import java.util.Arrays;

import static com.javarush.cryptoanalyzer.khidiyatov.constants.CryptoAlphabet.ALPHABET;
import static com.javarush.cryptoanalyzer.khidiyatov.entity.FileManager.readFile;
import static com.javarush.cryptoanalyzer.khidiyatov.entity.FileManager.writeFile;
import static com.javarush.cryptoanalyzer.khidiyatov.repository.ResultCode.ERROR;
import static com.javarush.cryptoanalyzer.khidiyatov.repository.ResultCode.OK;

public class Encode implements Function {

    @Override
    public Result execute(String[] parameters) {
        // TODO finish Encode
        try {
            String text = readFile(parameters[1]);
            StringBuilder stringBuilder = new StringBuilder();
            int key = Integer.parseInt(parameters[3]);
            key %= ALPHABET.length;
            Arrays.sort(ALPHABET);

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                int symbolOfAlphabet = Arrays.binarySearch(ALPHABET, c);
                if (symbolOfAlphabet < 0) {
                    stringBuilder.append(c);
                    continue;
                }
                int codedSymbol = symbolOfAlphabet + key;
                if (codedSymbol >= ALPHABET.length) {
                    codedSymbol -= ALPHABET.length;
                }
                char newChar = ALPHABET[codedSymbol];
                stringBuilder.append(newChar);
            }

            String codedText = stringBuilder.toString();
            writeFile(codedText, parameters[2]);

        } catch (Exception e) {
            new Result(ERROR, new ApplicationException("Decode operation finish with Exception", e));
        }
        return new Result(OK);
    }

}
