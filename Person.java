import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Person implements Comparable<Person> {
    private String name;
    private int rank;
    public static HashMap<String, Integer> rankMap;

    public Person() {
    }

    public Person(String name, int rank) {
        setName(name);
        setRank(rank);
    }

    public Person(String name, String rank) {
        setName(name);
        setRank(rank);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setRank(String rankString) {
        this.rank = rankMap.get(rankString.replaceAll("[^a-zA-Z]+", ""));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(String first, String last) {
        this.name = first + last;
    }

    public static Person createPlayer1() {
        Person Player1 = new Person();
        Player1.setRank(2);
        Player1.setName("Player1");
        return Player1;
    }

    public static Person createPlayer2() {
        Person Player1 = new Person();
        Player1.setRank(5);
        Player1.setName("Player2");
        return Player1;
    }

    public static Person createPlayer3() {
        Person Player1 = new Person();
        Player1.setRank(9);
        Player1.setName("Player3");
        return Player1;
    }

    public static Person createPlayer4() {
        Person Player1 = new Person();
        Player1.setRank(5);
        Player1.setName("Player4");
        return Player1;
    }

    public String toString() {
        return "Name : " + this.name + " Rank : " + this.rank;
    }

    @Override
    public int compareTo(Person other) {
        return getRank() - other.getRank();
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/Jae/Desktop/ranks.csv";

        // init rank map
        rankMap = new HashMap<>();
        rankMap.put("Unranked", 1);
        rankMap.put("Bronze", 1);
        rankMap.put("Silver", 2);
        rankMap.put("Gold", 3);
        rankMap.put("Platinum", 4);
        rankMap.put("Diamond", 5);
        rankMap.put("Master", 6);
        rankMap.put("Challenger", 7);

        ArrayList<Person> persons = new ArrayList<>();

        // read data
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            // skip header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String lineSplit[] = line.split(",");
                String name = lineSplit[0];
                String rank = lineSplit[1];
                persons.add(new Person(name, rank));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + filePath + " does not exist.");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // sort data
        Collections.sort(persons);

        // print data
        persons.stream().map(Person::toString).forEach(System.out::println);
    }
}