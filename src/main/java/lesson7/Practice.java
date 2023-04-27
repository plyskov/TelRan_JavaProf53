package lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice{
    public static void main(String[] args) {
        List<String> countries = new ArrayList<>(
                Arrays.asList("Andorra", "Costa-Rica", "Salvador", "Chad", "South Korea")
        );
        countries.add("Serbia");

//        Filter fil = new Filter() {
//            @Override
//            public boolean filter(String s) {
//                String checkStr = s.toLowerCase();
//                return checkStr.contains("s");
//            }
//        };

        // От ПРЕПОДАВАТЕЛЯ: фильтры через лямбды
        Filter fil = s -> s.toLowerCase().contains("s");

        List filteredCountries = filter(countries, fil);
        System.out.println(filteredCountries);
    }

    public static List<String> filter(List<String> s, Filter f) {
        List<String> result = new ArrayList<>();
        // сделать реализацию фильтра, которая возвращает true только для строк,
        // в которых есть буква s
        // и с помощью функции filter отфильтруйте список стран

        for (String string : s) {
            if (f.filter(string)){
                result.add(string);
            }
        }

        return result;
    }
}

interface Filter {
    public boolean filter(String s);
}
