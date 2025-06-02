package com.javarush.cryptoanalyzer.khidiyatov.repository;

import com.javarush.cryptoanalyzer.khidiyatov.service.Decode;
import com.javarush.cryptoanalyzer.khidiyatov.service.Encode;
import com.javarush.cryptoanalyzer.khidiyatov.service.Function;
import com.javarush.cryptoanalyzer.khidiyatov.service.UnsupportedFunction;

public enum FunctionCode {
    ENCODE(new Encode()),
    DECODE(new Decode()),
    UNSUPPORTED_FUNCTION(new UnsupportedFunction());

    private Function function;

    FunctionCode(Function function) {
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }
}
