# LeaguELO
Python script that crawls &amp; then exports summoner usernames and their respective ranks into a CSV file. Summoners are then sorted by point values dependent upon their rank and then arranged into balanced teams.

## Abstract
An application that allows 10 League of Legends players to input their usernames and then sort themselves into 2 teams that are balanced by current ranks.

## Project Design
**Java:** Using a sorting algorithm or optimizing it so that “weight” can be assigned to player ranks in order to simplify the process of grouping them by similar ranks. 

**Python:** Writing code to scrape headings, metadata, etc. off of (http://na.op.gg/) in order to obtain information about player names, ranks, positions, etc. Crawler information will be written to a CSV file via Python.

## Project Milestones
Learn to implement a web crawler library and output crawled data from HTML to a CSV file.
Manage to pass information from Web-->Python-->CSV file-->Java.
Successfully matchmake 10 players into 2 teams ±1 or ±2 variance in assigned rank weight.
