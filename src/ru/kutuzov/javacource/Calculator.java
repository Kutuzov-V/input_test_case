package ru.kutuzov.javacource;

import java.util.HashMap;
import java.util.Set;

public class Calculator {
    public static void calcAverageSymbolFreq(String webMessage){
        HashMap<Character,Integer> symbolFreqList = getSymbolFreqList(webMessage);
        printSymbolsFreq(symbolFreqList);

        int closeFreqNum = getCloseFreqNum(symbolFreqList,webMessage);
        printCloseFreqNum(symbolFreqList,webMessage,closeFreqNum);

    }
    private static HashMap<Character,Integer> getSymbolFreqList(String analiseStr){
        HashMap<Character,Integer> symbolFreqList = new HashMap<>();

        for (int i = 0; i < analiseStr.length(); i++) {
            char c = analiseStr.charAt(i);
            Integer val = symbolFreqList.get(c);
            if (val != null) {
                symbolFreqList.put(c, (val + 1));
            }
            else {
                symbolFreqList.put(c, 1);
            }
        }
        return symbolFreqList;
    }
    private static int getCloseFreqNum(HashMap<Character,Integer> SymbolFreqList,String analiseStr){
        Set<Character> characters = SymbolFreqList.keySet();

        double webMessageLength = analiseStr.length();
        double characterCount = characters.size();
        double averageFreqVal = webMessageLength/characterCount;


        int delta = Integer.MAX_VALUE;
        int closeFreqNum = -1;
        for(Character character:characters){
            int current_delta = Math.abs(SymbolFreqList.get(character)-(int)(averageFreqVal+0.5));
            if(current_delta < delta){
                delta = current_delta;
                closeFreqNum = SymbolFreqList.get(character);
            }
        }
        return closeFreqNum;
    }


    //-------------------------------------Screen output methods--------------------------------------------------------
    private static void  printSymbolsFreq(HashMap<Character,Integer> SymbolFreqList){
        Set<Character> characters = SymbolFreqList.keySet();

        System.out.println("Частоты:");
        for(Character character:characters){
            System.out.print("\"" + character + "\"" + " - " + SymbolFreqList.get(character) + ";  ");
        }
    }
    private static void printCloseFreqNum(HashMap<Character,Integer> symbolFreqList, String analiseStr,int closeFreqNum){
        Set<Character> characters = symbolFreqList.keySet();

        double webMessageLength = analiseStr.length();
        double characterCount = characters.size();
        double averageFreqVal = webMessageLength/characterCount;
        System.out.println("\nСреднее значение частоты: " + webMessageLength + "/" + characterCount + " = " + averageFreqVal);

        System.out.println("Символы, которые соответсвуют условию наиболее близкого значения частоты к среднему значению: ");
        for(Character character: characters){
            if(symbolFreqList.get(character) == closeFreqNum ){
                System.out.println(character + "(" + (byte)character.charValue() + ")");
            }
        }
    }


}
