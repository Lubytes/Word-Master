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
		int i = 0, md;//The random number
		int x = word.length;//Used for the random #
		String ans;
		int score1 = 0;
		boolean b;



		System.out.print("Welcome to the anagram section!"
				+ "\nCapitals are not used, so don't worry about having a lowercase at the beginning of a word! "
				+ "\nPlease type 0 to get a definition of what an anagram is, or type anything else to start!");
		md=kb.nextInt();
		
		if(md==0)
			anagDef();
		
		System.out.println("Let's begin!");	
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
		Random rnd=new Random();
		boolean k;
		int l=0;
		int m=0;
		int w=0;
		int length = 0;
		
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

		String [] scolon = {"Some people dance[] others sing.", "The sock is green; it is also smelly.", "I like Jim; however, he does smell"
				, "Pickles are tasty; they're also green."};

		String [] apos = {""};
		
		String [] ques = {""};

		int a = 2;//period
		int b = 2;//comma
		int c = 2;//scolon
		int d = 2;//apos
		int e = 2;//ques
		int [] f = new int[2];//a
		int [] g = new int[2];//b
		int [] h = new int[2];//c
		int [] i = new int[2];//d
		int [] j = new int[2];//e
		int [] test = {};
		//counts 10 questions
		for (int z = 0; z<10; z++){
			k = true;
			//Choose which section (none more than twice!)
			while(k == true){
				m = rnd.nextInt(4);
				if(m==0 && a>0){
					test = f;
					a--;
					w=a;
					k=false;
				}
				else if(m==1 && b>0){
					test = g;
					b--;
					w=b;
					k=false;
				}
				else if(m==2 && c>0){
					test = h;
					c--;
					w=c;
					k=false;
				}
				else if(m==3 && d>0){
					test = i;
					d--;
					w=d;
					k=false;
				}
				else if(m==4 && e>0){
					test = j;
					e--;
					w=e;
					k=false;
				}
			}
			//Makes sure words are not re-used
			while(k == false){
				k = true;
				l = rnd.nextInt(test.length);//length of chosen section
				for(int y = 0; y<2; y++){
					if(l == (test[y]))
						k = false;
				}
			}

			test[w]=l;
			
			//Ask question and record answer here
		}
		
		
		
		return 0;
	}

	public static int homon(){
		//Have a sentence vault, choose 10 or so at random. (multi choice)

		Scanner kb = new Scanner(System.in);
		Random rnd = new Random();
		int i = 0, md = 0;
		String ans, ansCheck = null;
		int score2 = 0;

		//There
		String[] homonArr = {"Let us go [].", "Can we go [] later?", "[] was two dogs.", "Today, [] is no class. "
				, "Jack is over [] with Sally.", "[] once was a man named Xavier.", "Jimmy fell down the well over []."
				, "[] isn't any time to explain!", "Why is [] no pizza left?", "The storm was bad [], but everyone made it to safety."
				//Their
				, "The team did [] best at the competition.", "I like [] photo album.", "[] dog is a real trouble maker!"
				, "We should borrow [] hammer!", "I should ask for [] approval of the project.", "[] home town is in Nova Scotia."
				, "The family next door has a problem. [] goldfish is sick.", "If they want our cookies, [] hamburgers are ours."
				, "[] house looks so good this time of year!", "That school is neat. [] mascot is a goat."
				//They're
				, "[] preparing for battle.", "Go find out what [] up to.", "[] happy."
				, "That is what [] doing?", "I hope [] having fun.", "[] moving in on Friday."
				, "[] so annoying.", "The team is doing well. [] training hard."
				, "[] at school with Billy.", "Charlie went to find out where [] living."
				//Your
		        , "[] dog is awesome.", "Can I borrow [] pencil?", "[] day tomorrow is going to be busy."
				, "Can I meet [] family?", "I went to regionals with [] school.", "[] friends say I'm no fun."
				, "When are we going to [] house?", "Let's do things [] way!", "In the end [] robot was better."
				, "Lets get [] assignment out of the way."
				//You're
				, "[] way too good for this class!", "Can I see [] grade on this test?"
				, "At this rate, [] going to fail the assignment.", "[] just like Ted from gym last year!"
				, "I'm just going to pretend [] the best baker.", "Aww, [] so sweet for getting me this!"
				, "My friend said [] great at drawing!", "On behalf of the kingdom, [] hereby being knighted."
				, "When it is midnight, [] to head home.", "[] so lucky to have such great friends!"
				//too
				, "There are [] many things.", "I baked [] many cakes.", "The sky is [] blue."
				, "The cold is [] much for me.", "The beach has [] many grains of sand."
				, "The sun is [] bright.", "You are running [] fast.", "The cookies are [] high for me to reach."
				, "Don't get [] close to the fire."
				, "It is [] wet outside to play." 
				//to
				,"I went [] the store.", "There is time [] read this book."
				, "We can fly [] to the moon.  "
				, "It would take years [] count grains of sand on the beach."
				, "Lets go [] the mall.", "We can go outside [] play."
				, "I brought my books [] school.", "We have [] share."
				, "The wolf walked [] the woods.", "There is a path [] grandma's house."
		};
		
		String[] answers={"there","their","they're","your","you're","too","to"};
		
		System.out.print("Welcome to the homonyms section!"
				+ "\nCapitals are not used, so don't worry about having a lowercase at the beginning of a word! "
				+ "\nYour objective will be to use the correct form of the word for the given sentence"
				+ "\nPlease type 0 to get a definition of what an homonym is, or type anything else to start!");
		md=kb.nextInt();
		if(md==0)
			homonDef();
		
		System.out.println("Let us begin!");
		
		int[] questions=questionSelect(homonArr.length);
		for(i=0;i<10;i++){
			System.out.println(homonArr[questions[i]]);
			if(questions[i]<=30){
				System.out.println("Choices: there - their - they're");
			} else if (questions[i]<=50){
				System.out.println("Choices: your - you're");
			} else if (questions[i]<=70){
				System.out.println("Choices: too - to");
			}
			System.out.print("Please enter your word: ");
			ans=kb.nextLine();
			
			if((questions[i])/10==0){
				ansCheck="there";
			} else if((questions[i])/10==1){
				ansCheck="their";
			} else if((questions[i])/10==2){
				ansCheck="they're";
			} else if((questions[i])/10==3){
				ansCheck="your";
			} else if((questions[i])/10==4){
				ansCheck="you're";
			} else if((questions[i])/10==5){
				ansCheck="too";
			} else if((questions[i])/10==6){
				ansCheck="to";
			}
			
			if(ans.equals(ansCheck)){
				System.out.println("That is correct!");
				score2++;
			} else {
				System.out.println("That is incorrect. The word we were looking for was: "+ansCheck);
			}
		}

		return score2;
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

	public static void anagDef(){
		int i;
		Scanner kb=new Scanner(System.in);

		System.out.println("An anagram is a word that has its letters in a random order."
				+ "\nYour job is to state the correct order of the word.\n");
		System.out.println("Please type 1 for some examples, or anything else to go back: ");
		i=kb.nextInt();

		if(i==1){
			System.out.println("faelm=flame\ndor=rod\ncjkas=jacks\niplto=pilot\ncarcare=racecar\n");
		} 
	}

	public static void homonDef(){
		int i;
		Scanner kb=new Scanner(System.in);

		System.out.println("A homonym is a word pronounced the same as another "
				+ "but differing in meaning, whether spelled the same way or not, "
				+ "as heir and air; a homophone");
		System.out.println("Please type 1 for some examples, or anything else to go back: ");
		i=kb.nextInt();

		if(i==1)
			System.out.println("Which and witch\ncite, sight and site\ndew, do and due\n");

	}
}
