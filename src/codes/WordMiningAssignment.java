package codes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class WordMiningAssignment {
    
    
    public static File infile = new File("PeterPan.txt"); // written text
    public static File outfile = new File("words.txt"); // display window
    
    public static String word = "";
	public static int counter = 0;
	public static int itemAdded = 0;
	public static boolean check = true;
	public static String[] wordElimination = new String [word.length()];
    public static char placeholder = 1;
    
    
    
    
	// calculate total word count of text
    public static int wordCounter() throws Exception
    {
   	 Scanner input1 = new Scanner(infile);
   	 
   	 while(input1.hasNext())
    	{
        	word = input1.next();
        	counter++;
    	}
   	 
   	 return counter;
    }
    
    public static String[] eliminateUnwanted() throws Exception
    {
   	 Scanner input2 = new Scanner(infile);
   	 
   	 String[] uniqueWords = new String[counter];
   	 
   	 int increment = 0;
   	 
   	 while(input2.hasNext())
   	 {
   		 word = input2.next();
   		 check = true;
   		 
   		 char[] placeholder = word.toCharArray();
   		 
   		 for(int a = 0; a < word.length(); a++)
   			 if(placeholder[a] < 97 || placeholder[a] > 122)
   			 {
   				 check = false;
   				 continue;
   			 }
   		 
   		 for(int a = 0; a < counter; a++)
   			 if(word.equals(uniqueWords[a]))
   			 {
   				 check = false;
   				 continue;
   			 }
   		 
   		 
   		 if(check)
   			 uniqueWords[increment++] = word;
   	 }
   	 
   	 return uniqueWords;
    }

    
	public static void main(String[] args) throws Exception {
       	 
   	 PrintWriter output = new PrintWriter(outfile);
   	 
   	 // Count total words in text
        	wordCounter();
       		 output.println("Total word count: " + counter + "\n");
       	 
    	// Eliminate duplicate words, words with punctuation or capitalization
        	String[] uniqueWords = eliminateUnwanted();
       	 
    	// Print out unique words
        	for(int a = 0; a < counter; a++)
       		 if(uniqueWords[a] != null)
       			 output.println(uniqueWords[a]);
       		 
        	output.close();
       	 
        	System.out.print("Terminated"); // indicate the program has completed

    	} // end main

	}