CREATE TABLE `traffic_ticket` (
  `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
  `type_infraction` longtext NOT NULL,
  `price` decimal(65,2) NOT NULL,
  `payable` boolean NOT NULL,
  `vehicle_id` INT(10)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
