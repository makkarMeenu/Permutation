import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Permutations {
	//stored input from CSV in arraylist
	static ArrayList<String> arr=new ArrayList<String>();
	
	//function to read input from CSV and store in arrayList;
	static boolean readCSV(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("./input.csv"));
            while (true) {
            			String line=br.readLine();
            			if(line==null)
            				break;
            			//parsing , removing ',' and double quotes
            			line=line.replaceAll(",", "");
            			line=line.replaceAll("\"", "");
            			arr.add(line);
            }
			}catch(Exception e){
				//if any error occurs , filnotfound or error while reading then return false
				return false;
			}
		return true;
	}
	
	static boolean permutations(int a, String s) {
		try {
		for(int k=0;k<arr.get(a).length();k++) {
			String newS=s+arr.get(a).charAt(k);
			if(a+1<arr.size())
				permutations(a+1,newS);
			else
				System.out.println(newS+" ");
		}
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static void main(String args[]) {
		
		
		//main function clean
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter filepath (default input.csv)\n use Enter for default.");
		String fileName=scan.nextLine();
		if(!readCSV(fileName))
				System.out.println("Error while Reading File!!!!!!");
			if(!permutations(0, ""))
				System.out.println("Error While computing!!!!!");
	}
	
}
