package lesson10.homework;

import java.util.LinkedHashSet;
import java.util.Set;

/*
1. Напишите функцию, которая создает по фразе concordance - в каком порядке и на каких позициях слова присутствуют во фразе
"один раз это один раз" -> "один":[0,3], "раз":[1,4], "это":[2]
* */
public class Concordance {
    public static void main(String[] args) {
        String sentence = "один раз это один раз";
    }

    // поиск элемента в списке
    // если не нашли, возвращаем null
    public static Element findElement(Set<Element> elements, Element e) {
        for (Element element : elements) {
            if (element.equals(e)) {
                return element;
            }
        }
        return null;
    }

    public static Set<Element> concordance(String s)
    {
        Set<Element> r = new LinkedHashSet<>();

        String [] words = s.split(" ");
        for(int i = 0; i < words.length; i++)
        {
            String word = words[i];
            Element e = new Element(word);
            Element existingElement = findElement(r, e);
            if(existingElement != null)
                existingElement.positions.add(i);
            else {
                e.positions.add(i);
                r.add(e);
            }
        }

        return r;
    }
}

