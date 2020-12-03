CREATE TABLE account (
    id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    creation_date TIMESTAMP NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    second_name VARCHAR(30) NOT NULL,
    email VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
);

CREATE UNIQUE INDEX uidx_account_email ON account (email);