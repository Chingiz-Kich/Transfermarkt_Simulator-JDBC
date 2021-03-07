package com.company;

import com.company.controller.*;
import com.company.entities.Player;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

/*In this class, all operations are performed in our application,
through the controller we receive data from the repository taken from the database.
The code in this class makes it possible to launch and execute operations through the console.*/


public class Application {
    private final clubController clubController;
    private final playerController playerController;
    private final coachController coachController;
    private final Scanner in;


    public Application(clubController clubController, playerController playerController, coachController coachController) {
        this.clubController = clubController;
        this.playerController = playerController;
        this.coachController = coachController;
        this.in = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nWELCOME TO TRANFERMARKT SIMULATOR APP");
            System.out.println("Choose sections: ");
            System.out.println("1. Clubs");
            System.out.println("2. Players");
            System.out.println("3. Coaches");
            System.out.println("4. Transfers");
            System.out.println("0. Exit");

            System.out.print("Enter: ");
            int option = this.in.nextInt();

            try {
                if (option == 1) {
                    while (true) {
                        System.out.println("\n1. Show Information about club");
                        System.out.println("2. Show all clubs");
                        System.out.println("3. Show the price of the club by players");
                        System.out.println("0. Back");
                        try {
                            System.out.print("Enter: ");
                            int innerOption = this.in.nextInt();
                            if (innerOption == 1) {
                                System.out.print("Enter a club name: ");
                                this.in.nextLine();
                                String clubName = in.nextLine();
                                System.out.println(this.clubController.infoAboutClub(clubName));
                                continue;
                            } else if (innerOption == 2) {
                                System.out.println(this.clubController.getAllClubs());
                                continue;
                            } else if (innerOption == 3) {
                                System.out.print("Enter a club name: ");
                                this.in.nextLine();
                                String clubName = in.nextLine();
                                System.out.println("Sum of all " + clubName + " players: " +this.clubController.getClubByPlayersPrice(clubName) + "$");
                                continue;
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input!\nTry again!");
                            continue;
                        } catch (Exception e) {
                            e.printStackTrace();
                            continue;
                        }
                    }
                }
                else if (option == 2) {
                    while (true) {
                        System.out.println("\n1. Show information about player");
                        System.out.println("2. Show all players");
                        System.out.println("3. Create new young player");
                        System.out.println("4. Update player to coach");
                        System.out.println("5. End career");
                        System.out.println("0. Back");
                        try {
                            System.out.print("Enter: ");
                            int innerOption = in.nextInt();
                            if (innerOption == 1) {
                                System.out.print("Enter a player surname: ");
                                this.in.nextLine();
                                String surname = in.nextLine();
                                System.out.println(this.playerController.getInfoPlayer(surname));
                                continue;
                            } else if (innerOption == 2) {
                                System.out.print("Enter a club name: ");
                                in.nextLine();
                                String team = in.nextLine();
                                System.out.println(this.playerController.getAllPlayers(team));
                                continue;
                            } else if (innerOption == 3) {
                                System.out.println("1. Team player");
                                System.out.println("2. Free agent");
                                try {
                                    System.out.print("Enter: ");
                                    int innerOption2 = in.nextInt();
                                    if (innerOption2 == 1) {
                                        Player player = new Player();
                                        System.out.print("Enter a name: ");
                                        String name = in.next();
                                        player.setName(name);
                                        System.out.print("Enter a surname: ");
                                        in.nextLine();
                                        String surname = in.nextLine();
                                        player.setSurname(surname);
                                        System.out.print("Enter a nationality: ");
                                        String nationality = in.next();
                                        player.setNationality(nationality);
                                        System.out.println("The age of the young player will be automatically set = 18");
                                        System.out.print("Enter a position (Example: GK, CDM, ST): ");
                                        String position = in.next();
                                        if (position.length() > 3) {
                                            while (position.length() > 3) {
                                                System.out.println("Incorrect input!\nNo more than 3 letters! Example: GK- goalkeeper, CDM - central defensive midfielder");
                                                System.out.println("Try again.");
                                                System.out.print("Enter a position (Example: GK, CDM, ST): ");
                                                position = in.next();
                                            }
                                        }
                                        String positionUpper = position.toUpperCase();
                                        player.setPosition(positionUpper);
                                        System.out.println("PLEASE BE CAREFULLY!\nBEFORE INPUT NAME OF THE CLUB BE SURE THAT ENTERED CLUB IS EXIST!\n" +
                                                "YOU CAN EASILY CHECK IT IN LIST OF ALL CLUBS: Main menu -> Clubs -> Show all clubs");
                                        System.out.print("Enter a club name: ");
                                        in.nextLine();
                                        String clubName = in.nextLine();
                                        player.setTeam(clubName);
                                        System.out.println(this.playerController.createTeamPlayer(player));
                                        continue;
                                    } else if (innerOption2 == 2) {
                                        Player player = new Player();
                                        System.out.print("Enter a name: ");
                                        String name = in.next();
                                        player.setName(name);
                                        System.out.print("Enter a surname: ");
                                        in.nextLine();
                                        String surname = in.nextLine();
                                        player.setSurname(surname);
                                        System.out.print("Enter a nationality: ");
                                        String nationality = in.next();
                                        player.setNationality(nationality);
                                        System.out.println("The age of the young player will be automatically set = 18");
                                        System.out.print("Enter a position (Example: GK, CDM, ST): ");
                                        String position = in.next();
                                        if (position.length() > 3) {
                                            while (position.length() > 3) {
                                                System.out.println("Incorrect input!\nNo more than 3 letters! Example: GK- goalkeeper, CDM - central defensive midfielder");
                                                System.out.println("Try again.");
                                                System.out.print("Enter a position (Example: GK, CDM, ST): ");
                                                position = in.next();
                                            }
                                        }
                                        String positionUpper = position.toUpperCase();
                                        player.setPosition(positionUpper);
                                        System.out.println(this.playerController.createFreePlayer(player));
                                        continue;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input!\nTry again!");
                                    continue;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    continue;
                                }
                            } else if (innerOption == 4) {
                                System.out.println("BE CAREFULLY!\nBE SURE THAT ENTERED PLAYER IS EXIST AND" +
                                        " ALL SURNAME ENTERED CORRECTLY.\nONLY PLAYERS OVER THE AGE = 30 CAN " +
                                        "BECOME COACHES.");
                                System.out.print("Enter a surname of player: ");
                                String surname = in.next();
                                System.out.println(this.playerController.updateToCoach(surname));
                                continue;
                            } else if (innerOption == 5) {
                                System.out.println("BE CAREFULLY!\nBE SURE THAT ENTERED PLAYER IS EXIST AND" +
                                        " ALL SURNAME ENTERED CORRECTLY.\nAFTER THIS OPERATION PLAYER WILL " +
                                        "NEVER BE EXIST.");
                                System.out.print("Enter a surname of player: ");
                                in.nextLine();
                                String surname = in.nextLine();
                                System.out.println(this.playerController.endCareer(surname));
                                continue;
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input!\nTry again!");
                            continue;
                        } catch (Exception e) {
                            e.printStackTrace();
                            continue;
                        }
                    }
                } else if (option == 3) {
                    while (true) {
                        System.out.println("\n1. Show information about coach");
                        System.out.println("2. Show all coaches");
                        System.out.println("3. Change license");
                        System.out.println("0. Back");
                        try {
                            System.out.print("Enter: ");
                            int innerOption = in.nextInt();
                            if (innerOption == 1) {
                                System.out.print("Enter a surname of coach: ");
                                String surname = in.next();
                                System.out.println(this.coachController.getInfoCoach(surname));
                                continue;
                            } else if (innerOption == 2) {
                                System.out.println(this.coachController.getAllCoaches());
                            } else if (innerOption == 3) {
                                System.out.println("LICENSE allows coaches to coach clubs no higher than their license level");
                                System.out.println("There are 3 level of license");
                                System.out.println("1 - the high level club (Barcelona, Manchester city, Bayern and etc.)");
                                System.out.println("2 - the middle level club (Zenit, Benfica, PSV and etc.)");
                                System.out.println("3 - the low level club (Makkabi-Tel-Aviv, FC Karabakh, Legia and etc.)");
                                System.out.println("Enter a surname of a coach: ");
                                String surname = in.next();
                                System.out.println("Enter a level of license: ");
                                int license = in.nextInt();
                                if (license > 3 || license < 1) {
                                    while (license > 3 || license < 1) {
                                        System.out.println("LEVEL OF LICENSE SHOULD BE BETWEEN 1-3");
                                        System.out.println("Enter a level of license: ");
                                        license = in.nextInt();
                                    }
                                }
                                System.out.println(this.coachController.setLicense(surname, license));
                                continue;
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input!\nTry again!");
                            continue;
                        } catch (Exception e) {
                            e.printStackTrace();
                            continue;
                        }
                    }
                } else if (option == 4) {
                    while (true) {
                        System.out.println("\n1. Make a transfer");
                        System.out.println("2. Allow/Prohibit the sale of a player");
                        System.out.println("3. Change the price of a player");
                        System.out.println("4. Sack a head coach");
                        System.out.println("5. Appoint new head coach");
                        System.out.println("0. Back");
                        try {
                            System.out.print("Enter: ");
                            int innerOption = in.nextInt();
                            if (innerOption == 1) {
                                System.out.print("Enter a surname of player: ");
                                in.nextLine();
                                String surname = in.nextLine();
                                System.out.print("Enter the name of the club that buys this player ");
                                String transferTeam = in.nextLine();
                                String currentTeam = this.playerController.getTeam(surname);
                                if (currentTeam.equals(transferTeam)) {
                                    System.out.println("TRANSFER IMPOSSIBLE!\n" +
                                            surname + " already in " + transferTeam);
                                    break;
                                }
                                if (!this.playerController.getAvailable(surname)) {
                                    System.out.println(surname + " is NOT available for transfer");
                                    break;
                                }
                                long playerPrice = this.playerController.getPrice(surname);
                                long buyingСlubBudget = this.clubController.getBudget(transferTeam);
                                long sellerClubBudget = this.clubController.getBudget(currentTeam);
                                if (buyingСlubBudget < playerPrice) {
                                    System.out.println(transferTeam + " does not have enough money!\n" +
                                            "Transfer is IMPOSSIBLE");
                                    break;
                                }
                                buyingСlubBudget -= playerPrice;
                                sellerClubBudget += playerPrice;
                                if (buyingСlubBudget < 0 || sellerClubBudget < 0) {
                                    System.out.println("The transfer failed! One of the parties had financial problems.");
                                    System.out.println("Please check the budget of the clubs before making transfers.");
                                }
                                this.clubController.updateBudget(transferTeam, (int)buyingСlubBudget);
                                this.clubController.updateBudget(currentTeam, (int)sellerClubBudget);
                                System.out.println(this.playerController.setTeam(surname, transferTeam));
                                continue;
                            } else if (innerOption == 2) {
                                System.out.print("Enter a surname of player: ");
                                in.nextLine();
                                String surname = in.nextLine();
                                System.out.println("1. Allow player sale");
                                System.out.println("2. Prohibit player sale");
                                try {
                                    System.out.print("Enter: ");
                                    int innerOption2 = in.nextInt();
                                    boolean set = false;
                                    if (innerOption2 == 1) {
                                        set = true;
                                    }
                                    if (innerOption2 == 2) {
                                        set = false;
                                    } else {
                                        System.out.println("INCORRECT INPUT!\nTry again!");
                                        break;
                                    }
                                    System.out.println(this.playerController.setAvailable(surname, set));
                                    System.out.println("Changed!");
                                    continue;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input!\nTry again!");
                                    continue;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    continue;
                                }
                            } else if (innerOption == 3) {
                                System.out.println("ATTENTION! You can increase / decrease the player's price by no more than 30% of the current value.");
                                System.out.println("ATTENTION! Players over 30 cannot increase the transfer amount.");
                                System.out.print("Enter a surname of a player: ");
                                in.nextLine();
                                String surname = in.nextLine();
                                System.out.println("1. Increase price");
                                System.out.println("2. Decrease the price");
                                try {
                                    System.out.print("Choose(1 or 2): ");
                                    int innerOption2 = in.nextInt();
                                    if (innerOption2 == 1) {
                                        if (this.playerController.getAge(surname) > 30) {
                                            System.out.println("IMPOSSIBLE! " + surname + " over 30 years old.");
                                            break;
                                        }
                                        System.out.print("How much percentage do you want to increase " +
                                                surname + "'s value (max 30%): ");
                                        int percent = in.nextInt();
                                        if (percent > 30) {
                                            while (percent > 30) {
                                                System.out.println("IMPOSSIBLE! No more than 30%");
                                                System.out.print("Input again: ");
                                                percent = in.nextInt();
                                            }
                                        }
                                        int newValue = (this.playerController.getPrice(surname) * percent / 100) + this.playerController.getPrice(surname);
                                        System.out.println(this.playerController.setPrice(surname, newValue));
                                        continue;
                                    } else if (innerOption2 == 2) {
                                        System.out.print("How much percentage do you want to deacrease " +
                                                surname + "'s value (max 30%): ");
                                        int percent = in.nextInt();
                                        if (percent > 30) {
                                            while (percent > 30) {
                                                System.out.println("IMPOSSIBLE! No more than 30%");
                                                System.out.print("Input again: ");
                                                percent = in.nextInt();
                                            }
                                        }
                                        int newValue = this.playerController.getPrice(surname) - (this.playerController.getPrice(surname) * percent / 100);
                                        System.out.println(this.playerController.setPrice(surname, newValue));
                                        continue;
                                    } else {
                                        System.out.println("Invalid choose!");
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input!\nTry again!");
                                    continue;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    continue;
                                }
                            } else if (innerOption == 4) {
                                System.out.print("Enter name of the team you want to sack the head coach: ");
                                in.nextLine();
                                String team = in.nextLine();
                                System.out.println(this.coachController.sackingCoach(team));
                                continue;
                            } else if (innerOption == 5) {
                                System.out.print("Enter a club name: ");
                                in.nextLine();
                                String team = in.nextLine();
                                System.out.println(this.coachController.sackingCoach(team));
                                System.out.print("Enter a surname of a new head coach: ");
                                String surname = in.next();
                                System.out.println(this.coachController.setTeam(surname, team));
                                continue;
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input!\nTry again!");
                            continue;
                        } catch (Exception e) {
                            e.printStackTrace();
                            continue;
                        }
                    }
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!\nTry again!");
                continue;
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
