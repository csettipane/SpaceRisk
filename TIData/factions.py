import csv
import json
##TODO:
#finish sorting out starting techs
#finish adding things to dict as we go along
#also faction techs for units are wonky (ex. sol faction techs)
#and also winnu faction techs? something aint right
count = 0
faction_rowA = []
faction_rowB = []
factions = []
fact_dict = {}
commodities = ""
with open("factions.csv", newline='') as csvfile:
    faction_reader = csv.reader(csvfile, delimiter = ",")
    for row in faction_reader:
        faction_rowA += [row[:3]]
        faction_rowB += [row[3:]]
    factions = faction_rowA + faction_rowB
    for faction_row in factions:
        if faction_row[0] == "Home System":
            name = prev_row[0]
            print("Faction name:")
            print('"'+name+'"')
            count+=1
        elif faction_row[0] == "Starting Fleet":
            units = faction_row[1].split("\n")
            print("Starting fleet:")
            #name is a new dictionary of dictionaries
            for j in range(len(units)):
                entry = units[j].lower().split(" ")
                entry[1] = (entry[1][:-1] if (entry[1][-1]=="s" and entry[1]!="pds") else entry[1])
                entry[1] = ("".join(entry[1:]) if len(entry)==3 else entry[1])
                entry = entry[:2]
                entry.reverse()
                entry[1] = int(entry[1])
                print(entry)
                #entry = key, val
        elif faction_row[0] == "Commodities":
            commodities = [faction_row[0].lower(), int(faction_row[1])]
            # commodities = key, val
            print(commodities)
        elif faction_row[0] == "Starting Technologies":
            print("Starting techs:")
            starting_techs = faction_row[1].strip().split("\n")
            print(starting_techs)
        elif faction_row[0] == "Special Units":
            print("Units:")
            special_units = faction_row[1].strip().split("\n\n") #[x.strip().split("\n\n")  for x in faction_row[1:]]
            for unit in special_units:
                for entry in unit.split("\n"):
                    print(entry.split())
                print("--------")
        elif faction_row[0] == "Faction Technologies":
            print("Faction techs:")
            faction_techs = faction_row[1].strip().split("\n\n")
            for tech in faction_techs:
                for entry in tech.split("\n"):
                    entry = entry.split()
                    if len(entry) == 3:
                        pre_req = entry[2][1:].strip("):")
                        print(pre_req)
                print("--------")
        elif faction_row[0] == "Flagship":
            print("Flagship stats:")
            flagship = faction_row[1].strip().split("\n")
            for entry in flagship[2:-1]:
                entry = entry.replace(":", "").split(" ")
                print(entry, end = "")
                #entries are key, value in flagship dict #except combat and sustain
            print("\n-------------------------------------")
        prev_row = faction_row
        
with open("factions.json", "w") as json_file:
    json.dump(fact_dict, json_file, indent=4)
