Drop database if exists contact_list_test;
Create database contact_list_test;

-- I want to put a contact table here
-- what do I have to do first?
Use contact_list_test;

-- Create our contacts table
Create table if not exists `contacts` (
	`contact_id` int not null auto_increment,
	`first_name` varchar(50) not null,
	`last_name` varchar(50) not null,
	`company` varchar(50) not null,
	`phone` varchar(10) default null,
	`email` varchar(50) not null,
	Primary key (`contact_id`)
);