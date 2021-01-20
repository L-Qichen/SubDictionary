//-----------------------------------------------------
// Assignment 4
// Question: part 1
// Written by: Liu Qichen(ID:40055916)
// -----------------------------------------------------
/**
 * Name and ID: Liu Qichen and 40055916
 * COMP249
 * Assignment 4
 * Due Date: 2/12/2019
 * 
 * 
 * @author Liu Qichen
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SubDictionary {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=null;
		String fName;
		ArrayList<String> words=new ArrayList<String>();
		String word;
		char[] letters= {'l','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int i = 0;
		System.out.println("Please enter the name of the input file: ");
		fName=sc.nextLine();
		try {
			sc=new Scanner(new FileInputStream(fName));
			pw=new PrintWriter(new FileOutputStream("SubDictionary.txt"));
		}catch(FileNotFoundException e){
			System.out.println("Cannot find this File, the program will exit immediately.");
			System.exit(0);
		}
		//read words one by one from the input file and add them to the arraylist
		while(sc.hasNext()) {
			word=sc.next().toUpperCase();
			if(!words.contains(word)) {
				if(word.indexOf("?")>=0) {
					word=word.substring(0,word.indexOf("?"));
				}
				if(word.indexOf(":")>=0) {
					word=word.substring(0,word.indexOf(":"));
				}
				if(word.indexOf("'")>=0) {
					word=word.substring(0,word.indexOf("'"));
				}
				if(word.indexOf("’")>=0) {
					word=word.substring(0,word.indexOf("’"));
				}
				if(word.indexOf("�")>=0) {
					word=word.substring(0,word.indexOf("�"));
				}
				if(word.indexOf(",")>=0) {
					word=word.substring(0,word.indexOf(","));
				}
				if(word.indexOf("=")>=0) {
					word="";
				}
				if(word.indexOf(";")>=0) {
					word=word.substring(0,word.indexOf(";"));
				}
				if(word.indexOf("!")>=0) {
					word=word.substring(0,word.indexOf("!"));
				}
				if(word.indexOf(".")>=0) {
					word=word.substring(0,word.indexOf("."));
				}
				if(word.indexOf("0")>=0||word.indexOf("1")>=0||word.indexOf("2")>=0
						||word.indexOf("3")>=0||word.indexOf("4")>=0||word.indexOf("5")>=0
						||word.indexOf("6")>=0||word.indexOf("7")>=0||word.indexOf("8")>=0
						||word.indexOf("9")>=0) {
					word="";
				}
				if(word.length()==1) {
					if(word.equals("A")) {
						word="A";
					}
					else if(word.equals("I")) {
						word="I";
					}
					else {
						word="";
					}
				}
				if(word!=""&&!words.contains(word))
					words.add(word);
				}
		}
		System.out.println("The document produced this sub-dictionary, which includes "+words.size()+" entries.");
		pw.println("The document produced this sub-dictionary, which includes "+words.size()+" entries.");
		words.sort(null);
		//write to the output file
		
		//for loop use to read every elements in the arraylist
		for(String s:words) {
			//if the initial letter of the word is not equal to 
			//the letter from letters array, the program will execute to
			//the second for loop and add a capital letter as an indication 
			//in front of this group of words.
			//if the initial letter of the word is equal to the letter
			//from letters array, the program will skip the second for loop
			//so, the indication letter will only add once to each group
			//For add 'A' as an indication letter to the first group, we must
			//store 'A' as the second element in the letters array(letters[1]),
			//otherwise, the if condition will return false,
			//then the second for loop will not be execute.
			if(s.charAt(0)!=letters[i]) {
			for(i=0;i<letters.length;i++) {
				if(s.charAt(0)==letters[i]) {
					pw.println("\n\n"+letters[i]+"\n==");
					break;
				}
			}
		}
			pw.println(s);
		}
		
		sc.close();
		pw.close();
	}

}
