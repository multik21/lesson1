import java.util.*;

class HomeWork3 {

    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        Map<String, Integer> hm = new HashMap<>();
        String[] words = {
                "Coffee", "Poc", "Picanto",
                "Cheese", "Beta", "Rom",
                "Dog", "Cat", "Java",
                "Yava", "Kent", "Coffee",
                "Dog", "Beta", "Humster",
                "Cat", "Java", "Yava", "Dog"
        };

        for (int i = 0; i < words.length; i++) {
            if (hm.containsKey(words[i]))
                hm.put(words[i], hm.get(words[i]) + 1);
            else
                hm.put(words[i], 1);
        }
        System.out.println(hm);
    }

    private static void task2() {
        Directory directory = new Directory();

        directory.add("antonov", "89876785466");
        directory.add("golub", "87654567890");
        directory.add("berskov", "89997778899");
        directory.add("buda", "89366784567");
        directory.add("antoni", "87897899090");
        directory.add("vilodov", "89093005544");
        directory.add("bobcatov", "83005005678");
        directory.add("churicov", "88888889090");
        directory.add("golub", "8456789567");

        System.out.println(directory.get("antonov"));
        System.out.println(directory.get("antoni"));
        System.out.println(directory.get("bobcatov"));
        System.out.println(directory.get("churicov"));
    }
}

class Directory {
    private Map<String, List<String>> directory_hm = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (directory_hm.containsKey(surname)) {
            phone_number_list = directory_hm.get(surname);
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        }
    }

    public List<String> get(String surname) {
        return directory_hm.get(surname);
    }

}