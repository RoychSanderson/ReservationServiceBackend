
TRUNCATE TABLE restaurants RESTART IDENTITY cascade ;
TRUNCATE TABLE reservations RESTART IDENTITY cascade;
TRUNCATE TABLE tables RESTART IDENTITY cascade;
drop table reservations, restaurants, users, tables cascade ;
