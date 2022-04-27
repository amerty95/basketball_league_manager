CREATE TABLE public.teams (
	team_id serial4 NOT NULL,
	team_name varchar(50) NOT NULL,
	win_count int2 NOT NULL DEFAULT 0,
	loss_count int2 NOT NULL DEFAULT 0,
	draw_count int2 NOT NULL DEFAULT 0,
	point_count int2 NOT NULL DEFAULT 0,
	scored int2 NOT NULL DEFAULT 0,
	conceded int2 NOT NULL DEFAULT 0,
	CONSTRAINT teams_pkey PRIMARY KEY (team_id),
	CONSTRAINT teams_team_name_key UNIQUE (team_name)
);

insert into teams(team_name) values ('ALİAĞA PETKİM SPOR');
insert into teams(team_name) values ('BAHÇEŞEHİR KOLEJİ');
insert into teams(team_name) values ('BEŞİKTAŞ ICRYPEX');
insert into teams(team_name) values ('BÜYÜKÇEKMECE BASKETBOL');
insert into teams(team_name) values ('FENERBAHÇE BEKO');
insert into teams(team_name) values ('GALATASARAY NEF');
insert into teams(team_name) values ('GAZİANTEP BASKETBOL');
insert into teams(team_name) values ('HDI SİGORTA AFYON BELEDİYESİ');
insert into teams(team_name) values ('SEMT77 YALOVASPOR');
insert into teams(team_name) values ('TÜRK TELEKOM SPOR');
insert into teams(team_name) values ('YUKATEL MERKEZEFENDİ BELEDİYESİ BASKET');
insert into teams(team_name) values ('FRUTTİ EXTRA BURSASPOR');
insert into teams(team_name) values ('ANADOLU EFES');
insert into teams(team_name) values ('PINAR KARŞIYAKA');
insert into teams(team_name) values ('TOFAŞ');
insert into teams(team_name) values ('DARÜŞŞAFAKA');
