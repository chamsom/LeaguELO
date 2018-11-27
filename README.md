# LeaguELO

## Abstract
An application that allows 10 League of Legends players to input their usernames and then sort themselves into 2 teams that are balanced by current divisions.

## Project Design & Dependencies 
**Python:** Writing code to scrape headings, metadata, etc. off of (http://na.op.gg/) in order to obtain information about player names, ranks, positions, etc. Crawler information will be written to a CSV file via Python.

We will be using **Beautiful Soup 4**  for the purpose of web crawling and extracting information about our players. For more information regarding the installation and code usage for BS4 visit: (https://www.crummy.com/software/BeautifulSoup/bs4/doc/)

**Java:** A portion of the project will also implement Java as a means to learn more about OOP. FixCombinationCode.java finds all permutations of potential teammates and then places them in an array. Players with no duplicates are then placed into a sub array in which two balanced teams are created with no repetition.

**You must have the JDK version installed with an equivalent JRE** or else **Person.java** will fail to compile. For more info regarding this error please visit: https://stackoverflow.com/questions/10382929/how-to-fix-java-lang-unsupportedclassversionerror-unsupported-major-minor-versi/10443722

## Project Milestones
1. Learn to implement a web crawler library and output crawled data from HTML to a CSV file.
2. Manage to pass information from Web-->Python-->CSV file-->Java.
3. Successfully matchmake 10 players into 2 teams with 0 variance in assigned rank weight. Teams should be perfectly balanced by their divisions.

###### Additional Information & Related Projects
https://en.wikipedia.org/wiki/Elo_rating_system

https://nexus.leagueoflegends.com/en-us/2018/02/dev-matchmaking-real-talk/

https://www.cs.hmc.edu/~jfelton/mainpage.html 
