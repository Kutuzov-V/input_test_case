package ru.kutuzov.javacource;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String webMessage = HTTPRequester.sendHttpGETRequest((int)(Math.random()*1000));
        Calculator.calcAverageSymbolFreq(webMessage);
    }
}
