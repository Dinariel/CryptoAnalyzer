package com.javarush.cryptoanalyzer.khidiyatov.view;

import com.javarush.cryptoanalyzer.khidiyatov.entity.Result;

import java.util.Scanner;

import static com.javarush.cryptoanalyzer.khidiyatov.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptoanalyzer.khidiyatov.constants.ApplicationCompletionConstants.SUCCESS;

public class ConsoleView implements View{
    private final String[] parameters = new String[10];

    @Override
    public String[] getParameters() {
        // TODO finish getParameters
        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите, что будем делать:");
        System.out.println( "1 - Шифрование текста по ключу\n" +
                            "2 - Дешифровка текста по ключу");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> encode();
            case "2" -> decode();
        }

        return parameters;
    }

    private void encode() {
        parameters[0] = "1";
        System.out.println("берем текст здесь: src/com/javarush/cryptoanalyzer/khidiyatov/texts/inputText.txt");
        parameters[1] = "src/com/javarush/cryptoanalyzer/khidiyatov/texts/inputText.txt";
        System.out.println("зашифрованый текст будет здесь:");
        parameters[2] = "src/com/javarush/cryptoanalyzer/khidiyatov/texts/outputText.txt";
        System.out.println("Введите ключ шифрования:");
        Scanner scanner = new Scanner(System.in);
        parameters[3] = scanner.nextLine();
    }

    private void decode() {

    }

    @Override
    public void printResult(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }
    }
}
