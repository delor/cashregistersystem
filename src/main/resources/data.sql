-- Role użytkowników
INSERT INTO roles(ID, NAME) values (1, 'ROLE_USER');
INSERT INTO roles(ID, NAME) values (2, 'ROLE_ADMIN');
-- -- Producenci
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

-- -- Użytkownicy
-- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (6, 'Warszawa', '1','10', 'Kasprzaka', '01-110');
-- insert into users (id, nip, regon, company_name, username, telephone, email, address_id, password)
-- values (1, '5244980351', '897935428', 'firma1', 'firmowy1', '123456789', 'firmowy1@firma1.pl', 6, '$2y$10$yeXgZjFMHj8xdkcrXxjZC./Z92gZMIoUT7FkDBI.eh13exhhTpjDy');
--
-- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (7, 'Warszawa', '2','11', 'Wolska', '01-111');
-- insert into users (id, nip, regon, company_name, username, telephone, email, address_id, password)
-- values (2, '5368650334', '334026222', 'firma2', 'firmowy2', '875678098', 'firmowy2@firma2.pl', 7, '$2y$10$K8ODBtjNbUsA0SIZpUuxkOu4WTkOSfICLhG/cEnD8ARO2qeycHWWi');
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (8, 'Warszawa', '3','12', 'Płocka', '01-112');
-- -- insert into users (id, nip, regon, company_name, username, telephone, email, address_id, password)
-- -- values (3, '9526516537', '614528349', 'firma3', 'firmowy3', '568234123', 'firmowy3@firma3.pl', 8, '$2y$10$BHFCBGU4Zt/DOmpelv9v8uOtgcWAPPz3ILXwFPiU7JEQ/WkEBXQ9m');
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (9, 'Gdańsk', '4','13', 'Waliców', '01-113');
-- -- insert into users (id, nip, regon, company_name, username, telephone, email, address_id, password)
-- -- values (4, '4567234587', '234876456', 'firma4', 'firmowy4', '123876009', 'firmowy4@firma4.pl', 9, '$2y$10$prr7bfhtVx9E2uQMTUkfAu.BxkQvRR45C6quUb.WZT5WFuKCsd8f2');
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (10, 'Kraków', '5','14', 'Sporna', '01-114');
-- -- insert into users (id, nip, regon, company_name, username, telephone, email, address_id, password)
-- -- values (5, '9856784576', '234987009', 'firma5', 'firmowy5', '345987098', 'firmowy5@firma5.pl', 10, '$2y$10$CGlAFpmjaJUbAC1Oe/g2KuQf81Ke6bTJag/P.DYNDir97iB2vUo2i');
-- --
-- -- -- Klienci
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (11, 'Kraków', '6','24', 'Wysoka', '03-114');
-- -- insert into users (id, nip, regon, company_name, telephone, email,tax_office,description, address_id, user_id)
-- -- values (1, '5661689768', '115550467', 'klient1', '345987098', 'klient1@klient1.pl','US Warszawa Mokotów','opis klient1', 11, 1);
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (12, 'Wrocław', '3','34', 'Gruba', '11-114');
-- -- insert into users (id, nip, regon, company_name, telephone, email,tax_office,description, address_id, user_id)
-- -- values (2, '5282088929', '117689844', 'klient2', '123123432', 'klient2@klient2.pl','US Warszawa Bemowo','opis klient2', 12, 1);
-- --
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (13, 'Wrocław', '1','4', 'Gruba', '11-114');
-- -- insert into users (id, nip, regon, company_name, telephone, email,tax_office,description, address_id, user_id)
-- -- values (3, '3948490509', '471261052', 'klient3', '156723432', 'klient3@klient3.pl','US Warszawa Targówek','opis klient3', 13, 2);
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (14, 'Wierzbno', '2','3', 'Płaska', '00-114');
-- -- insert into users (id, nip, regon, company_name, telephone, email,tax_office,description, address_id, user_id)
-- -- values (4, '8380158839', '395016408', 'klient4', '151287432', 'klient4@klient4.pl','US Warszawa Włochy','opis klient4', 14, 2);
-- --
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (15, 'Pławica', '20','2', 'Tuwima', '05-115');
-- -- insert into users (id, nip, regon, company_name, telephone, email,tax_office,description, address_id, user_id)
-- -- values (5, '5721625129', '011078539', 'klient5', '159999432', 'klient5@klient5.pl','US Warszawa Ursynów','opis klient5', 15, 3);
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (16, 'Pruszków', '55','6', 'Poniatowskiego', '01-110');
-- -- insert into users (id, nip, regon, company_name, telephone, email,tax_office,description, address_id, user_id)
-- -- values (6, '5095958032', '493242824', 'klient6', '991287432', 'klient6@klient6.pl','US Warszawa Białołęka','opis klient6', 16, 3);
-- --
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (17, 'Pruszków', '10','68', 'Piwnicza', '01-115');
-- -- insert into users (id, nip, regon, company_name, telephone, email,tax_office,description, address_id, user_id)
-- -- values (7, '1084451356', '875268050', 'klient7', '991288902', 'klient7@klient7.pl','US Warszawa Wola','opis klient7', 17, 4);
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (18, 'Piastów', '1','13', 'Zakryta', '01-122');
-- -- insert into users (id, nip, regon, company_name, telephone, email,tax_office,description, address_id, user_id)
-- -- values (8, '7961691693', '918169582', 'klient8', '991345234', 'klient8@klient8.pl','US Warszawa Bemowo','opis klient8', 18, 4);
-- --
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (19, 'Warszawa', '1','53', 'Górczewska', '01-100');
-- -- insert into users (id, nip, regon, company_name, telephone, email,tax_office,description, address_id, user_id)
-- -- values (9, '7585658077', '497871528', 'klient9', '897879875', 'klient9@klient9.pl','US Warszawa Wola','opis klient9', 19, 5);
-- --
-- -- insert into addresses (id, city, house_number,flat_number, street, zip_code) values (20, 'Warszawa', '10','153', 'Górczewska', '01-155');
-- -- insert into users (id, nip, regon, company_name, telephone, email,tax_office,description, address_id, user_id)
-- -- values (10, '3379138099', '456340659', 'klient10', '897879000', 'klient10@klient10.pl','US Warszawa Włochy','opis klient10', 20, 5);
