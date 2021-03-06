import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class ReadFile2Map 
{
	HashMap<Integer, PageNode> links;
	
	public ReadFile2Map()
	{
		links = new HashMap<Integer, PageNode>();
	}
	
	public void createHashMap()
	{
		links = createPageNodeHM(5687150, links);
	}
	
	public void readLinks() throws IOException
	{
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    inputStream = new FileInputStream("links.txt");
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) 
		    {
		        String line = sc.nextLine();
		        
		        if(line.contains("a"))
		        	continue;
		        		        		        
		        String[] parts = line.split(" ");
		        int from = convertToInt(parts[0]);
		        if( !(from >= 5687149))
		        {
			        links.get(from).addOutLink();
		        }
		        
		        int to = convertToInt(parts[1]);
		        if( !(to >= 5687149))
		        {
			        links.get(to).addInLink();
		        }
		    }
		    if (sc.ioException() != null) 
		    {
		        throw sc.ioException();
		    }
		} 
		finally 
		{
		    if (inputStream != null) 
		    {
		        inputStream.close();
		    }
		    if (sc != null)
		    {
		        sc.close();
		    }
		}		
	}

	public void readPageHits() throws IOException 
	{
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    inputStream = new FileInputStream("TotalCount_2010.txt");
		    sc = new Scanner(inputStream, "UTF-8");
		    boolean skipfirstline = true;
		    while (sc.hasNextLine()) 
		    {
		        String line = sc.nextLine();
		        
		        if(skipfirstline)
		        {
		        	skipfirstline = false;
		        	continue;
		        }
		        		        		        
		        String[] parts = line.split(" ");
		        int index = convertToInt(parts[0]);
		        int pagehits = convertToInt(parts[1]);
		        int pageSize = convertToInt(parts[2]);
		        
		        links.get(index).addPageHit(pagehits);
		        links.get(index).addPageSize(pageSize);
		        links.get(index).addIndex(index);
		    }
		    if (sc.ioException() != null) 
		    {
		        throw sc.ioException();
		    }
		} 
		finally 
		{
		    if (inputStream != null) 
		    {
		        inputStream.close();
		    }
		    if (sc != null)
		    {
		        sc.close();
		    }
		}			
	}
	
	private int convertToInt(String s)
	{		
		int value = 0;
		int exponent = s.length();
		exponent--;
		for(int i = 0; i < s.length(); i++)
		{
			char currentChar = s.charAt(i);
			int digit = Character.getNumericValue(currentChar);
			value += digit* Math.pow(10, exponent--);
		}	
		return value;
	}
	
	private HashMap<Integer, PageNode> createPageNodeHM(int numberOfLinks, HashMap<Integer, PageNode> links)
	{
		for(int i = 0; i < numberOfLinks; i++)
		{
			PageNode node = new PageNode();
			links.put(i, node);
		}
	return links;
	}

	public void writeToFiles() throws IOException
	{
		  int index = 1;
		  int textFileNumber = 0;
		  File file = new File(textFileNumber++ + "_ALLPageInfo.txt");
	      file.createNewFile();
	      FileWriter writer = new FileWriter(file);
	      writer.write("index pageHits pageSize inLinks outLinks\n"); 
	      
		  while(index != 5687150)
		  {
		      if (links.get(index).getIndex() != -1)
	    	  writer.write(links.get(index++).toString() + " \n");		
		      else 
		    	  index++;
		  }
	      writer.flush();
	      writer.close();
	}
}
