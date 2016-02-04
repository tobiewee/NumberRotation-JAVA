import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static Scanner scanIn;
	private static int numOfTests;
	private static int n;
	private static ArrayList<Integer> nInt;
	private static int highestCorrectPosition;
	private static int numRotateToHighestCorrectPos;
	
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
	
	private static boolean checkPosition(){
		/*
		 * Checks number int in correct position.
		 * Return true to flag that highest number of correct positions found.
		 * Return false if this is not highest number of correct positions. 
		 */
		int posChkr=1;
		int cntCorrectPos=0;
		for(int i=0; i<n; i++){
			if(nInt.get(i) == posChkr) cntCorrectPos++;
			posChkr++;
		}
		if(cntCorrectPos>highestCorrectPosition){
			highestCorrectPosition = cntCorrectPos;
			return true;
		}
		return false;
	}
	
	private static void rotateSeq(){
		int tmp = nInt.get(0);
		nInt.remove(0);
		nInt.add(n-1, tmp);
	}
	
	private static void findBestPositionToRotateTo(){
		boolean setNumToRotate=false;
		for(int j=0; j<n; j++){
			setNumToRotate = checkPosition();
			if(setNumToRotate){
				numRotateToHighestCorrectPos = j;
			}
			rotateSeq();
		}
	}
	
	private static void rotateSeqNTimes(int n){
		for(int k=0; k<n; k++){
			rotateSeq();
		}
	}
	
	private static void printSoln(ArrayList<Integer> soln){
		for(int i: soln){
			System.out.print(i);
			if(i == soln.get(soln.size()-1)){
				System.out.print('\n');
			}
			else{
				System.out.print(' ');
			}
		}
	}
	
	public static void main(String[] args) {
		scanIn = new Scanner(System.in);
		nInt = new ArrayList<Integer>();
		
		readNumberTests();
		for (int i=0; i<numOfTests; i++){
			nInt.clear();
			highestCorrectPosition = 0;
			numRotateToHighestCorrectPos = 0;
			
			readN();
			readAndStoreNIntegers();
			findBestPositionToRotateTo();
			rotateSeqNTimes(numRotateToHighestCorrectPos);
			printSoln(nInt);
		}
	}
	
}
