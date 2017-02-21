INSERT INTO Levels(IdLevel,Access)VALUES
(1,'Admin'),
(2,'Moderator'),
(3,'Reviewer'),
(4,'Author');

INSERT INTO Users(IdUser,Name,LastName,Email,Login,Password,CreatedAt,UpdatedAt,Enabled,Sex,Birth,
Residence,Education,WorkPlace,Position,Passport,IssuedBy,AdrressReg,AccessLevel) VALUES
(1, 'Ivan', 'Ivanov', 'i.ivanov.stc@innopolis.ru', 'ivanovstc', '12345', '08-Jan-2017', '08-Jan-2017', 'true', 'м', '10-Jan-1987', 'Казань, улица Хансувар, 53', 
'Казанский государственный медицинский университет,2008, лечебное дело','Городская клиническая больница № 7','Окулист','6804 345678', 'отделом УФМС России по Свердловской области в Ленинском р-не гор. Екатеринбурга','Казань, улица Хансувар, 53',2),
(2, 'Petr', 'Petrov', 'p.petrov.stc@innopolis.ru', 'petrovstc', '12345', '10-Jan-2017', '10-Jan-2017', 'true', 'м', '01-Aug-1986', 'Казань, улица Хансувар, 52', 
'Казанский государственный медицинский университет,2007, лечебное дело','Городская клиническая больница № 7','Хирург','3453 345678', 'отделом УФМС России по Оренбургской области','Казань, улица Хансувар, 52',3),
(3, 'Sergei', 'Sergeev', 's.sergeev.stc@innopolis.ru', 'sergeevstc', '12345', '12-Jan-2017', '14-Jan-2017', 'true', 'м', '01-Sep-1990', 'Казань, улица Хансувар, 23','Казанский государственный медицинский университет,2015, лечебное дело','Городская клиническая больница № 7','Хирург','3453 345678', 'отделом УФМС России по Оренбургской области','Казань, улица Хансувар, 23',4),
(4, 'Valentina', 'Sergeeva', 'v.sergeeva.stc@innopolis.ru', 'sergeevastc', '12345', '25-Jan-2017', '30-Jan-2017', 'true', 'м', '10-Dec-1991', 'Казань, улица Хансувар, 11','Казанский государственный медицинский университет,2016, лечебное дело','Городская клиническая больница № 7','Хирург','3453 345678', 'отделом УФМС России по Оренбургской области','Казань, улица Хансувар, 11',4);

INSERT INTO Articles(IdArticle,Title,Subject,DontPubl,PathArticle,PathAnnotRus,PathAnnotEng,PathListLiter,DateSend,DateAdoption,DatePubl,URL) VALUES 
(1,'Хирургическое лечение ожирения','Хирургия', 'true', 'C:\Articles\Article', 'C:\Articles\AnnotRus','C:\Articles\AnnotEng', 'C:\Articles\ListLiter','12-Jan-2017', '14-Jan-2017', '18-Jan-2017','http:\\articles\sugery\01'),
(2,'Познакомьтесь с хирургом по раньше!','Хирургия', 'true', 'C:\Articles\Article1', 'C:\Articles1\AnnotRus1','C:\Articles1\AnnotEng1', 'C:\Articles1\ListLiter1','25-Jan-2017', '30-Jan-2017', '02-Feb-2017','http:\\articles\sugery\02');

INSERT INTO Reviews(IdReview,IdUser,IdArticle,PathReview,DateOfReceipt,	DateReview) VALUES
(1,2,1,'C:\Articles\Review','12-Jan-2017','14-Jan-2017'),
(2,2,2,'C:\Articles\Review1','28-Jan-2017','30-Jan-2017');
INSERT INTO Authors(IdAuthor,IdUser,IdArticle)VALUES
(1,3,1),
(2,4,2);
