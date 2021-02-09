package offline;

import java.util.*;

public class Main {

    public static void main(String[] args){
        //task 1
        String[] words = {"dog", "bird", "cat", "elephant", "cat", "hippo", "tiger", "fox", "giraffe",
        "fox", "dog", "rhino", "squirrel", "hippo", "lizard", "snake"};
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
        System.out.println(wordsList);
        //without duplicates
        System.out.println("Without duplicates:");
        Set<String> stringSet = new HashSet<>(wordsList);
        System.out.println(stringSet);
        //count duplicates
        System.out.println("Count duplicates");
        System.out.println(countDuplicates(words));

        //task2
        TelephoneBook book = new TelephoneBook();
        book.add("Ksenia", "88005553535");
        book.add("Ksenia", "89067778899");
        book.add("Aleksandr", "12345678912");
        book.add("Artem", "89997774456");
        System.out.println(book.get("Ksenia"));
        System.out.println(book.get("Aleksandr"));
        System.out.println(book.get("Artem"));
        //было интересно, правильно ли будет работать, если спрошу о человеке, которого нет в книге
//        System.out.println(book.get("Maria"));
    }

    public static Map<String, Integer> countDuplicates(String[] words){
        Map<String, Integer> mapWords = new HashMap<String, Integer>();
        for(String word : words){
            if(!mapWords.containsKey(word)){
                mapWords.put(word, 1);
            } else {
                mapWords.put(word, mapWords.get(word) + 1);
            }
        }
        return mapWords;
    }
}
