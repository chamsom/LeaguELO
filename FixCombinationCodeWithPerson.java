import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Person implements Comparable<Person> {
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
		if (rankString.equals( "Bronze 5")){ this.rank = 1;}
		else if(rankString.equals("Bronze 4")){this.rank = 1;}
		else if(rankString.equals("Bronze 3")){this.rank = 1;}
		else if(rankString.equals("Bronze 2")){this.rank = 1;}
		else if(rankString.equals("Bronze 1")){this.rank = 1;}
		else if(rankString.equals("Unranked")){this.rank = 1;}
		else if(rankString.equals("Silver 5")){this.rank = 2;}
		else if(rankString.equals("Silver 4")){this.rank = 2;}
		else if(rankString.equals("Silver 3")){this.rank = 2;}
		else if(rankString.equals("Silver 2")){this.rank = 2;}
		else if(rankString.equals("Silver 1")){this.rank = 2;}
		else if(rankString.equals("Gold 5")){this.rank = 3;}
		else if(rankString.equals("Gold 3")){this.rank = 3;}
		else if(rankString.equals("Gold 4")){this.rank = 3;}
		else if(rankString.equals("Gold 2")){this.rank = 3;}
		else if(rankString.equals("Gold 1")){this.rank = 3;}
		else if(rankString.equals("Diamond 5")){this.rank = 5;}
		else if(rankString.equals("Diamond 4")){this.rank = 5;}
		else if(rankString.equals("Diamond 3")){this.rank = 5;}
		else if(rankString.equals("Diamond 2")){this.rank = 5;}
		else if(rankString.equals("Diamond 1")){this.rank = 5;}
		else if(rankString.equals("Platinum 5")){this.rank = 4;}
		else if(rankString.equals("Platinum 4")){this.rank = 4;}
		else if(rankString.equals("Platinum 3")){this.rank = 4;}
		else if(rankString.equals("Platinum 2")){this.rank = 4;}
		else if(rankString.equals("Platinum 1")){this.rank = 4;}
		else if(rankString.equals("Master")){this.rank = 6;}
		else if(rankString.equals("Challenger")){this.rank = 7;}
		else {this.rank = 69;}
    }

    public String getName() {
        return name;
    }

	public boolean equal(Person a){
		if(this.getName().equals(a.getName())){
			return true;
		}
		else{
			return false;
		}
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
}

class CombinationB { 
 public static void combinations(int n, Person[] arr, List<Person[]> list) {
	// calculate the number of arrays we should create
    int numArrays = (int)Math.pow(arr.length, n);
    // create each array
    for(int i = 0; i < numArrays; i++) {
        list.add(new Person[n]);
    }
    // fill up the arrays
    for(int j = 0; j < n; j++) {
        // this is the period with which this position changes, i.e.
        // a period of 5 means the value changes every 5th array
        int period = (int) Math.pow(arr.length, n - j - 1);
        for(int i = 0; i < numArrays; i++) {
            Person[] current = list.get(i);
            // get the correct item and set it
            int index = i / period % arr.length;
            current[j] = arr[index];
        }
    }
	letsJam(list);
} 

 public static boolean checkDoublePlayer(int currentTeam, List<Person[]> teams){
	 // checks a team for dublicate player within itself
		for (int i = 1; i < 5; i++){
			if(teams.get(currentTeam)[0].getName().equals(teams.get(currentTeam)[i].getName())){
				return false;
			}
		}
		for (int q = 2; q < 5; q++){
			if(teams.get(currentTeam)[1].getName().equals(teams.get(currentTeam)[q].getName())){
				return false;
			}
		}
		for (int k = 3; k < 5; k++){
			if(teams.get(currentTeam)[2].getName().equals(teams.get(currentTeam)[k].getName())){
				return false;
			}
		}
		if(teams.get(currentTeam)[3].getName().equals(teams.get(currentTeam)[4].getName())){
			return false;
		}
		return true;
	}
	
public static boolean checkRepeatedPlayer(int checkedArray,int checkingArray, List<Person[]> teams){
  // checks a team against another team
	for(int i = 0; i < 5; i++){
		for(int j = 0; j < 5; j++){
			if(teams.get(checkedArray)[i].getName().equals(teams.get(checkingArray)[j].getName())){
				return false;
			}
		}
	}
	return true;
}

public static int calcRankScore(int num, List<Person[]> teams){
	// calculates ranked score of a team
	int x;
	x = teams.get(num)[0].getRank() + teams.get(num)[1].getRank() + teams.get(num)[3].getRank() + teams.get(num)[4].getRank() + teams.get(num)[2].getRank();
	return x;
}

public static boolean checkRankScore(int a, int b, List<Person[]> teams){
	// compares two ranked scores, returns false if their equal
	if(calcRankScore(a, teams) == calcRankScore(b, teams)){
			return true;
	}
	return false;
}

public static void printTeam(int a, List<Person[]> teams){
	// compares two ranked scores, returns false if their equal
	System.out.print(teams.get(a)[0].getName() + " ,");
	System.out.print(teams.get(a)[1].getName() + " ,");
	System.out.print(teams.get(a)[2].getName() + " ,");
	System.out.print(teams.get(a)[3].getName() + " ,");
	System.out.println(teams.get(a)[4].getName());
}

public static int[] compareFullSet(List<Person[]> teams){
	// this bad boy should go about doing everything
	int[] teamLocations = {0,0};
	ArrayList<Integer> noDupeLocations = new ArrayList<Integer>();
	int dupeCounted = 0;
	for(int dupeCounter = 0; dupeCounter < 99999; dupeCounter++){
		if(checkDoublePlayer(dupeCounter, teams)){
		 noDupeLocations.add(dupeCounter);
		 dupeCounted = dupeCounted + 1;
		}
	}
//	System.out.println("Number of non-dupes is: ");
//	System.out.println(noDupeLocations.size());
	
	for(int i= 0; i < 30239; i++){
		for(int j= 1; j < 30240; j++){
			if(checkRepeatedPlayer(noDupeLocations.get(i), noDupeLocations.get(j), teams)){
				/**System.out.println("locations within of non-dupes");
				System.out.println(i);
				System.out.println(j);
				System.out.println("locations of non dupes");
				System.out.println(noDupeLocations.get(i));
				System.out.println(noDupeLocations.get(j));
				System.out.println("boolean value");
				System.out.println(checkRepeatedPlayer(noDupeLocations.get(i), noDupeLocations.get(j), teams));**/
				if(checkRankScore(noDupeLocations.get(i), noDupeLocations.get(j), teams)){
					teamLocations[0] = noDupeLocations.get(i);
					teamLocations[1] = noDupeLocations.get(j);
					System.out.println(" ");
					return teamLocations;
				}
			}else{
			}
			
		}
	}
	System.out.println("No matches!");
	return teamLocations;
}


public static void letsJam(List<Person[]> teams){
	int[] finalLocations = compareFullSet(teams);
	int a = finalLocations[0];
	int b = finalLocations[1];
//	System.out.println("Team location A: " + finalLocations[0]);
//	System.out.println("Team location B: " + finalLocations[1]);
	System.out.println("Here are the balanced teams! " + "\n");
	System.out.println("Team A is: ");
	System.out.print(teams.get(a)[0].getName() + ", ");
	System.out.print(teams.get(a)[1].getName() + ", ");
	System.out.print(teams.get(a)[2].getName() + ", ");
	System.out.print(teams.get(a)[3].getName() + ", ");
	System.out.println(teams.get(a)[4].getName());
	System.out.println();
	System.out.println("Team B is: ");
	System.out.print(teams.get(b)[0].getName() + ", ");
	System.out.print(teams.get(b)[1].getName() + ", ");
	System.out.print(teams.get(b)[2].getName() + ", ");
	System.out.print(teams.get(b)[3].getName() + ", ");
	System.out.print(teams.get(b)[4].getName());
	System.out.println();
}

public static void spitTeams(List<String[]> teams, int[] teamLocation){
	int a = teamLocation[0];
	int b = teamLocation[1];
	System.out.print(teams.get(a)[0]);
	System.out.print(", ");
	System.out.print(teams.get(a)[1]);
	System.out.print(", ");
	System.out.print(teams.get(a)[2]);
	System.out.print(", ");
	System.out.print(teams.get(a)[3]);
	System.out.print(", ");
	System.out.print(teams.get(a)[4]);
	System.out.println(" ");
	System.out.print(teams.get(a)[0]);
	System.out.print(", ");
	System.out.print(teams.get(b)[1]);
	System.out.print(", ");
	System.out.print(teams.get(b)[2]);
	System.out.print(", ");
	System.out.print(teams.get(b)[3]);
	System.out.print(", ");
	System.out.print(teams.get(b)[4]);
}


public static void main (String[] args) {
	//stuff
	String filePath = "C:/Users/Jae/Desktop/OPGG Crawler/ranks.csv";

        // init rank map
        HashMap rankMap = new HashMap<>();
        rankMap.put("Unranked", 1);
        rankMap.put("Bronze", 1);
        rankMap.put("Silver", 2);
        rankMap.put("Gold", 3);
		rankMap.put("Gold 4", 3);
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
	
	// big moods. big oof.
	int n = 5;
	System.out.println("");
	Person[] teams = {persons.get(0),persons.get(1),persons.get(2),persons.get(3),persons.get(4),persons.get(5),persons.get(6),persons.get(7),persons.get(8),persons.get(9)};
	ArrayList<Person[]> myList = new ArrayList<Person[]>();
	combinations(n, teams, myList);
}

// big thanks to stackoverflow for helping

}