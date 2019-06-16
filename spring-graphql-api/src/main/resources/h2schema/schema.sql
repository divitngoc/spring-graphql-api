DROP TABLE IF EXISTS song, artist;
 
CREATE TABLE artist (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(255),
  last_name VARCHAR(255)
);

CREATE TABLE song (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  summary VARCHAR(255),
  title VARCHAR(255) NOT NULL,
  lyrics VARCHAR(20000),
  published_date DATE NOT NULL,
  artist_id INT NOT NULL,
  CONSTRAINT fk_song_artist_id FOREIGN KEY (artist_id) REFERENCES artist (id)  
  ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO artist VALUES 
  (1, 'Eric', 'Nam'), 
  (2, 'Ed', 'Sheeran');

INSERT INTO song VALUES 
  (1, NULL, 'Runaway', NULL, '2019-05-08', 1), 
  (2, NULL, 'This is not a love song', NULL, '2018-04-12', 1),
  (3, NULL, 'Perfect', NULL, '2017-09-26', 2);