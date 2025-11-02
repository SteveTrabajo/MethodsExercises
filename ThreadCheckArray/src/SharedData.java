import java.util.ArrayList;
/** This class shares data between threads
 * @author Natan Niemetz */
public class SharedData 
{
	/** Variables */
	private ArrayList<Integer> array;
	private boolean [] winArray;
	private boolean flag;
	private final int b;
	
	/** Constructor of SharedData
	 * @param array the list of integers shared
	 * @param b array size constant */
	public SharedData(ArrayList<Integer> array, int b) {
		
		this.array = array;
		this.b = b;
	}
	
	/** return winner array
	 * @return the boolean array representing the threads won */
	public boolean[] getWinArray() 
	{
		return winArray;
	}
	
	/** set winner array 
	 * @param winArray the boolean array representing the threads won*/
	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}
	
	/** get shared array 
	 * @return the shared array */
	public ArrayList<Integer> getArray() 
	{
		return array;
	}
	
	/** get array size 
	 * @return the array size**/
	public int getB() 
	{
		return b;
	}
	
	/** get flag 
	 * @return True or False**/
	public boolean getFlag() 
	{
		return flag;
	}
	
	/** set flag 
	 * @param flag either true or false*/
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
