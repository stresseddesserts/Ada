DROP TABLE IF EXISTS person;

CREATE TABLE person (
        id INT AUTO_INCREMENT  PRIMARY KEY,
        name VARCHAR(250) NOT NULL,
        surname VARCHAR(250) NOT NULL,
        identification_number INT NOT NULL,
        income INT NOT NULL,
        funding_amount INT NOT NULL,
)

INSERT INTO person (id, name, surname, identification_number, income, funding_amount) VALUES
        (1, 'Rokas', 'Pra', '12345678910', 111007, 500),
        (2, 'Bil', 'De', '1564813215', 7945, 10),
        (3, 'Cactus', 'Flower', '749864651', 1, 20);