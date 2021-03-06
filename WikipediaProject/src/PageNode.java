public class PageNode 
{
	int outLinks,
		inLinks,
		pageHits,
		pageSize,
		index;
	
	public PageNode()
	{
		outLinks = 0;
		inLinks = 0;
		pageHits = 0;
		pageSize = 0;
		index = -1;
	}
	
	public void addOutLink()
	{
		this.outLinks++;
	}
	public void addInLink()
	{
		this.inLinks++;
	}
	public void addPageHit(int pageHits)
	{
		this.pageHits = pageHits;
	}
	public void addPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	public void addIndex(int index)//same as key
	{
		this.index = index;
	}
	
	public String toString()
	{
		return String.format(" %d %d %d %d %d", index, pageHits,pageSize,inLinks,outLinks);
	}

	public int getIndex() 
	{
		return this.index;
	}
}
