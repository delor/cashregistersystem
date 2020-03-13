-- Role użytkowników
INSERT INTO roles(ID, NAME) values (1, 'ROLE_USER');
INSERT INTO roles(ID, NAME) values (2, 'ROLE_ADMIN');
-- Producenci
insert into addresses (id, city, house_number, street, zip_code) values (1, 'Warszawa', '33', 'Municypalna', '02-281');
insert into producers (id, company_name, email, nip, telephone, address_id) values (1, 'Posnet Polska S.A.', 'serwis_centralny@posnet.com', '5222628262', '228686888', 1);

insert into addresses (id, city, house_number, street, zip_code) values (2, 'Warszawa ', '314', 'Puławska', '02-819');
insert into producers (id, company_name, email, regon, nip, telephone, address_id) values (2, 'EDATA Polska Sp. z o.o.', 'biuro@edatapolska.pl','142002658', '5242688936', '225453240', 2);

insert into addresses (id, city, house_number, street, zip_code) values (3, 'Błonie ', '26', 'Kopytów ', '05-870');
insert into producers (id, company_name, email, regon, nip, telephone, address_id) values (3, 'EMAR - Samoraj i spółka - spółka jawna', 'biuro@emar.pl','011534090', '5290009376', '227254546', 3);

insert into addresses (id, city, house_number, street, zip_code) values (4, 'Jaworowa', '1', 'Drukarska ', '05-090');
insert into producers (id, company_name, email, nip, telephone, address_id) values (4, 'Datecs-Polska Sp. z o.o.', 'handel@datecs-polska.pl', '5222606355', '228681051', 4);

insert into addresses (id, city, house_number, street, zip_code) values (5, 'Warszawa', '14', 'Taborowa ', '02-699');
insert into producers (id, company_name, email, nip, regon, telephone, address_id) values (5, 'Elzab S.A.', 'serwis_centralny@posnet.com', '6480000255','270036336', '322722021', 5);
-- Modele
insert into models (id, name, producer_id) values (1, 'Ergo', 1);
insert into models (id, name, producer_id) values (2, 'Ergo Online', 1);
insert into models (id, name, producer_id) values (3, 'Mobile HS', 1);
insert into models (id, name, producer_id) values (4, 'Mobile Online', 1);
insert into models (id, name, producer_id) values (5, 'Bingo HS EJ', 1);
insert into models (id, name, producer_id) values (6, 'Bingo Online', 1);
insert into models (id, name, producer_id) values (7, 'Bingo XL', 1);
insert into models (id, name, producer_id) values (8, 'Fawag Lite Online', 1);
insert into models (id, name, producer_id) values (9, 'Fawag Lite', 1);
insert into models (id, name, producer_id) values (10, 'Revo', 1);
insert into models (id, name, producer_id) values (11, 'Revo Online', 1);
insert into models (id, name, producer_id) values (12, 'Neo XL', 1);
insert into models (id, name, producer_id) values (13, 'Neo Online', 1);

insert into models (id, name, producer_id) values (14, 'Farex Online PRO 300', 2);
insert into models (id, name, producer_id) values (15, 'Farex Online PRO 600', 2);
insert into models (id, name, producer_id) values (16, 'Farex Perła T TAXI', 2);
insert into models (id, name, producer_id) values (17, 'Farex Perła E Plus', 2);
insert into models (id, name, producer_id) values (18, 'Farex Bursztyn E Plus', 2);

insert into models (id, name, producer_id) values (19, 'Printo Line', 3);
insert into models (id, name, producer_id) values (20, 'Tempo Pro', 3);
insert into models (id, name, producer_id) values (21, 'Nova', 3);

insert into models (id, name, producer_id) values (22, 'WP-50', 4);
insert into models (id, name, producer_id) values (23, 'WP-25', 4);
insert into models (id, name, producer_id) values (24, 'WP-500', 4);
insert into models (id, name, producer_id) values (25, 'MALUCH E.KO', 4);
insert into models (id, name, producer_id) values (26, 'SEMI E.KO', 4);

insert into models (id, name, producer_id) values (27, 'JOTA ONLINE', 5);
insert into models (id, name, producer_id) values (28, 'MINI LT ONLINE', 5);
insert into models (id, name, producer_id) values (29, 'K10 ONLINE', 5);








