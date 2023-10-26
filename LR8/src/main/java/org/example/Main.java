package org.example;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.lang.String;

public class Main {
    public static void main(String[] args) {

        String[] words = {"чизбургер", "данартурр", "чизбургер", "данар", "хот дог", "данартурр"};

        System.out.println(Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .filter(entry -> entry.getValue() == Collections.max(
                        Arrays.stream(words)
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                .values()))
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.joining(", ")));



        List<ne_main> contacts =new ArrayList<>(Arrays.asList (
                new ne_main("Andre", "Belyavin", 19, "89127390762"),
                new ne_main("Artemon","Mikheev", 7,"89536839017"),
                new ne_main("Romchik", "Chulkov", 18, "89634333819"),
                new ne_main("mr.Boroda", "Matantcev", 70, "7777777777")));
        int n = 3;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите подстроку для поиска фамилий: ");
        String substring = scanner.nextLine();

        System.out.println(contacts.stream()
                .filter(contact -> contact.getLastName().contains(substring))
                .sorted(Comparator.comparingInt(ne_main::getAge).reversed())
                .limit(n)
                .map(ne_main::getFirstName)
                .collect(Collectors.joining(", ", n + " контактов зовут: ", ".")));
    }
}
