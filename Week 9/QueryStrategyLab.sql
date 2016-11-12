Use SWCCorp;

Update Employee set LastName = "Green" Where EmpId = 11;

Update Employee set status = "External" where LocationId = 4;

Update Location set Street = "111 First ST" where Street = "111 1st Ave";

Delete from MgmtTraining where ClassDurationHours > 20;

select * from MgmtTraining;

select * from Location;

select * from Employee, Location;

SELECT * FROM Employee 
WHERE EmpID NOT IN (SELECT `GrantID` FROM `Grant`);