from bs4 import BeautifulSoup
import urllib.request

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
				if teamPage[0] != '?':
					teamURL += teamPage
					print(teamURL)
			for l in team.find_all('span',{'class':'player-club-league-name'}):
				print(l.contents[0])

def getTeam():
	pass
					
if __name__ == '__main__':
	test1()