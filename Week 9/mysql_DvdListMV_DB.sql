drop database if exists dvd_list;
Create database dvd_list;

-- I want to put a dvd table here
-- what do I have to do first?
Use dvd_list;

-- Create our dvd table
Create table if not exists `dvds` (
	`dvdId` int not null auto_increment,
	`title` varchar(50) not null,
	`releaseDate` varchar(4) not null,
	`mpaaRating` varchar(5) not null,
	`directorsName` varchar(50) default null,
	`studio` varchar(50) default null,
	`userRating` varchar(50) default null,
	Primary key (`dvdId`)
);