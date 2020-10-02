##Defunct
import requests
import json
from bs4 import BeautifulSoup

#######JSON FORMAT
##SYSTEMS{
##    HOME{
##        SYSTEM{
##            PLANET{
##                FACTION
##                INFLUENCE
##                RESOURCES
##                TEXT
##        }
##     }
##    
##    COMMON{
##        SYSTEM{
##            PLANET{
##                TRAIT
##                RESOURCES
##                INFLUENCE
##                FEATURES
##                TEXT
##        }
##    }
##}



url = "https://twilight-imperium-4.fandom.com/wiki/Planets_and_Systems"

res = requests.get(url)
soup = BeautifulSoup(res.text,"lxml")

#This script will export a dictionaries of these dicts
#to track systems as a json file
homes = {}
commons = {}
system_planets = {}
system = {}
#Parse wiki tables for system data with beautifulsoup
tables = soup(class_="article-table")
i=0
row_number=0

###It'd be nice to use functions, but the format is so inconsistent it's not worth
#takes a dictionary of planets, returns as a named system dictionary
#def create_system():

#takes traits of a planet, returns planet as dictionary
#def create_planet():
    
#Iterate through tables
for table in tables:
    table_rows = table.find_all("tr")
    #Iterate through table rows
    for tr in table_rows:
        td = tr.find_all("td")
        #Get table data for each row
        row = [i.get_text("|", strip = True) for i in td]
        # :( need many conditions b/c wiki formatting is inconsistent
        #Ignore blank rows
        if len(row) == 0 or len(row[0])==0:
            pass
        #Mecatol table
        elif i == 0:
                #Create planet dict, fill with info, add to system dict
                planet_name = row[0]
                planetdict = dict(trait = row[1], resources = row[2],
                                  influence = row[3], text = row[4])
                #watch out for references!
                system_planets[planet_name] = planetdict.copy()
        #Homesystems table
        elif i == 1:
            #Create planet dict, fill with info, add to system dict
            planet_name = row[0]
            planetdict = dict(faction = row[1], resources = row[2],
                              influence = row[3], text = row[4])
            #watch out for references!
            system_planets[planet_name] = planetdict.copy()
        #Common planets table
        elif i == 2:
            #Create planet dict, fill with info, add to system dict
            row[0] = row[0].split("|")
            planet_name = row[0][0]
            planetdict = dict(trait = row[0][1], resources = row[1],
                              influence = row[2], features = row[3],
                              text =row[4])
            #watch out for references!
            system_planets[planet_name] = planetdict.copy()
        #Separate systems based on empty row or end of table
        if len(row) > 0 and (len(row[0]) == 0 and row_number!=0) or row_number == len(table_rows)-1:
            if i == 0 or i == 2:
                system_name = ""
                system_name = ",".join(system_planets.keys())
                system_planets["size"] = len(system_planets)
                commons[system_name] = system_planets.copy()
                system = {}
                system_planets = {}
            else:
                system_name = ""
                system_name = ", ".join(system_planets.keys())
                for planetname in system_planets:
                    system_planets["faction"] = system_planets[planetname]["faction"]
                    break
                system_planets["size"] = len(system_planets)
                homes[system_name] = system_planets.copy()
                system = {}
                system_planets = {}
        #Mecatol table
        row_number+=1
    i+=1
    row_number=0

#Export dictionaries to json
systems = {"homes":homes, "commons":commons}
with open('systems.json', 'w') as fp:
    json.dump(systems, fp)
