import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static Scanner scanIn;
	private static int numOfTests;
	private static int n;
	private static ArrayList<Integer> nInt;
	
	private static void readNumberTests(){
		String scannedLine = scanIn.nextLine();
		numOfTests = Integer.parseInt(scannedLine);
	}
	
	private static void readN(){
		String scannedLine = scanIn.nextLine();
		n = Integer.parseInt(scannedLine);
	}
	
	private static void readAndStoreNIntegers(){
		String scannedLine = scanIn.nextLine();
		String[] temp = scannedLine.split(" ");
		for(int i=0; i<n; i++){
			nInt.add(Integer.parseInt(temp[i]));
		}
	}
	
	public static void main(String[] args) {
		scanIn = new Scanner(System.in);
		nInt = new ArrayList<Integer>();
		
		readNumberTests();
		for (int i=0; i<numOfTests; i++){
			readN();
			readAndStoreNIntegers();
		}
	}
	
}
