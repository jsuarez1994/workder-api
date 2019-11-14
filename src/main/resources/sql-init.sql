SELECT * FROM workder_api.rols;

SELECT * FROM workder_api.users;

SELECT * FROM workder_api.companys;

SELECT * FROM workder_api.orders;

INSERT INTO `users` (`create_at`,`update_at`,`activated`,`email`,`name`,`password`,`path_photo`,`surname`,`id_company`,`id_position`,`id_rol`) VALUES ('2019-02-18',NULL,'1','boss@mail.com','Boss','B123',NULL,'Boss',NULL,NULL,2);
INSERT INTO `users` (`create_at`,`update_at`,`activated`,`email`,`name`,`password`,`path_photo`,`surname`,`id_company`,`id_position`,`id_rol`) VALUES ('2019-02-18',NULL,'1','manager@mail.com','Manager','M123',NULL,'Manager',NULL,NULL,3);
INSERT INTO `users` (`create_at`,`update_at`,`activated`,`email`,`name`,`password`,`path_photo`,`surname`,`id_company`,`id_position`,`id_rol`) VALUES ('2019-02-18',NULL,'1','worker1@mail.com','Worker1','W123',NULL,'Worker1',NULL,NULL,4);
INSERT INTO `users` (`create_at`,`update_at`,`activated`,`email`,`name`,`password`,`path_photo`,`surname`,`id_company`,`id_position`,`id_rol`) VALUES ('2019-02-18',NULL,'0','worker2@mail.com','Worker2','W124',NULL,'Worker2',NULL,NULL,4);
INSERT INTO `users` (`create_at`,`update_at`,`activated`,`email`,`name`,`password`,`path_photo`,`surname`,`id_company`,`id_position`,`id_rol`) VALUES ('2019-02-18',NULL,'1','bossF@mail.com','BossFinal','B123',NULL,'BossFinal',NULL,NULL,2);
