package com.example;
import java.util.Random;
import java.util.Scanner;

import com.example.character.Archer;
import com.example.character.Berserker;
import com.example.character.Warlock;
import com.example.character.Warrior;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Game {
	protected static Object enemy;
	private static Random generator =new Random();

	/**
	 *  It is the general fight function . It checks character is live or not and set
	 *  our character life status after fight
	 * @param enemy
	 * @param character
	 */
	
	protected void fight(Character enemy, ICharacter character, String nickname) {

		while (enemy.isLifeStatus() == true && character.isLifeStatus() == true) {
			attack( enemy, character);
		}
		
		if(character.isLifeStatus()) {
			character.reset();
			character.setScore(character.getScore() + 5); 
		}
		else {
			System.out.println("You dead!" +"\n" + "Your score is: " + character.getScore());
			if(character.getScore()>5) {    // If score is higher than 5pts name and score write in hall of fame text file
			hallOFfame(character, nickname);
			}
		}
	}
	
	/**
	 * this function used for to decide which character will start fight and who will use combo attack
	 * @param attacker
	 * @param victom
	 */

	protected  void attack(ICharacter attacker, ICharacter victom) {
		int select =(int)(generator.nextDouble()*2);
		//System.out.println(select);
		int combo =(int)(generator.nextDouble()*8);
		
		if(select == 0) {
			victom.setHealth(victom.getHealth() - (attacker.getDamage() - victom.getArmor()));
			System.out.println("victom health:"+ victom.getHealth()+ " "+"damage:"+ victom.getDamage() +" "+ "life status:" + victom.isLifeStatus());
			if(victom.isLifeStatus() == true && attacker.isLifeStatus() == true) {
			attacker.setHealth(attacker.getHealth() - (victom.getDamage() - attacker.getArmor()));
			System.out.println("attacker health:"+ attacker.getHealth()+" " +"damage:"+ attacker.getDamage()+ " "+"life status:"+ attacker.isLifeStatus());
			}
			if(combo == 0) {
				victom.setHealth(victom.getHealth() - attacker.comboAttack());
				System.out.println("attacker combo:  " + attacker.comboAttack() );
			}else if(combo == 8) {
				attacker.setHealth(attacker.getHealth() - victom.comboAttack());
				System.out.println("victom combo:  " + victom.comboAttack() );
			}			
			
		}
		else {
			attacker.setHealth(attacker.getHealth() - (victom.getDamage() - attacker.getArmor()));
			System.out.println("attacker health:"+ attacker.getHealth()+" " +"damage:"+ attacker.getDamage()+ " "+"life status:"+ attacker.isLifeStatus());
			if(victom.isLifeStatus() == true && attacker.isLifeStatus() == true) {
			victom.setHealth(victom.getHealth() - (attacker.getDamage() - victom.getArmor()));
			System.out.println("victom health:"+ victom.getHealth()+ " "+"damage:"+ victom.getDamage() +" "+ "life status:" + victom.isLifeStatus());
			}
			if(combo == 8) {
				attacker.setHealth(attacker.getHealth() - victom.comboAttack());
				System.out.println("victom combo:  " + victom.comboAttack() );
			}else if(combo == 0) {
				victom.setHealth(victom.getHealth() - attacker.comboAttack());
				System.out.println("attacker combo:  " + attacker.comboAttack() );

			}
			
			
			
		}
		
		
	}
	/**
	 * enemyGenerate is the function that generating a enemy(randomly) and create enemy class
	 * @return
	 */
	
	protected  Character enemyGenerate() {
		Character enemy = null;
		String name = null;
		int r = (int) (Math.random() * 4);
		if (r == 0) {
			enemy = new Berserker();
			name = "Berserker";
		} else if (r == 1) {
			enemy = new Warlock();
			name = "Warlock";
		} else if (r == 2) {
			enemy = new Warrior();
			name = "Warrior";
		} else if (r == 3) {
			enemy = new Archer();
			name = "Archer";
		}
		System.out.println("Your enemy is: " + name + "\n"
		+"Your enemy status:"+"	"+ enemy.toString() );
		return enemy;

	}
	
	/**
	 * charSelect is the function that we choose our character and it creates our class
	 * @param characterSelect
	 * @return
	 */
	
	protected  Character charSelect( int characterSelect) {
		Character character = null;
		if (characterSelect == 1) {
			character = new Berserker();
		} 
		else if (characterSelect == 2) {
			character = new Warlock();
		} 
		else if (characterSelect == 3) {
			character = new Archer();
		}
		else if (characterSelect == 4) {
			character = new Warrior();
		}
		else {
			System.out.println("Invalid chose!");
		}
		return character;
	}
	
	/**
	 *  Creating hallOFfame.txt and it checks file exist or not
	 *  Updating list
	 * @param character
	 * @param nickname
	 */

	public  void hallOFfame(ICharacter character,String nickname) {
		
	    try {
	      FileWriter myWriter = new FileWriter("fame.txt",true);
	      myWriter.write(nickname +"	"+"score:" +"	"+ character.getScore());
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	

	protected  void menu() {
		System.out.println("1. Choose character");
		System.out.println("2. Status of your character");
		System.out.println("3. Find enemy");
		System.out.println("4. Hall of fame");
		System.out.println("5. Help");
		System.out.println("6. Exit the game!");
	}
	
	/**
	 * Reading help.txt and printing screen
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	
	protected  void help() throws NumberFormatException, IOException {
		FileReader file = new FileReader("help.txt");
		Scanner scan = new Scanner(file);		
		while(scan.hasNextLine()) {
			String data = scan.nextLine();
			System.out.println(data);		
			}		
		scan.close();
	}	
	
	
	
	/**
	 * Updating hall of fame list
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	
	protected  void hallOF() throws NumberFormatException, IOException {
		FileReader file = new FileReader("fame.txt");
		Scanner scan = new Scanner(file);		
		while(scan.hasNextLine()) {
			String data = scan.nextLine();
			System.out.println(data);		
			}		
		scan.close();
	}





}
	
