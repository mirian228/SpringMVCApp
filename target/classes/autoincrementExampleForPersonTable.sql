SELECT * FROM Person;

CREATE SEQUENCE first_sequence;

SELECT nextval('first_sequence');

DROP SEQUENCE first_sequence;

DROP Table person;

CREATE Table Person (
		id SERIAL, -- Creates person_id_seq in Sequences folder, used to auto increment for id -- 
		name varchar,
		age int,
		email varchar
);

CREATE Table Person2 (
		id int GENERATED BY DEFAULT AS IDENTITY, -- Creates person_id_seq in Sequences folder, used to auto increment for id (Newest Approach) -- 
		name varchar
);

INSERT INTO Person(name, age, email) VALUES ('Tom', 30, 'test@gmail.com');
INSERT INTO Person(name, age, email) VALUES ('Bob', 30, 'Bob@gmail.com');
INSERT INTO Person(name, age, email) VALUES ('Harry', 30, 'harry@gmail.com');

INSERT INTO Person2(name) VALUES('Tom');
INSERT INTO Person2(name) VALUES('Boby');


SELECT * From Person;
SELECT * From Person2;