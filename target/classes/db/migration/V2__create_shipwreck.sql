create table SHIPWRECK(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(255),
	DESCRIPTION VARCHAR(2000),
	CONDITIONCHECK VARCHAR(255),
	DEPTH INT,
	LATITUDE DOUBLE,
	LONGITUDE DOUBLE,   
	YEAR_DISCOVERED INT
);

INSERT INTO `fuseesb`.`shipwreck` (`ID`, `NAME`, `DESCRIPTION`, `CONDITIONCHECK`, `DEPTH`, `LATITUDE`, `LONGITUDE`, `YEAR_DISCOVERED`) VALUES ('1', 'U869', 'A very deep German UBoat', 'FAIR', '200', '44.12', '138.44', '1994');

INSERT INTO `fuseesb`.`shipwreck` (`ID`, `NAME`, `DESCRIPTION`, `CONDITIONCHECK`, `DEPTH`, `LATITUDE`, `LONGITUDE`, `YEAR_DISCOVERED`) VALUES ('2', 'U869', 'A very deep German UBoat', 'FAIR', '200', '44.12', '138.44', '1994');

INSERT INTO `fuseesb`.`shipwreck` (`ID`, `NAME`, `DESCRIPTION`, `CONDITIONCHECK`, `DEPTH`, `LATITUDE`, `LONGITUDE`, `YEAR_DISCOVERED`) VALUES ('3', 'U869', 'A very deep German UBoat', 'FAIR', '200', '44.12', '138.44', '1994');