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
		System.out.println("Hello user! What is your name? ");
		String name = kb.nextLine();
		System.out.println("Well, " + name + " we're going to go over some basic English skills. "
				+ "\nWould you like to start with anagrams(1), punctuation(2), or homonyms(3)?"
				+ "\nPlease type the number that corresponds with the section."
				+ "\nRemember that you may not do a section more than once.");
		int s = kb.nextInt();

		//Section 1
		if (s == a){
			int score1 = anag();
			System.out.print("Your score was " + score1 +"/10");
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
		String [] word = {"hello", "goodbye", "greetings", "helpful", "cheese", "amazing", "question", "forever"
				, "remote", "board", "white", "black", "colour", "green", "yellow", "orange", "fun" 
				, "one", "two", "three", "four", "five", "six", "seven", "eight", "excellent"};
		Scanner kb = new Scanner(System.in);
		Random rnd = new Random();
		int i = 0;//The random number
		int x = word.length;//Used for the random #
		String ans;
		int score1 = 0;
		boolean b;
		

		
		System.out.print("Welcome to the anagram section! An anagram is a word that has its letters in a random order."
				+ "\nYour job is to state the correct order of the word."
				+ "\nCapitals are not used, so don't worry about having a lowercase at the beginning of a word!\n");
		
		//counts 10 questions
		int [] test = questionSelect(x);
		for (int z = 0; z<10; z++){
			
			i = test[z];

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
		boolean b; //Test to see if char place was used yet
		int i; //The random number
		int x = 0;
		//x is only increased if a letter is successfully printed
		while(x<length){
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
		String [] period = {"The dog says woof[ ]", "The cat says meow[ ]", "I like cheese[ ]", "I went for a walk[ ]", "Hit the ball with the paddle[ ]"
				, "It's fun to run[ ]", "School is where you learn[ ]", "Don't run with scissors[ ]", "It is sunny outside today[ ]", "Hit the ball with the bat[ ]" 
				, "Rain is no fun[]", "It's good to have a healthy breakfast[]", "Lunch is my favourite meal of the day[]", "English is confusing[]", "Learning is fun[]"
				, "Cows go moo[]", "Siblings are annoying[]", "Nanny makes cookies[]", "Sports are fun[]", "Computer Science is the best faculty[]"
				, "Chocolate is my favourite food[]"};
		
		String[] comma = {"The best colours are blue[] green[] and red.", "She is a young[] pretty girl."
				, "He is a strong[] handsome man.", "After eating lunch and walking home[] she had a nap." , "Yes[] Burt[] I will.", "He was happy[] however[] annoyed."
				, "Let's eat[] grandma.", "Joh walked into the room[] ate cheese[] and left.", "On the floor were laying pants[] shoes[] and a shirt."
				, "I am from Halifax[] Nova Scotia.", "Darling[] where is the cheese?", "Tim is a fine husband[] friend[] and employee."
				, "He walked into the store[] looked around[] and left.", "I've been to Mexico[] Quebec[] and France", "Jim's backpack is blue[] green[] and pink."
				, "Hotchocolate is made of water[] sugar[] and cocoa.", "John ate twelve slices of pizza[] two salads[] and drank five glasses of milk."
				, "The colours of the American flag are red[] white[] and blue."};





		return 0;
	}
	public static int homon(){
		//Have a sentence vault, choose 10 or so at random. (multi choice)



		return 0;
	}

	public static int[] questionSelect(int length){
		boolean b;
		int i=0;

		Random rnd=new Random();
		int [] test = new int[10];
		//counts 10 questions
		for (int z = 0; z<10; z++){
			b = false;
			//Makes sure words are not re-used
			while(b == false){
				b = true;
				i = rnd.nextInt(length);
				for(int y = 0; y<z; y++){
					if(i == (test[y])){
						b = false;
					}
				}
			}

			test[z]=i;
		} return test;
	}
}
