CREATE TABLE IF NOT EXISTS users(
    PK_id VARCHAR(100) NOT NULL,
    FK_wallet_id VARCHAR(100) UNIQUE,
    FK_main_address_id VARCHAR(100) NOT NULL UNIQUE,

    password VARCHAR(200) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE



);