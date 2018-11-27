import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class CombinationA { 
 public static void combinations(int n, Person[] arr, List<Person[]> list) {
    
	
	// Calculate the number of arrays we should create
    int numArrays = (int)Math.pow(arr.length, n);
    // Create each array
    for(int i = 0; i < numArrays; i++) {
        list.add(new Person[n]);
    }
    // Fill up the arrays
    for(int j = 0; j < n; j++) {
        // This is the period with which this position changes, i.e.
        // a period of 5 means the value changes every 5th array
        int period = (int) Math.pow(arr.length, n - j - 1);
        for(int i = 0; i < numArrays; i++) {
            Person[] current = list.get(i);
            // Get the correct item and set it
            int index = i / period % arr.length;
            current[j] = arr[index];
        }
    }
	letsJam(list);
} 

 public static boolean checkDoublePlayer(int currentTeam, List<Person[]> teams){
	 //checks a team for dublicate player within itself
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
  //checks a team against another team
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
	//calculates ranked score of a team
	int x;
	x = teams.get(num)[0].getRank() + teams.get(num)[1].getRank() + teams.get(num)[3].getRank() + teams.get(num)[4].getRank() + teams.get(num)[2].getRank();
	return x;
}

public static boolean checkRankScore(int a, int b, List<Person[]> teams){
	//compares two ranked scores, returns false if their equal
	if(calcRankScore(a, teams) == calcRankScore(b, teams)){
			return true;
	}
	return false;
}

public static void printTeam(int a, List<Person[]> teams){
	//compares two ranked scores, returns false if their equal
	System.out.print(teams.get(a)[0].getName() + " ,");
	System.out.print(teams.get(a)[1].getName() + " ,");
	System.out.print(teams.get(a)[2].getName() + " ,");
	System.out.print(teams.get(a)[3].getName() + " ,");
	System.out.println(teams.get(a)[4].getName());
}

public static int[] compareFullSet(List<Person[]> teams){
	//this bad boy should go about doing everything
	int[] teamLocations = {0,0};
	ArrayList<Integer> noDupeLocations = new ArrayList<Integer>();
	int dupeCounted = 0;
	for(int dupeCounter = 0; dupeCounter < 99999; dupeCounter++){
		if(checkDoublePlayer(dupeCounter, teams)){
		 noDupeLocations.add(dupeCounter);
		 dupeCounted = dupeCounted + 1;
		}
	}
	System.out.println("Number of non dupes: ");
	System.out.println(noDupeLocations.size());
	
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
					System.out.println(teamLocations[0]);
					System.out.println(teamLocations[1]);
					return teamLocations;
				}
			}else{
			}
			
		}
	}
	System.out.println("no matches");
	return teamLocations;
}


public static void letsJam(List<Person[]> teams){
	int[] finalLocations = compareFullSet(teams);
	int a = finalLocations[0];
	int b = finalLocations[1];
	System.out.println("Team location A: " + finalLocations[0]);
	System.out.println("Team location B: " + finalLocations[1] + "\n");
	System.out.println("Here are the balanced teams: ");
	System.out.println("Team A is: ");
	System.out.print(teams.get(a)[0].getName() + ", ");
	System.out.print(teams.get(a)[1].getName() + ", ");
	System.out.print(teams.get(a)[2].getName() + ", ");
	System.out.print(teams.get(a)[3].getName() + ", ");
	System.out.println(teams.get(a)[4].getName());
	System.out.println("Team B is: ");
	System.out.print(teams.get(b)[0].getName() + ", ");
	System.out.print(teams.get(b)[1].getName() + ", ");
	System.out.print(teams.get(b)[2].getName() + ", ");
	System.out.print(teams.get(b)[3].getName() + ", ");
	System.out.print(teams.get(b)[4].getName());
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
	int n = 5;
	Person a1 = new Person("bob", 2);
	Person b2 = new Person("nancy", 1);
	Person c3 = new Person("steve", 0);
	Person d4 = new Person("jim", 1);
	Person e5 = new Person("jack", 1);
	Person f6 = new Person("al", 1);
	Person g7 = new Person("sarah", 0);
	Person h8 = new Person("carl", 1);
	Person i9 = new Person("jane", 0);
	Person j0 = new Person("sam", 1);
	Person[] teams = {a1, b2, c3, d4, e5, f6, g7, h8, i9, j0};
	ArrayList<Person[]> myList = new ArrayList<Person[]>();
	combinations(n, teams, myList);
}

//Big thanks to stackoverflow for helping

}




