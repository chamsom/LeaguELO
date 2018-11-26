import bs4
from urllib.request import urlopen as uReq
from bs4 import BeautifulSoup as soup

# stores player names into new array of player and accounts for any white spaces inputted by the user
player = []
for i in range(10):
    player.append(input("Enter player name: ").replace(" ", ""))

# appends usernames to static url and then is stored into player_url array
player_url = []
for i in range(10):
    player_url.append("http://na.op.gg/summoner/userName=" + player[i])

# creating text file storing information on usernames and player ranks
filename = "ranks.csv"
f = open(filename, "w")
# header = "Usernames:,Ranks:,Winrates:\n" # new version
header = "Username:,Rank:\n"
f.write(header)

# iterating over player_url array
for i in range(0, 10):

	# opens up connection and then grabs the page
	uClient = uReq(player_url[i])
	page_html = uClient.read()
	uClient.close()

	# html parsing
	page_soup = soup(page_html, "html.parser")

	# grabs league tier
	ranks = page_soup.findAll("span", {"class":"tierRank"})

	# winratio = page_soup.findAll("span", {"class":"CKRate tip"}) # new version
	
	# f.write(player[i] + "," + str(ranks[0].text) + "," + str(winratio[0].text) + "\n") # new version
	f.write(player[i] + "," + str(ranks[0].text) + "," + "\n")

print("All done! Check ranks file for info.")

f.close()