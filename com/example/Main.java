/*******************
 * 
 * @author Oðuz Esirik
 * 
 */
package com.example;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your nickname: "); 
		String nickname = scanner.nextLine();
		System.out.println("Hello   " + nickname + "\n" + "Please first chose your character" );
		System.out.println("*********************************");
		Character character = null;
		Character enemy = null;
		Game game = new Game();
		
		Boolean status = true;
		while (status == true) {
			game.menu();
			int selection=0;
			try {
				 selection = scanner.nextInt();
				 
			}catch(InputMismatchException e) {
				
				System.out.println("Invalid chose! Chose again please");
				scanner.next();
				continue;
			}
			
			if (selection == 1) {
				System.out.println("1.Berserker 2.Warlock 3.Warrior 4.Archer");
				try {
				int characterSelect = scanner.nextInt();
				character = game.charSelect(characterSelect);
				}
				catch(InputMismatchException e) {
					System.out.println("Invalid chose! Chose again please");
					scanner.next();
					continue;
				}
			} 
			else if (selection == 2) {
				if(character != null) {
				System.out.println("*********************************");
				System.out.println(character.toString());
				System.out.println("Your score is: " + character.getScore());
				System.out.println("*********************************");
				}
			
			else {
				System.out.println("Please first choose your character");
			}
		}
			else if (selection == 3) {
				if(character != null && character.getHealth()> 0 ) {
				enemy = game.enemyGenerate();
				game.fight(enemy, character,nickname);
				}
				else {
					System.out.println("Please first choose your character");
				}
			} 
			else if (selection == 4) {
				game.hallOF();
			}
			else if(selection == 5) {
				game.help();
			}
			else if(selection == 6) {
				status = false;
				scanner.close();
				break;
			}
			else {
				System.out.println("Invalid chose! Chose again please");
			}

		}

	}



}