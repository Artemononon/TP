package org.example;

import java.util.HashMap;
import java.util.Map;

public class UniqueWords {
    public static void main(String[] args) {
        String[] wordsArray = {"кидать", "спешить", "враг", "кидать", "друг", "спешить", "друг", "враг", "спешить", "кидать", "враг"};
        Map<String, Integer> wordCount = new HashMap<>();
        for (var word : wordsArray) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Количество повторений: " + wordCount.entrySet());

        //Индивидуальное задание
        Thesaurus thesaurus = new Thesaurus();

        thesaurus.add("кидать", "метать");
        thesaurus.add("кидать", "бросать");
        thesaurus.add("спешить", "торопиться");
        thesaurus.add("спешить", "поспешать");
        thesaurus.add("враг", "неприятель");
        thesaurus.add("враг", "недруг");
        thesaurus.add("друг","приятель");
        thesaurus.add("друг","товарищ");
        thesaurus.add("друг1","товарищ1");


        System.out.println("\nСловарь синонимов:");
        thesaurus.print();

//        System.out.println("\nСинонимы для слова кидать: " + thesaurus.get("кидать"));
//        System.out.println("Синонимы для слова спешить: " + thesaurus.get("спешить"));
//        System.out.println("Синонимы для слова враг: " + thesaurus.get("враг"));
//        System.out.println("Синонимы для слова друг: " + thesaurus.get("друг"));
    }
}