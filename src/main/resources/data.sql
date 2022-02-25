insert into guest(id, name) values(1, 'Roger Federer');
insert into guest(id, name) values(2, 'Rafael Nadal');

insert into tennis_court(id, name) values(null, 'Roland Garros - Court Philippe-Chatrier');

insert
    into
        schedule
        (id, start_date_time, end_date_time, tennis_court_id)
    values
        (null, '2020-12-20T20:00:00.0', '2020-02-20T21:00:00.0', 1);