/*This program is to satisfy part 2 of the
 * CSCI 1100 end of the term project.
 * It was programmed by Brandon Poole and Raistlin Hume
 */
import java.util.Random;
import java.util.Scanner;
public class WordMaster {
	public static void main (String[]args){
		Scanner kb = new Scanner(System.in);
		//a = anagrams, b = punctuation, c = homonyms
		int a = 1, b = 2, c = 3;
		
		//Introduction
		System.out.println("Hello user! What is your name?");
		String name = kb.nextLine();
		System.out.println("Well, " + name + " we're going to go over some basic English skills. "
				+ "\nWould you like to start with anagrams(1), punctuation(2), or homonyms(3)?"
				+ "\nPlease type the number that corresponds with the section."
				+ "\nRemember that you may not do a section more than once.");
		int s = kb.nextInt();
		
		//Section 1
		if (s == a){
			int score1 = anag();
			a = 0;
		}
		else if (s == b){
			int score2 = punc();
			b = 0;
		}
		else if (s == c){
			int score3 = homon();
			c = 0;
		}
		else
			System.out.println("You have already completed that section");

	}
	public static int anag(){
		//Have a word vault, scramble words using a scrambler we design. (input and check if String equals)
			
			Scanner kb = new Scanner(System.in);
			Random rnd = new Random();
			int i = 0;
			String ans;
			int score1 = 0;
			boolean b;
			int [] test = new int[10];

			String [] word = {"hello", "goodbye", "greetings", "helpful", "cheese", "amazing", "question", "forever"
								+ "remote", "board", "white", "black", "colour", "green", "yellow", "orange", "fun" 
								+ "one", "two", "three", "four", "five", "six", "seven", "eight", "excellent"};
			
			System.out.print("Welcome to the anagram section! An anagram is a word that has its letters in a random order."
			+ "\nYour job is to state the correct order of the word."
			+ "\nCapitals are not used, so don't worry about having a lowercase at the beginning of a word! ");
			
			//counts 10 questions
			for (int z = 0; z<10; z++){
				b = false;
				//Makes sure words are not re-used
				while(b == false){
					b = true;
					i = rnd.nextInt(25);//# of words-1
					for(int y = 0; y<10; y++){
						if(i == (test[y])){
							b = false;
						}
					}
				}
				test[z]=i;
				
				System.out.print("Your word is: ");
				//Sends the randomly picked word to be scrambled
				scram(word[i]);
				System.out.print("\nState the ordered word: ");
				//Incase they put in a capital letter
				ans = kb.nextLine().toLowerCase();
				if (ans.equals(word[i])){
					System.out.println("That is correct! ");
					score1++;
				}
				else
					System.out.println("This is incorrect.\nThe answer we were looking for was " + word[i]);
			}
				
				
				
			return score1;
		}
	
	public static void scram(String word){
	//Word Scrambler
		Random rnd = new Random();
		int length = word.length();
		int [] sword = new int [length];
		boolean b; //Test to see if char was used yet
		int i; //The random number
		int x = 0;
		//x is only increased if a letter is successfully printed
		while(x<(length)){
			i = rnd.nextInt(length);
			b = false;
			//y tests all currently stored values so no letter is
			//printed more than once
			for(int y = 0; y<(length)-1; y++){
				if(i == (sword[y])){
					b = true;
				}
			}
			if(x!=0 || i!=0 ){ //So the first letter cannot be printed first
				if (b == false){
					System.out.print(word.charAt(i));
					sword[x] = i;
					x++;
				}
			}
		}
	}
	public static int punc(){
	//Have a sentence vault, choose 10 or so at random. (multi choice)
	//Choose between . , ; ' and ?
		
		//First 20 will be . The next 20 will be , and so on
		String [] question = {"The dog says woof[ ]", "The cat says meow[ ]", "I like cheese[ ]", "I went for a walk[ ]", "Hit the ball with the paddle[ ]"
		+ "It's fun to run[ ]", "School is where you learn[ ]", "Don't run with scissors[ ]", "It is sunny outside today[ ]", "Hit the ball with the bat[ ]" //Periods
		+ ""};
		
		
		
		
		
		return score2;
	}
	public static int homon(){
	//Have a sentence vault, choose 10 or so at random. (multi choice)
		
		
		
		return score3;
	}
}