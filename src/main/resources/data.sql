INSERT INTO USER (first_name, last_name, email)
VALUES ('Aldona', 'WHITE', '123@gmail.com'),
       ('Janusz', 'KOCUR', 'abc@gmail.com'),
       ('Adam', 'BLACK', 'xyz@email.com'),
       ('Zenon', 'ADAMCZYK', 'cap@marvel.com'),
       ('Katarzyna', 'GREEN', '125@email.com');

INSERT INTO PRODUCT (name, description, image_url)
VALUES ('Mysz Dell MS116', 'Mysz jak mysz...', 'image/dell/mouse.jpg'),
       ('Monitor Lenovo ThinkVision T2364t 23"',
        'Nowoczesny monitor podświetlany diodami LED, co przekłada się na wiele zalet jego użytkowania.',
        'image/lenovo/monitor.jpg'),
       ('Monitor LG 24MB37PM 24"',
        'Zaawansowane technologicznie matryce LG IPS, dzięki temu nawet wielogodzinna rozrywka z ulubioną grą czy maraton filmowy to komfortowe doznanie.',
        'image/lg/monitor.jpg'),
       ('Mikrofon BOSCH DCN-DISL-D', 'Duża odporność na zakłócenia powodowane przez telefony komórkowe',
        'image/bosh/microphone.jpg'),
       ('Lenovo ThinkPad T460', 'Wydajność i odporność to główne hasła serii ThinkPad', 'image/lenovo/thinkpad.jpg');

-- INSERT INTO AUCTION (UUID, AUCTION_NAME, BUY_NOW_AMOUNT, BUY_NOW_AVAILABLE, CURRENT_BID, END_DATE, START_DATE,
--                      AUCTION_OWNER_ID, PRODUCT_ID)
--     VALUE ('123e4567e89b42d3a456556642440000', 'Mysz-a', 20.50, 0, 0, 2022-04-04T22:03:07.768485, 2022-04-24T22:03:07.768485, 1, 1);