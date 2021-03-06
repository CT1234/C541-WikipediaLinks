import java.io.IOException;

public class LinkReader 
{
	public static void main(String[] args) throws IOException
	{
		ReadFile2Map reader = new ReadFile2Map();	
		System.out.println("Creating hashmap...");
		reader.createHashMap();
		
		System.out.println("Reading Links File...");
		reader.readLinks();
		
		System.out.println("Reading Page hits...");
		reader.readPageHits();
		
		System.out.println("Writing files...");
		reader.writeToFiles();
		
		System.out.println("Done");
	}
}
