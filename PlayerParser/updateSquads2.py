from bs4 import BeautifulSoup
import urllib.request
import os

def test1():
	opener = urllib.request.build_opener()
	opener.addheaders = [('User-Agent', 'Mozilla/5.0')]
	for n in range(26):
		url = 'http://www.futhead.com/17/clubs/?page='
		url += str(n+1)
		#print(url)
		site = opener.open(url)
		info = BeautifulSoup(site.read(), 'html.parser')
		teams = info.find_all('div', {'class':'player-item'})
		for team in teams:
			teamURL = 'http://www.futhead.com'
			for a in team.find_all('a', href=True):
				teamPage = a['href']
				leagueNS = team.find_all('span',{'class':'player-club-league-name'})
				teamNameNS = team.find_all('span',{'class':'player-name'})
				if teamPage[0] != '?':
					teamURL += teamPage
					teamName = teamNameNS[0].contents[0]
					teamName = teamName.strip('\n')
					teamName = teamName.strip()
					league = leagueNS[0].contents[0]
					league = league.strip('\n')
					league = league.strip()
					print(teamName)
					downloadTeam(league, teamURL, teamName)
			#for l in team.find_all('span',{'class':'player-club-league-name'}):
			#	print(l.string)

def getTeam():
	pass
	
def downloadTeam(leagueName, url, team):

	opener = urllib.request.build_opener()
	opener.addheaders = [('User-Agent', 'Mozilla/5.0')]
	#url = 'http://www.futhead.com/17/clubs/'
	#url += team
	#url += '/'
	print(url)
	site = opener.open(url)
	info = BeautifulSoup(site.read(), 'html.parser')
	names = info.find_all('div', {'class':'playercard-name'})
	position = info.find_all('div', {'class':'playercard-position'})
	rating = info.find_all('div', {'class':'playercard-rating'})
	pace = info.find_all('div', {'class':'playercard-attr playercard-attr1'})
	shooting = info.find_all('div', {'class':'playercard-attr playercard-attr2'})
	passing = info.find_all('div', {'class':'playercard-attr playercard-attr3'})
	dribbling = info.find_all('div', {'class':'playercard-attr playercard-attr4'})
	defending = info.find_all('div', {'class':'playercard-attr playercard-attr5'})
	physical = info.find_all('div', {'class':'playercard-attr playercard-attr6'})
	i = 0
	teamFile = createFiles(leagueName, team)
	for item in names:
		crrntPlyr = item.contents[0] 
		if(crrntPlyr != 'All Players' and 
			crrntPlyr != 'Gold Players' and
			crrntPlyr != 'Silver Players' and 
			crrntPlyr != 'Bronze Players'): 
			writePlayer(crrntPlyr, position[i].contents[0], rating[i].contents[0], pace[i].contents[0], shooting[i].contents[0],
					passing[i].contents[0], dribbling[i].contents[0], defending[i].contents[0],
					physical[i].contents[0], teamFile)
			#print(rating[i].contents[0])
			#print(pace[i].contents[0])
			#print(shooting[i].contents[0])      Print's all stats to command line
			#print(passing[i].contents[0])
			#print(dribbling[i].contents[0])
			#print(defending[i].contents[0])
			#print(physical[i].contents[0])
			i += 1
	print(url,': done')
	
def writePlayer(name, position, rating, pace, shooting, passing, dribbling, defending, physical, teamFile):
	teamFile.write(name+','+position+','+rating+','+pace+','+shooting+','+passing+','+dribbling+','+defending+','+
					physical+'\n')
		
def createFiles(threadName, team):
		leagueFile = threadName + '/'
		os.makedirs(os.path.dirname(leagueFile), exist_ok=True)
		teamFileName = leagueFile + team + '.txt'
		teamFile = open(teamFileName, 'w+', encoding='utf8')
		return teamFile
		
if __name__ == '__main__':
	test1()