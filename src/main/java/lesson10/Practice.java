package lesson10;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
        String sentence = "два раза это два раза";
        HashSet<Word> counted = countWords(sentence);
        System.out.println(counted);

    }

    public static HashSet<Word> countWords(String s) {

        //String [] words = s.split(" ");
        HashSet<Word> words = new HashSet<>();

        for (String w : s.split(" ")) {
            Word word = new Word(w);
            // если слово word уже есть в words,
            if (words.contains(word)) {
                // получим его из сета и увеличим count на 1.
                word = findWord(words, word);
            }
            word.count++;
            // Если слова нет, то добавим его.
            words.add(word); // Если слово есть, то оно не добавится заново. Но count все равно будет увеличен.
        }
        return words;
    }

    // Gj
    // поиск слова перебором в наборе слов
    public static Word findWord(Set<Word> words, Word sample)
    {
        for(Word w: words)
        {
            if(w.equals(sample))
                return w;
        }
        return null;
    }


    static class Word {
        public String key;
        public int count = 0;

        public Word(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key + ":" + count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Word word = (Word) o;

            return key.equals(word.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }

}
