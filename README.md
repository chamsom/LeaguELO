# LeaguELO
Python script that crawls &amp; then exports summoner usernames and their respective ranks into a CSV file. Summoners are then sorted by point values dependent upon their rank and then arranged into balanced teams.

## Abstract
An application that allows 10 League of Legends players to input their usernames and then sort themselves into 2 teams that are balanced by current ranks.

## Project Design & Dependencies 
**Python:** Writing code to scrape headings, metadata, etc. off of (http://na.op.gg/) in order to obtain information about player names, ranks, positions, etc. Crawler information will be written to a CSV file via Python.

We will be using **Beautiful Soup 4**  for the purpose of web crawling and extracting information about our players. For more information regarding the installation and code usage for BS4 visit: (https://www.crummy.com/software/BeautifulSoup/bs4/doc/)

*Beautiful Soup is a Python library for pulling data out of HTML and XML files. It works with your favorite parser to provide idiomatic ways of navigating, searching, and modifying the parse tree. It commonly saves programmers hours or days of work.*

**Java:** Using a sorting algorithm or optimizing it so that “weight” can be assigned to player ranks in order to simplify the process of grouping them by similar ranks. 

## Project Milestones
1. Learn to implement a web crawler library and output crawled data from HTML to a CSV file.
2. Manage to pass information from Web-->Python-->CSV file-->Java.
3. Successfully matchmake 10 players into 2 teams ±1 or ±2 variance in assigned rank weight.
