import sys

if sys.version_info[0] == 2:
    from urllib2 import urlopen  # Python 2
else:
    from urllib.request import urlopen  # Python3

#Retrieve HTML string from the URL
html = urlopen("http://www.pythonscraping.com/exercises/exercise1.html")
print(html.read())