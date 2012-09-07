CREATE TABLE IF NOT EXISTS `gedcom` (
  `gedcom_id` int(11) NOT NULL auto_increment,
  `title` varchar(250) NOT NULL default '',
  `file_name` varchar(250) NOT NULL default '',
  `file_type` varchar(15) NOT NULL default '',
  `file_size` varchar(45) NOT NULL default '',
  `file_content` longblob NOT NULL,
  `file_extension` varchar(10) NOT NULL default '',
  PRIMARY KEY  (`gedcom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
