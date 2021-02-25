package offline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TelephoneBook {

    private Map<String, List<String>> telephoneBook;

    public TelephoneBook() {
        telephoneBook = new TreeMap<>();
    }

    public void add(String surname, String telephoneNumber){
        if(telephoneBook.containsKey(surname)) {
            telephoneBook.get(surname).add(telephoneNumber);
        }
        else {
            List <String> numbers = new ArrayList<>();
            numbers.add(telephoneNumber);
            telephoneBook.put(surname, numbers);
        }
    }

    public List<String> get(String surname){
        return telephoneBook.get(surname);
    }

}
