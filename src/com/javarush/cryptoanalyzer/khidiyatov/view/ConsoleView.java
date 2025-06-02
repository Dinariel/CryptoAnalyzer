package com.javarush.cryptoanalyzer.khidiyatov.view;

import com.javarush.cryptoanalyzer.khidiyatov.entity.Result;

import static com.javarush.cryptoanalyzer.khidiyatov.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptoanalyzer.khidiyatov.constants.ApplicationCompletionConstants.SUCCESS;

public class ConsoleView implements View{
    @Override
    public String[] getParameters() {
        // TODO finish getParameters
        return new String[0];
    }

    @Override
    public void printResult(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }
    }
}
