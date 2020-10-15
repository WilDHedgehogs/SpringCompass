# SpringCompass
Compass Practice work
Возможные варианты и примеры

http://localhost:8989/createCompass
Content-Type:application/json
{
    "North": "316-45",
    "East":  "46-135",
    "South": "136-225",
    "West": "226-315"
}

Content-Type:application/json
{
    "North": "337-23",
    "North-East": "24-69",
    "East":  "70-113",
    "South-East": "114-157",
    "South": "158-202",
    "South-West": "203-247",
    "West": "248-292",
    "North-West": "293-336"
}

http://localhost:8989/getSide
Content-Type:application/json
{
    "Degree": 56
}
