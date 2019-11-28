import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Grid 
{
	private Ship battleship = new Ship();
	private Ship cruiser = new Ship();
	private Ship destroyer = new Ship();
	private Ship submarine = new Ship();
	
	String[][] grid = new String[10][10];
	String[][] userGrid = new String[10][10];
	int row;
	int col;
	
	/**
	 * Method to create the initial grid
	 */
	public void createGrid()
	{
		
		
		for (row=0; row<10; row++)
		{
			for (col=0; col<10; col++)
			{
				grid[row][col] = "*";
			}
		}
		
		/*for (row=0; row<10; row++)
		{
			for (col=0; col<10; col++)
			{
				System.out.print(grid[row][col] + " ");
			}
			System.out.print("\n");
		}*/
	}
	
	/**
	 * Method to set battleship fields
	 */
	public void setBattleships()
	{
		battleship.setBattleship();
	}
	
	/**
	 * Method to set cruiser fields
	 */
	public void setCruisers()
	{
		cruiser.setCruiser();
	}
	
	/**
	 * Method to set destroyer fields
	 */
	public void setDestroyers()
	{
		destroyer.setDestroyer();
	}
	
	/**
	 * Method to set submarine fields
	 */
	public void setSubmarines()
	{
		submarine.setSubmarine();
	}
	
	/**
	 * Method to get each ship and their fields
	 * 
	 * @param shipLength
	 * @param shipType
	 * @param noOfShips
	 */
	public void getAllShips(int shipLength, String shipType, int noOfShips)
	{
		int counter;
		shipLength = 0;
		shipType = null; 
		noOfShips = 0;
		
		for (counter=0; counter<4; counter++)
		{
			if (counter == 0)
			{
				shipLength = battleship.getShipLength();
				shipType = battleship.getShipType();
				noOfShips = battleship.getNoOfShips();
				placeShips(shipLength, shipType, noOfShips);
			}
			else if (counter == 1)
			{
				shipLength = cruiser.getShipLength();
				shipType = cruiser.getShipType();
				noOfShips = cruiser.getNoOfShips();
				placeShips(shipLength, shipType, noOfShips);
			}
			else if (counter == 2)
			{
				shipLength = destroyer.getShipLength();
				shipType = destroyer.getShipType();
				noOfShips = destroyer.getNoOfShips();
				placeShips(shipLength, shipType, noOfShips);
			}
			else if (counter == 3)
			{
				shipLength = submarine.getShipLength();
				shipType = submarine.getShipType();
				noOfShips = submarine.getNoOfShips();
				placeShips(shipLength, shipType, noOfShips);
			}
		}
	}
	
	/**
	 * Method to place all ships randomly on the grid
	 * 
	 * @param shipLength
	 * @param shipType
	 * @param noOfShips
	 */
	public void placeShips(int shipLength, String shipType, int noOfShips)
	{
			
		for (int i=0; i<noOfShips; i++)
			{
			
			boolean freeSpace;
				
			do
			{
				freeSpace = true;
				randomNumber();
			
				//System.out.print(col + " " + row + "\n");
			
				if (Math.random() < 0.5)
				{	
				
					if (col < 5)
					{	
						for (int j=0; j<shipLength; j++)
						{
							if (!"*".equals(grid[row][col+j]))
							{
								freeSpace = false;
								break;
							}
							else
							{
								freeSpace = true;
							}
						}
					
						if (freeSpace == true)
						{
							for (int j=0; j<shipLength; j++)
							{
								grid[row][col+j] = shipType;
							}
						}
					
					}
					else
					{
				
						for (int j=0; j<shipLength; j++)
						{
							if (!"*".equals(grid[row][col-j]))
							{
								freeSpace = false;
								break;
							}
							else
							{
								freeSpace = true;
							}
						}
					
						if (freeSpace == true)
						{
							for (int j=0; j<shipLength; j++)
							{
								grid[row][col-j] = shipType;
							}
						}
					}

			
				}
				else
				{
				
					if (row < 5)
					{
				
						for (int j=0; j<shipLength; j++)
						{
							if (!"*".equals(grid[row+j][col]))
							{
								freeSpace = false;
								break;
							}
							else
							{
								freeSpace = true;
							}
						}
					
						if (freeSpace == true)
						{
							for (int j=0; j<shipLength; j++)
							{
								grid[row+j][col] = shipType;
							}
						}
					
					}
					else
					{
					
						for (int j=0; j<shipLength; j++)
						{
							if (!"*".equals(grid[row-j][col]))
							{
								freeSpace = false;
								break;
							}
							else
							{
								freeSpace = true;
							}
						}
					
						if (freeSpace == true)
						{
							for (int j=0; j<shipLength; j++)
							{
								grid[row-j][col] = shipType;
							}
						}
					}
				
				

				}
			}
			while (freeSpace == false);
			
			//uncomment to view system ship placements
			/*for (row=0; row<10; row++)
			{
				for (col=0; col<10; col++)
				{
					System.out.print(grid[row][col] + " ");
				}
				System.out.print("\n");
			}
			System.out.print("\n");*/
			
			}
			
		}
		
	
	/**
	 * Method to generate a random coordinate
	 */
	public void randomNumber()
	{
		do
		{
		col = (int)(Math.random() * 10); //generates a random number between 0 and 0.9 then multiplies by 10 to give an integer between 0 and 9
		row = (int)(Math.random() * 10);
		}
		while (!"*".equals(grid[row][col]));
	}
	
	/**
	 * Method to set all ships
	 */
	public void setAll()
	{
		setBattleships();
		setCruisers();
		setDestroyers();
		setSubmarines();
	}
	

	/**
	 * Method to save the game to a file
	 */
	public void saveGame()
	{
	    FileOutputStream outputStream = null;
	    FileOutputStream outputStream2 = null;
        PrintWriter printWriter = null;
        PrintWriter printWriter2 = null;
        
        try
   		{
   			outputStream = new FileOutputStream("SavedUserBoard.txt");
   			outputStream2 = new FileOutputStream("SavedSystemBoard.txt");
            printWriter = new PrintWriter(outputStream); 
            printWriter2 = new PrintWriter(outputStream2);
            
            int row, col;
            
            for (row=0; row<10; row++) 
            {
            		for (col=0; col<10; col++) 
            		{
            			printWriter2.print(String.valueOf(grid[row][col] + " "));
            			//System.out.print(grid[row][col] + " ");
            			//printWriter2.print(grid[row][col] + " ");
            		}
            		System.out.print("\n");
            		printWriter2.println();
            }
            
           
            System.out.print("\n");
            
            for (row=0; row<10; row++) 
            {
            		for (col=0; col<10; col++) 
            		{
            			printWriter.print(String.valueOf(userGrid[row][col] + " "));
            			//System.out.print(userGrid[row][col] + " ");
            			//printWriter.print(userGrid[row][col] + " ");
            		}
            		System.out.print("\n");
            		printWriter.println();
            }

         
   		}
   		catch (Exception e)
   		{
   			System.out.println("Error: " + e);
   		}
   		finally
   		{
   			printWriter.close();
   			printWriter2.close();
   		}
        
	}
	
	/**
	 * Method to load a game from a file
	 */
	public void loadGame()
	{
		FileReader fileReader = null;
		FileReader fileReader2 = null;
	    BufferedReader bufferedReader = null;
	    BufferedReader bufferedReader2 = null;
	    
	    try
	    {
	    	fileReader = new FileReader("SavedUserBoard.txt");
	    	fileReader2 = new FileReader("SavedSystemBoard.txt");
	    	bufferedReader = new BufferedReader(fileReader);
	    	bufferedReader2 = new BufferedReader(fileReader2);
	    	
	    	String nextLine = bufferedReader.readLine();
	    	
	    	
		        for (int row=0; row<10; row++)
		        {
		        	String[] parts = nextLine.split(" ");
		        	for (int col=0; col<10; col++)
		        	{
		        		userGrid[row][col] = (parts[col]);
		        		System.out.print(userGrid[row][col] + " ");

		        	}
		        	System.out.print("\n");
		        	nextLine = bufferedReader.readLine();
		        }
		        String[] parts = nextLine.split(" ");
	    
	    	
		        
		        System.out.print("\n");
		        
		        String nextLine2 = bufferedReader2.readLine();

		        for (int row=0; row<10; row++)
		        {
		        	String[] parts2 = nextLine2.split(" ");
		        	for (int col=0; col<10; col++)
		        	{
		        		grid[row][col] = (parts2[col]);
		        		System.out.print(grid[row][col] + " ");

		        	}
		        	System.out.print("\n");
		        	nextLine2 = bufferedReader2.readLine();
		        }
		        String[] parts2 = nextLine2.split(" ");

		        
        }
        catch (Exception e)
   		{
   			System.out.println("Error: " + e);
   		}
	}

	/**
	 * Method to create the grid visible to the user
	 */
	public void userGrid()
	{
		for (row=0; row<10; row++)
		{
			for (col=0; col<10; col++)
			{
				userGrid[row][col] = "*";
			}
		}
		
		for (row=0; row<10; row++)
		{
			for (col=0; col<10; col++)
			{
				System.out.print(userGrid[row][col] + " ");
			}
			System.out.print("\n");
		}
		
		System.out.println("If you want to save and exit the game - type 123");
	}
	
	boolean gameOver = false;
	
	/**
	 * Method for user to guess where the ships are
	 */
	public void coordinateSelection()
	{
		
		do
		{
			
		userCoordinate();
		
		processUserGuess();
		
		outerloop:
		for (row=0; row<10; row++)
		{
			for (col=0; col<10; col++)
			{
				if ((grid[row][col] != "B") && (grid[row][col] != "C") && (grid[row][col] != "D" ) && (grid[row][col] != "S"))
                {
                	gameOver = true;
                }
				else
				{
					gameOver = false;
					break outerloop;
				}
			}
		}
		
		}
		while (gameOver == false);
		System.out.println("Game Over!");
		System.out.println("Congradulations, you have destroyed all enemy ships!");
		
	}
	
	boolean accepted;
	
	/**
	 * Method to receive the users coordinate 
	 */
	public void userCoordinate()
	{
		
		do
		{
		
		try
		{
				accepted = true;
				
				Scanner s1 = new Scanner(System.in);
				System.out.println("Select a colum from 0 to 9");
				col = s1.nextInt();
				
				if (col == 123)
				{
					saveGame();
					System.out.println("Your game has been saved!");
					exit();
				} 
				
				if ((!(col>=0)) && (!(col<=9)))
	            {
					accepted = false;
					System.out.print("Invalid input - please try again");
	            }
				
			
				Scanner s2 = new Scanner(System.in);
				System.out.println("Select a row from 0 to 9");
				row = s2.nextInt();
				
				if (row == 123)
				{
					saveGame();
					System.out.println("Your game has been saved!");
					exit();
				}
				
				if (!"*".equals(userGrid[row][col]))
				{
					accepted = false;
					System.out.println("Please try again!");
				}
				
			
		}
		catch (Exception e)
   		{
			accepted = false;
   			System.out.println("Please try again: " + e);
   		}
		
		}
		while (accepted == false);
	}
	
	/**
	 * Method to to check if the user has hit a ship
	 */
	public void processUserGuess()
	{
		userGrid[row][col] = grid[row][col];
		
		if (grid[row][col] != "*")
		{
			if (grid[row][col] == "B")
			{
			System.out.println("You have hit a Battleship!");
			}
			if (grid[row][col] == "C")
			{
			System.out.println("You have hit a Cruiser!");
			}
			if (grid[row][col] == "D")
			{
			System.out.println("You have hit a Destroyer!");
			}
			if (grid[row][col] == "S")
			{
			System.out.println("You have hit a Submarine!");
			}
			userGrid[row][col] = "H";
			grid[row][col] = "X";
		}
		else
		{
			System.out.println("You have missed!");
			userGrid[row][col] = "M";
		}
		
		for (row=0; row<10; row++)
		{
			for (col=0; col<10; col++)
			{
				System.out.print(userGrid[row][col] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.println("If you want to save and exit the game - type 123");
		System.out.print("\n");
	}
	
	
	
	/**
	 * Method to exit menu
	 */
	public static void exit() 
	{
		System.out.println("Game Over!");
		System.exit(0);
	}
	
	
	

}
