DROP TABLE Reviews;
DROP TABLE Authors;
DROP TABLE Users;
DROP TABLE Articles;
DROP TABLE Levels;

CREATE TABLE Levels(
	IdLevel SERIAL PRIMARY KEY,
	Access varchar(100)
);

CREATE TABLE Users(
	IdUser SERIAL PRIMARY KEY, 
	Name varchar(50),
	LastName varchar(50),
    Email varchar(50),
	Login varchar(50),
	Password varchar(50),
	CreatedAt Date,
	UpdatedAt Date,
	Enabled boolean,
	Sex varchar(1),
	Birth Date,
	Residence varchar(100),
	Education varchar(200),
	WorkPlace varchar(200),
	Position varchar(100),
	Passport varchar(100),
	IssuedBy varchar(200),
	AdrressReg varchar(200),
	AccessLevel integer REFERENCES Levels,
	UNIQUE(Login,Email)
);
CREATE TABLE Articles(
	IdArticle SERIAL PRIMARY KEY, 
	Title varchar(100),
	Subject varchar(100),
	DontPubl boolean,
    PathArticle varchar(100),
	PathAnnotRus varchar(100),
	PathAnnotEng varchar(100),
	PathListLiter varchar(100),
	DateSend Date,
	DateAdoption Date,
	DatePubl Date,
	URL varchar(100),
	UNIQUE(Title)
);

CREATE TABLE Reviews(
	IdReview SERIAL PRIMARY KEY, 
	IdUser Integer REFERENCES Users,
	IdArticle Integer REFERENCES Articles,
    PathReview varchar(100),
	DateOfReceipt Date,
	DateReview Date
);

CREATE TABLE Authors(
	IdAuthor SERIAL PRIMARY KEY, 
	IdUser Integer REFERENCES Users,
	IdArticle Integer REFERENCES Articles
);

