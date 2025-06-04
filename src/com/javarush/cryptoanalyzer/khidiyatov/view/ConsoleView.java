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
                            "2 - Дешифровка текста по ключу\n" +
                            "3 - BruteForce");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> encode();
            case "2" -> decode();
            case "3" -> bruteForce();
        }

        return parameters;
    }

    private void encode() {
        parameters[0] = "1";

        System.out.println("берем текст здесь: src/com/javarush/cryptoanalyzer/khidiyatov/texts/original.txt");
        parameters[1] = "src/com/javarush/cryptoanalyzer/khidiyatov/texts/original.txt";

        System.out.println("зашифрованный текст будет здесь: encode.txt");
        parameters[2] = "src/com/javarush/cryptoanalyzer/khidiyatov/texts/encode.txt";

        System.out.println("Введите ключ шифрования:");
        Scanner scanner = new Scanner(System.in);
        parameters[3] = scanner.nextLine();
    }

    private void decode() {
        parameters[0] = "2";

        System.out.println("берем текст здесь: src/com/javarush/cryptoanalyzer/khidiyatov/texts/encode.txt");
        parameters[1] = "src/com/javarush/cryptoanalyzer/khidiyatov/texts/encode.txt";

        System.out.println("расшифрованный текст будет здесь: decode.txt");
        parameters[2] = "src/com/javarush/cryptoanalyzer/khidiyatov/texts/decode.txt";

        System.out.println("Введите ключ:");
        Scanner scanner = new Scanner(System.in);
        parameters[3] = scanner.nextLine();
    }

    private void bruteForce() {
        parameters[0] = "3";

        System.out.println("берем текст здесь: src/com/javarush/cryptoanalyzer/khidiyatov/texts/encode.txt");
        parameters[1] = "src/com/javarush/cryptoanalyzer/khidiyatov/texts/encode.txt";

        System.out.println("расшифрованный текст будет здесь: bruteForce.txt");
        parameters[2] = "src/com/javarush/cryptoanalyzer/khidiyatov/texts/bruteForce.txt";
    }

    @Override
    public void printResult(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }
    }
}
