/**
 * 
 */

/**
 * @author amygourlay
 *
 */
public class Ship {

	private String shipType;
	private int shipLength;
	private int noOfShips;
	
	public Ship()
	{
		shipType = null;
		shipLength = 0;
		noOfShips = 0;
	}
	
	/**
	 * Method to get the type of ship
	 * 
	 * @return shipType
	 */
	public String getShipType()
	{
		return shipType;
	}
	
	/**
	 * Method to set the type of ship
	 * 
	 * @param shipType
	 * @return String containing the type of ship
	 */
	public void setShipType(String shipType)
	{
		this.shipType = shipType;
	}
	
	/**
	 * Method to get the length of ship
	 * 
	 * @return shipLength
	 */
	public int getShipLength()
	{
		return shipLength;
	}
	
	/**
	 * Method to set the length of ship
	 * 
	 * @param shipLength
	 * @return integer containing the length of ship
	 */
	public void setShipLength(int shipLength)
	{
		this.shipLength = shipLength;
	}
	
	/**
	 * Method to get the number of ships
	 * 
	 * @return noOfShips
	 */
	public int getNoOfShips()
	{
		return noOfShips;
	}
	
	/**
	 * Method to set the number of ships
	 * 
	 * @param noOfShips
	 * @return integer containing the number of ships
	 */
	public void setNoOfShips(int noOfShips)
	{
		this.noOfShips = noOfShips;
	}
	
	/**
	 * Method to set the battleship information
	 */
	public void setBattleship()
	{
		shipType = "B";
		shipLength = 4;
		noOfShips = 1;
	}
	
	/**
	 * Method to set the cruiser information
	 */
	public void setCruiser()
	{
		shipType = "C";
		shipLength = 3;
		noOfShips = 2;
	}
	
	/**
	 * Method to set the destroyer information
	 */
	public void setDestroyer()
	{
		shipType = "D";
		shipLength = 2;
		noOfShips = 3;
	}
	
	/**
	 * Method to set the submarine information
	 */
	public void setSubmarine()
	{
		shipType = "S";
		shipLength = 1;
		noOfShips = 3;
	}
	
	
}
