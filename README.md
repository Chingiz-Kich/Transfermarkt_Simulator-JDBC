# Transfermarkt_Simulator-JDBC
Project Transfermarkt Simulator. Using JDBC.

This is Transfermarkt Simulator App implemented through the console. It is connected with database that contains information about football clubs, their players and coaches. So, the idea of the programm is to allow user manipulate with this data. In real world there happen some transfers, for example. This programm could implement transfer of player from one club to another counting the budjet of clubs and price of the players. User sees control elements in console of IDE. Menu consists of sections:
1. Clubs
2. Players
3. Coaches
4. Transfers
0. Exit

In each section user could manipulate with the related data. For instance, in clubs section you can get all the interested information about clubs and in transfers section you can implement transfers of players and coaches. All changes are performing in database, as well. Club has list of player, coach and budjet. Each player has a price. When transfer is happening this cost is substractin from purchaser club budjet and adding to seller club.

Main classes of program are Club, Coach and PLayer. Coach and PLayer extend Person base class. Mostly, this classes contain standart getter and setter methods that are used in repositories. Each main class has its own repository which has its own interface. Main functionality of program is there. Repositories implements interfaces. All this methods implemented in repositories are to be called in controllers for each main class. Controllers processes methods from repositories and use results to output appropriate messages in console. Then controllers are used in Application class where interface of the program is located. From Main class we call start method from Application that launch the programm.
