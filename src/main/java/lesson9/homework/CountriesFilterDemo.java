package lesson9.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CountriesFilterDemo {
    public static void main(String[] args) {

        String [] words = {"Andorra", "Canada", "wood", "parrot", "Cuba", "Argentina", "Aruba", "Alex", "Finland"};
        HashSet<String> countries = new HashSet<>(
                Arrays.asList("Andorra", "Belize", "France", "Argentina", "Cuba", "Sweden")
        );

        TreeSet<String> wordsCountries = new TreeSet<>();

        for (String word : words) {
            if (countries.contains(word))
                wordsCountries.add(word);
        }

        Set<String> slice = wordsCountries.subSet("A", "B"); // непонятно, почему не срабатывает subset("A", true, "A", true)...

        System.out.println("Filtered words as countries begin from \"A\": " + slice); // непонятно, почему не срабатывает

    }
}
