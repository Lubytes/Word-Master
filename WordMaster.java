/*This program is to satisfy part 2 of the
 * CSCI 1100 end of the term project.
 * It was programmed by Brandon Poole and Raistlin Hume
 */
import java.util.Random;
import java.util.Scanner;
public class WordMaster {
	public static void main (String[]args){
		Scanner kb = new Scanner(System.in);

	
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