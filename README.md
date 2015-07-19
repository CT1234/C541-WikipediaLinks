# WikipediaLinks Project Summary#

***(see powerpoint for full description and results)***

##Analyze correlation of Wikipedia Page Popularity by:##

- Page Size
- In and out links.

##Wikipedia.com...##

- Grows about 250,000 pages/year
- As Trends Change, so do popularity of Wiki-pages
- Project will only look at past statistics

##Data obtained from: https://dumps.wikimedia.org/##

For the year of 2010...
- Page Links File: List of Links between pages, Size: 167 GB  
- Page Index File: Links Page index to name Size: 157 MB  
- Page hits Files: # of hits / page / hour and page size. One File per hour of 2010 (about 8760 files total)  
- Size: 152 GB per month, 1.9 TB parsed total (just page hits)  

##Data Refining##

- Map: {PageID, [YearsHits, Size, LinksIn, LinksOut]}  
- Reduce: YearsHits = sum(hits/month)  
- Size = largest size recorded  
- LinksIn = # of times in PageLinks.ToPage  
- LinksOut = # of times in PageLinks.FromPage  

##Data reduction for analysis:##

- Final Size of Data (from 1.9 TB):
 - Links File:			  1.9 GB
 - Page Info File:		 117 MB
 - Index File:			 154 MB

Conclusion:
As theorized, the popularity of a page can be inferred (with fair accuracy) based on its size, links in, or links out.  

