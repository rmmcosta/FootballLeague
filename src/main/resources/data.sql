INSERT INTO District(id, name) values(1, 'Lisboa')
INSERT INTO District(id, name) values(2, 'Porto')

INSERT INTO Team(id, name, district_id) values(1, 'S.L. Benfica', 1)
INSERT INTO Team(id, name, district_id) values(2, 'Sporting CP', 1)
INSERT INTO Team(id, name, district_id) values(3, 'F.C. Porto', 2)

INSERT INTO Result(id, home_team_id, away_team_id, goals_scored, goals_suffered) values(1, 1, 2, 3, 1)
INSERT INTO Result(id, home_team_id, away_team_id, goals_scored, goals_suffered) values(2, 2, 1, 1, 1)
INSERT INTO Result(id, home_team_id, away_team_id, goals_scored, goals_suffered) values(3, 1, 3, 2, 1)
INSERT INTO Result(id, home_team_id, away_team_id, goals_scored, goals_suffered) values(4, 3, 1, 0, 0)
INSERT INTO Result(id, home_team_id, away_team_id, goals_scored, goals_suffered) values(5, 3, 2, 1, 0)
INSERT INTO Result(id, home_team_id, away_team_id, goals_scored, goals_suffered) values(6, 2, 3, 1, 0)