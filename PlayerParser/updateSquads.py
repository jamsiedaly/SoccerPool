"""
* @author James
* I learned how to make a web scraper from a 
* book called Blackhat Python by Justin Seitz
* I was recommended a python library called BeautifulSoup
* I learned to use the library from documentation 
* found on the website www.crummy.com
"""
from bs4 import BeautifulSoup
import urllib.request
import _thread 
import os
import errno

numberOfLeagues = 4
leaguesFinished = 0

def startLeagues():

	LaLiga = ['athletic-club-de-bilbao','atletico-madrid','ca-osasuna',
				'cd-leganes', 'deportivo-alaves', 'fc-barcelona', 'granada-cf',
				'malaga-cf', 'rc-celta-de-vigo', 'rc-deportivo-de-la-coruna',
				'rcd-espanyol', 'real-betis-balompie', 'real-madrid-cf',
				'real-sociedad', 'real-sporting-de-gijon', 'sd-eibar',
				'sevilla-fc', 'ud-las-palmas', 'valencia-cf', 'villarreal-cf']
				
	Bundesliga = ['1-fc-koln', '1-fsv-mainz-05', 'bayer-04-leverkusen', 
				'borussia-dortmund', 'borussia-monchengladbach', 'eintracht-frankfurt',
				'fc-augsburg', 'fc-bayern-munchen', 'fc-ingolstadt-04', 'fc-schalke-04', 
				'hamburger-sv', 'hertha-berlin', 'rb-leipzig', 'sport-club-freiburg',
				'sv-darmstadt-98', 'sv-werder-bremen', 'tsg-1899-hoffenheim',
				'vfl-wolfsburg']
				
	PremLeague = ['arsenal','bournemouth','burnley','chelsea','crystal-palace','everton',
				'hull-city','leicester-city','liverpool', 'manchester-city',
				'manchester-united','middlesbrough', 'southampton', 'stoke-city',
				'sunderland', 'swansea-city', 'tottenham-hotspur','watford',
				'west-bromwich-albion', 'west-ham-united']
				
	SerieA = ['atalanta','bologna','cagliari','chievo-verona','crotone','empoli',
				'fiorentina','genoa','inter','juventus','lazio','milan','napoli',
				'palermo','pescara','roma','sampdoria','sassuolo','torino','udinese']
				
	_thread.start_new_thread(downloadTeam, ('Liga',LaLiga))
	_thread.start_new_thread(downloadTeam, ('Bundesliga',Bundesliga))
	_thread.start_new_thread(downloadTeam, ('Prem',PremLeague))
	_thread.start_new_thread(downloadTeam, ('SerieA',SerieA))
	'''for team in LaLiga:
		downloadTeam(team)      #Untreaded version it does one league at a time
	for team in Bundesliga:
		downloadTeam(team)
	for team in PremLeague:
		downloadTeam(team)
	for team in SerieA:
		downloadTeam(team)'''

def downloadTeam(leagueName, League, ):

	opener = urllib.request.build_opener()
	opener.addheaders = [('User-Agent', 'Mozilla/5.0')]
	for team in League:
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
	global leaguesFinished 
	leaguesFinished += 1
	print(leagueName,': done')
	
def writePlayer(name, position, rating, pace, shooting, passing, dribbling, defending, physical, teamFile):
	teamFile.write(name+','+position+','+rating+','+pace+','+shooting+','+passing+','+dribbling+','+defending+','+
					physical+'\n')
		
def createFiles(threadName, team):
		leagueFile = threadName + '/'
		os.makedirs(os.path.dirname(leagueFile), exist_ok=True)
		teamFileName = leagueFile + team + '.txt'
		teamFile = open(teamFileName, 'w+', encoding='utf8')
		return teamFile

#startLeagues()
if  __name__ = '__main__':
	
#while leaguesFinished<numberOfLeagues:
#	pass