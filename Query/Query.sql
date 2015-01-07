USE Master
GO

CREATE DATABASE [ProjectManagement]
GO

USE [ProjectManagement]
GO

CREATE TABLE Department
(
	depID int primary key identity,
	DepName nvarchar(50) not null
)

CREATE TABLE Project
(
	prID int primary key identity,
	PrName nvarchar(50) not null
)

CREATE TABLE Employees
(
	username varchar(25) primary key,
	[password] varchar(25) not null,
	FullName nvarchar(50) not null,
	age varchar(50) not null,
	[address] nvarchar(100) not null,
	phone varchar(12) not null,
	depID int foreign key references Department(depID),
	prID int foreign key references Project(prID)
)