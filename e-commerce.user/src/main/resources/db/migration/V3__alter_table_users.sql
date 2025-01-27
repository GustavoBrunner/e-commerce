ALTER TABLE users
    ADD CONSTRAINT FK_main_address_id
        FOREIGN KEY(FK_main_address_id)
        REFERENCES address(PK_id)
        ON DELETE SET NULL