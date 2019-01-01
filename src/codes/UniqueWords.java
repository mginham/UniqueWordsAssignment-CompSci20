package codes;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class UniqueWords {
	
	
	
	public static void main(String[] args) throws Exception {
		
		/// TODO: put into methods??? (would putting it into methods helps with the scanner issue??? probs not)
		
		File infile = new File("PeterPan.txt"); // written text
		File outfile = new File("words.txt"); // display window
		Scanner input = new Scanner(infile);
		PrintWriter output = new PrintWriter(outfile);
		
		String data = "";
		int counter = 0;
		int itemAdded = 0;
		boolean check = true;
		
		
		// calculate total word count of text
		while(input.hasNext())
		{
			data = input.next();
			counter++;
		}
		
		output.println("Total word count: " + counter + "\n");
		
		
		/// TODO: should this be seperate from the word counter, or combined?
		String[] wordSet = new String[counter];
		Scanner input2 = new Scanner(infile);
		
		// eliminate duplicate words, place unique words in wordSet[] array
		while(input2.hasNext())
		{
			data = input2.next().replaceAll("[^a-zA-Z ]", "").toLowerCase(); // remove any characters not a-z or A-Z
			check = true;
			
			for(int a = 0; a < counter; a++)
				if(data.equals(wordSet[a])) // if the data matches an item in the array, do not include it
				{
					/// TODO: eliminate puntuation (strings shouldn't be capitalized?)
					check = false;
					continue;
				}
			
			if(check) // if the data does not match any items, add it to the array
			{
				wordSet[itemAdded] = data;
				itemAdded++;
			}
		}
		
		for(int a = 0; a < counter; a++)
			if(wordSet[a] != null) // do not display any nulls from the array
				output.println(wordSet[a]); // display the final array
		
		output.close();
		
		System.out.println("Terminated"); // indicate the program has completed

	} // end main

}