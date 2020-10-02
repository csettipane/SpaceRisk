import json
facts = "ARBOREC, EMBERS, GHOSTS, NAALU, UNIVERSITIES, YIN, LETNEV, HACAN, MINDNET, NEKRO, WINNU, YSSARIL, SAAR, SOL, MENTAK, SARDAKK, XXCHA"

fact_list = [(x.strip().lower()) for x in facts.split(",")]

fact_dict={}

with open("tiles.json") as file:
    tiles = json.load(file)

for faction in tiles["home_tiles"]:
    
    fact_dict[faction["race"]] = {
        "tile" : faction,
        "maxCommodities": 0,
        "initialUnits": {
            "carrier":0,
            "cruiser":0,
            "destroyer":0,
            "dreadnought":0,
            "flagship":0,
            "warsun":0,
            "infantry":0,
            "fighters":0,
            "pds":0,
            "spacedock":0
        },
        "initialTechs":{
            "red":[0,0,0,0],
            "blue":[0,0,0,0],
            "yellow":[0,0,0,0],
            "green":[0,0,0,0],
            "unit":{
                "carrier":0,
                "cruiser":0,
                "destroyer":0,
                "dreadnought":0,
                "flagship":0,
                "warsun":0,
                "infantry":0,
                "fighters":0,
                "pds":0,
                "spacedock":0
            }
        },
        "uniqueFeatures":{
            "unitA":{
                "limit": 8,
                "cost" : 2,
                "combat": [1,6],
                "move": 3,
                "capacity": 1,
                "antifighter":[0,0],
                "bombardment": [0,0],
                "sustain": 0,
                "production": 0,
                "spaceCannon": [0,0,0]
                },
            "unitB": {
                "limit": 8,
                "cost" : 2,
                "combat": [1,6],
                "move": 3,
                "capacity": 1,
                "antifighter":[0,0],
                "bombardment": [0,0],
                "sustain": 0,
                "production": 0,
                "spaceCannon": [0,0,0]
                },
            "techA":{
                },
            "techB":{
                },
            "flagship":{
                "limit": 1,
                "cost" : 2,
                "combat": [1,6],
                "move": 3,
                "capacity": 1,
                "antifighter":[0,0],
                "bombardment": [0,0],
                "sustain": 0,
                "production": 0,
                "spaceCannon": 0
            }
        },
    }

with open('edited_factions.json', 'w') as fp:
    json.dump(fact_dict, fp, indent=4)    
