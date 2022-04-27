# basketball_league_manager

A demo project for basketball league with teams and matches via springboot


Specifications:
Springboot with Java 11, Postgresql
I added the given 16 teams to DB and shared the related scripts in the attachment.
Before running the app user should:
•	provide a postgre db, 
•	configure it in application.properties file 
•	run given scripts to add teams.

API descriptions:

/api/v1/match-score [POST]

User can add a match score to the system with this API. 
Listed controls are made and related exceptions are returned in these cases:
•	home and guest fields should match a basketball team name in DB. 
•	hScore and gScore should be positive integer
•	home and guest team names can not be same

Winner takes 3 points, in draw both teams get 1 point.
Service url:
http://localhost:8080/api/v1/match-score

Sample Request:
{
    "home": "TOFAŞ",
    "guest": "DARÜŞŞAFAKA",
    "hScore": 56,
    "gScore": 72
}

/api/v1/team/{teamName} [GET]

User can get information of a desired team. If a non-existing team is given, service returns 404.

Service url:
http://localhost:8080/api/v1/team/FRUTTİ EXTRA BURSASPOR

/api/v1/team-standings [GET]

User can see all stats of all teams. No specific ordering between teams with same point. 
Response is in this format:

team,wins,losses,draws,points,scored,conceded,ranking
PINAR KARŞIYAKA,2,1,2,8,500,495,1
FRUTTİ EXTRA BURSASPOR,1,2,1,4,384,393,2
ANADOLU EFES,1,1,1,4,316,312,3
DARÜŞŞAFAKA,1,0,0,3,72,56,4
BÜYÜKÇEKMECE BASKETBOL,0,0,0,0,0,0,5
BEŞİKTAŞ ICRYPEX,0,0,0,0,0,0,6
BAHÇEŞEHİR KOLEJİ,0,0,0,0,0,0,7
SEMT77 YALOVASPOR,0,0,0,0,0,0,8
TOFAŞ,0,1,0,0,56,72,9
YUKATEL MERKEZEFENDİ BELEDİYESİ BASKET,0,0,0,0,0,0,10
TÜRK TELEKOM SPOR,0,0,0,0,0,0,11
ALİAĞA PETKİM SPOR,0,0,0,0,0,0,12
HDI SİGORTA AFYON BELEDİYESİ,0,0,0,0,0,0,13
GAZİANTEP BASKETBOL,0,0,0,0,0,0,14
GALATASARAY NEF,0,0,0,0,0,0,15
FENERBAHÇE BEKO,0,0,0,0,0,0,16

Service url:
http://localhost:8080/api/v1/team-standings

Notes:
Test cases for service codes are added.
Used aspect oriented programming for basic features like Transactional service calls.
Added indexing for team_name column of table since get team operations are running on team_name column.

What can be added to the program:
Users can add and delete their teams to the system
More test cases can be added aspecially for utility methods.
Caching can be added for team standings and get team services, cache can be updated each time match-team is called
To keep track of users, authorization and token functionalities can be added.



