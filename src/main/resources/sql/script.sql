
CREATE TABLE `t_user` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `user_name` varchar(255) DEFAULT NULL,
                          `nick_name` varchar(255) DEFAULT NULL,
                          `password` varchar(255) DEFAULT NULL,
                          `phone` varchar(255) DEFAULT NULL,
                          `sex` char(1) DEFAULT NULL,
                          `age` int(11) DEFAULT NULL,
                          `address` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `t_user`(`id`, `user_name`, `nick_name`, `password`, `phone`, `sex`, `age`, `address`) VALUES (1, 'hgq', 'huangguoqiang', '202cb962ac59075b964b07152d234b70', '', '1', 20, '建邺区');

