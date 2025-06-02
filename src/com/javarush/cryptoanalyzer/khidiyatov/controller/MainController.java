package com.javarush.cryptoanalyzer.khidiyatov.controller;

import com.javarush.cryptoanalyzer.khidiyatov.view.View;

public class MainController {

    private View view;

    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
