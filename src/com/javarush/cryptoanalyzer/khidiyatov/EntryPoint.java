package com.javarush.cryptoanalyzer.khidiyatov;

import com.javarush.cryptoanalyzer.khidiyatov.app.Application;
import com.javarush.cryptoanalyzer.khidiyatov.controller.MainController;
import com.javarush.cryptoanalyzer.khidiyatov.entity.Result;
import com.javarush.cryptoanalyzer.khidiyatov.view.ConsoleView;
import com.javarush.cryptoanalyzer.khidiyatov.view.View;

public class EntryPoint {
    public static void main(String[] args) {

        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);

        Result result = application.run();
        application.printResult(result);
    }
}
