CREATE TABLE `person` (
  `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
  `name` longtext NOT NULL,
  `cpf` longtext NOT NULL,
  `phone` VARCHAR(11),
  `email` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
