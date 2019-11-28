import java.util.Scanner;

/**
 * 
 */

/**
 * @author amygourlay
 *
 */
public class Menu 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		 // TODO Auto-generated method stub
		
		Menu test = new Menu();
		test.processUserChoices(0);
		
	}
	
	/**
	 * Method to display a menu
	 */
	public void displayMenu()
	{
		System.out.println("Please select one of the options below");
		System.out.println("1. Start Game");
		System.out.println("2. Load Game");
		System.out.println("3. Save Game");
		System.out.println("4. Quit Game");
	}
	
	/**
   	 *Method to process the users input and call the appropriate method from the Grid class 
   	 *
   	 * @param userChoice
   	 */
   	public void processUserChoices(int userChoice) 
   	{
   		
   		do 
   		{
   		
   		Scanner s1 = new Scanner(System.in);
   		displayMenu();
   		userChoice = s1.nextInt();
   		
   		
   			if (userChoice == 1) 
   			{
   				Grid test = new Grid();
   				test.createGrid();
   				test.setAll();
   				test.getAllShips(0, null, 0);
   				test.userGrid();
   				test.coordinateSelection();
   			}
   			
   			else if (userChoice == 2) 
   			{
   				Grid test = new Grid();
   				test.loadGame();
   				test.coordinateSelection();
   			}
   			
   			else if (userChoice == 3) 
   			{
   				Grid test = new Grid();
   				test.saveGame();
   			}
   			
   			else if (userChoice == 4) 
   			{
   				Grid.exit();
   			}
   			else 
   			{
   				System.out.println("Invalid entry - please try again");
   				System.out.print("\n");
   			}
   			
   		}
   		while (userChoice != 4);
   	}
}
   		
   		
   		
   		
   		
   		
   		
   		
