DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS AUCTION;

CREATE TABLE USER
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    email      VARCHAR(250) DEFAULT NULL
);

CREATE TABLE PRODUCT
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL,
    image_Url   VARCHAR(250) DEFAULT NULL
);

CREATE TABLE AUCTION
    (
    uuid BINARY NOT NULL PRIMARY KEY,
    auction_name VARCHAR(250) NOT NULL,
    buy_now_amount DOUBLE NOT NULL,
    buy_now_available BIT,
    current_bid DOUBLE NOT NULL,
    end_date TIMESTAMP NOT NULL,
    start_date TIMESTAMP NOT NULL,
    product_id BIGINT NOT NULL,
    FOREIGN KEY(product_id) REFERENCES PRODUCT,
    auction_owner_id BIGINT NOT NULL,
    FOREIGN KEY(auction_owner_id) REFERENCES USER
    );

