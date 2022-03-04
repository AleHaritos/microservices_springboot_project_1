CREATE TABLE `traffic_ticket` (
  `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
  `type_infraction` longtext NOT NULL,
  `price` decimal(65,2) NOT NULL,
  `payable` boolean DEFAULT true,
  `vehicle_id` INT(10)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `traffic_ticket` ADD CONSTRAINT FK_VEHICLE_TICKET FOREIGN KEY(vehicle_id)  REFERENCES `vehicle`(id);