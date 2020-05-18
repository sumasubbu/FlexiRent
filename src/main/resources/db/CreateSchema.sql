
CREATE TABLE RENTAL_PROPERTY 
(
	ID INT GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
	PROPERTY_ID VARCHAR(100) UNIQUE,
	IMAGE_URL VARCHAR(100),
	NUM_BEDROOMS INT,
	TYPE_NAME VARCHAR(50),
	STATUS VARCHAR(50),
	SHORT_DESCRIPTION CLOB,
	LONG_DESCRIPTION CLOB,
	STREET_NUM INTEGER,
	STREET_NAME VARCHAR(300),
	SUBURB VARCHAR(100),
	IN_MAINTENANCE VARCHAR(5),
	FEE_PER_DAY DOUBLE
);

CREATE TABLE RENTAL_RECORD
(
	ID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
	PROPERTY_ID VARCHAR(100),
	START_DATE DATE,
	ESTIMATED_RETURN_DATE DATE,
	ACTUAL_RETURN_DATE DATE,
	RENTAL_FEE DOUBLE,
	LATE_FEE DOUBLE,
	TOTAL_DUE DOUBLE,
	FOREIGN KEY (PROPERTY_ID) REFERENCES RENTAL_PROPERTY(PROPERTY_ID)
);

COMMIT;