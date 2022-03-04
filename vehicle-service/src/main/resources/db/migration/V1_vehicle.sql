CREATE TABLE `vehicle` (
  `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
  `model` longtext NOT NULL,
  `license_plate` VARCHAR(7) NOT NULL,
  `color` longtext NOT NULL,
  `person_id` INT(10)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
