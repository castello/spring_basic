CREATE TABLE `board` (
`bno` int(11) NOT NULL AUTO_INCREMENT,
`title` varchar(45) NOT NULL,
`content` text NOT NULL,
`writer` varchar(30) DEFAULT NULL,
`view_cnt` int(11) DEFAULT '0',
`comment_cnt` int(11) DEFAULT '0',
`reg_date` datetime DEFAULT CURRENT_TIMESTAMP,
`up_date` datetime DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
