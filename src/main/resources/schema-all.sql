DROP TABLE ball_stats IF EXISTS;

CREATE TABLE ball_stats  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    match_id BIGINT,
    inning INTEGER,
    over INTEGER,
    ball INTEGER,
    batsman VARCHAR(100),
    bowler VARCHAR(100),
    batsman_runs INTEGER,
    extra_runs INTEGER,
    total_runs INTEGER,
    is_wicket INTEGER,
    dismissal_kind VARCHAR(100),
    player_dismissed VARCHAR(100),
    fielder VARCHAR(100),
    extras_type VARCHAR(100),
    batting_team VARCHAR(100),
    bowling_team VARCHAR(100)
);