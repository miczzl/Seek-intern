# SearchEngine
此搜尋引擎——Seekin'tern，以「資訊相關科系學生」為目標對象，替其尋找相關的實習機會。
我們透過以加權關鍵字的方式重新排列Google的搜尋結果，練習tree等資料結構。 



1. Introduction:
(1).	Use:
Find information about internships
(2).	Users:
Students seeking for internship
(3).	Motivation: 
Internship opportunity is important for juniors and seniors, but information about interns scattered in various websites, so our purpose is to create a search engine helps students systematically organized the possible outcome.
(4).	The websites that we want to rank: https://www.google.com/


2. 	System Design:
(1) Client Design - HTML, CSS / Java Swing
(2) Connection - Java: FrontEndConn
(3) Server Side - Java: GoogleQuery, WebTree, WebNode, WebPage, WordCounter
 
  >> Word Counter - Method:
     countKeyword-It counts keyword number of each websites.
  >> Web Page - Method:
     WebPage - Innitiate each website as WebPage.	
     setScore - Calculate website’s scores according to its keyword number and the weight.
  >> Web Node - Method:
     WebNode - Initiate each WebPage as WebNode.
     setNodeScore - Add parent’s and childs’ score to parent node.
  >> Web Tree - Method:
     setKeyWords - Set keyword and its weight.
  >> Google Query - Method:
     Innitiate a Tree
     PriorityQueue<WebNode> query - Organized above methods and put them into this method which has two functions.
     >	Do Score Calculation for each Website
     >	Rank them according to their Score
  >> Front End Connection - Method:
     protected void doGet - Do query(), pick 10 websites out of 15, and show them on result frame. 

  
3. Search tricks:
(1)	Keywords and weight:
實習*200、職缺*200
(2)	URL and weight:
edu*-10000
(3)	Catch SSL Exception:
e.g. 1111人力銀行
  
  
4. Challenge:
Create a Swing version of search engine with bookmarks (We did it!)
  
  
5. Function:
-	Directly input keywords to search
-	keyboard shortcut (Link directly to the search page)
  Because we are students of the MIS, the keyboard shortcut are set to be related to the programming language, which is more convenient to use.
  i.	Python
  ii.	Java
  iii.	Javascript
  
  
6. Search Results: 
-	Keywords and weight:
  First, compared to google, our search engine can filter out advertisement. Next, because we are looking for internship related search engines, we set the keyword 「實習」 and 「職缺」weight to 200. 
-	URL and weight:
  We specially set URL “edu” weight to -10000 points to avoid inquiring about school information. 
-	Catch SSL Exception:
  Due to the SSL Exception, there is no way to count keywords, but this type of manpower bank is the main source of finding internships, so we set this type of     webpage to zero, that is, it will be ranked before the negative score and after results with positive score. To avoid missing important information.
