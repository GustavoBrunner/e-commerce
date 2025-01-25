ALTER TABLE address
    ADD CONSTRAINT FK_users_address_id
        FOREIGN KEY(FK_user_id)
        REFERENCES users(PK_id)