use Northwind;

select * from Employees, Territories;

select * from Northwind.Customers C Inner Join Northwind.Orders O  on C.CustomerID = O.CustomerID where ShipCountry = "USA";

select * from Northwind.Products P  Inner join  Northwind.Orders O on P.ProductID = P.OrderID where ProductName = "Chai";