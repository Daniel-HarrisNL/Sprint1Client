package com.sprint.client.Menu;



import com.sprint.client.Member.MemberClient;
import com.sprint.client.Tournament.TournamentClient;

import java.util.Scanner;

public class Navigation {

    public static String crudSelector(String menu){
        System.out.println("Press one of the following keys");
        System.out.println("L - List all " + menu + "s");
        System.out.println("A - Add new " + menu);
        System.out.println("S - Search for " + menu);
        System.out.println("D - Delete " + menu);
        System.out.println("U - Update " + menu);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void memberMenu(){
        Scanner scanner = new Scanner(System.in);
        String selection = crudSelector("Member").toUpperCase();
        switch (selection){

            case "L":
                System.out.println(MemberClient.getAllMembers());
                break;

            case "A":
                System.out.println("Fill in the following fields:");
                System.out.println("First Name: ");
                String fname = scanner.nextLine();
                System.out.println("Last Name: ");
                String lname = scanner.nextLine();
                System.out.println("Address: ");
                String address = scanner.nextLine();
                System.out.println("Email: ");
                String email = scanner.nextLine();
                System.out.println("Phone: ");
                String phone = scanner.nextLine();
                System.out.println("Date Registered: ");
                String startDate = scanner.nextLine();
                System.out.println("Duration: ");
                String duration = scanner.nextLine();
                System.out.println("Membership type: ");
                String membership = scanner.nextLine();

                MemberClient.postMember(fname,lname,address,email,phone,startDate,duration,membership);
                System.out.println("Member added!");
                break;

            case "S":
                System.out.println("Press I to search by ID, or N to search by First Name");
                String queryType = scanner.nextLine().toUpperCase();
                switch (queryType){
                    case "I":
                        System.out.println("Enter the ID to search: ");
                        long id = Long.parseLong(scanner.nextLine());
                        System.out.println(MemberClient.getMemberById(id));
                        break;
                    case "N":
                        System.out.println("Enter the name to search: ");
                        String name = scanner.nextLine();
                        System.out.println(MemberClient.getMemberByFirstName(name));
                        break;
                    default:
                        System.out.println("Wrong input, must select query type.");
                }
                break;

            case "D":
                System.out.println("Enter the ID of the member to delete: ");
                long idDelete = Long.parseLong(scanner.nextLine());
                MemberClient.deleteMemberById(idDelete);
                System.out.println("Member deleted!");
                break;

            case "U":
                System.out.println("Enter the ID of the member to update: ");
                long id = Long.parseLong(scanner.nextLine());

                System.out.println("Fill in the following fields:");
                System.out.println("First Name: ");
                String fnameNew = scanner.nextLine();
                System.out.println("Last Name: ");
                String lnameNew = scanner.nextLine();
                System.out.println("Address: ");
                String addressNew = scanner.nextLine();
                System.out.println("Email: ");
                String emailNew = scanner.nextLine();
                System.out.println("Phone: ");
                String phoneNew = scanner.nextLine();
                System.out.println("Date Registered: ");
                String startDateNew = scanner.nextLine();
                System.out.println("Duration: ");
                String durationNew = scanner.nextLine();
                System.out.println("Membership type: ");
                String membershipNew = scanner.nextLine();

                MemberClient.putMemberById(id,fnameNew,lnameNew,addressNew,emailNew,phoneNew,startDateNew,durationNew,membershipNew);
                System.out.println("Member updated!");
                break;

            default:
                System.out.println("Incorrect selection.");
        }
    }

    public static void tournamentMenu(){
        Scanner scanner = new Scanner(System.in);
        String selection = crudSelector("Tournament").toUpperCase();
        switch (selection){
            case "L":
                System.out.println(TournamentClient.getAllTournaments());
                break;

            case "A":
                System.out.println("Fill in the following fields:");
                System.out.println("Heading: ");
                String heading = scanner.nextLine();
                System.out.println("Start Date: ");
                String startDate = scanner.nextLine();
                System.out.println("End Date: ");
                String endDate = scanner.nextLine();
                System.out.println("Location: ");
                String location = scanner.nextLine();
                System.out.println("Fee: ");
                double fee = Double.parseDouble(scanner.nextLine());
                System.out.println("Prize: ");
                double prize = Double.parseDouble(scanner.nextLine());


                TournamentClient.postTournament(heading, startDate, endDate, location, fee, prize);
                System.out.println("Tournament added!");
                break;

            case "S":
                System.out.println("Press I to search by ID, or H to search by Heading");
                String queryType = scanner.nextLine().toUpperCase();
                switch (queryType){
                    case "I":
                        System.out.println("Enter the ID to search: ");
                        long id = Long.parseLong(scanner.nextLine());
                        System.out.println(TournamentClient.getTournamentById(id));
                        break;
                    case "H":
                        System.out.println("Enter the heading to search: ");
                        String headingQuery = scanner.nextLine();
                        System.out.println(TournamentClient.getTournamentByHeading(headingQuery));
                        break;
                    default:
                        System.out.println("Wrong input, must select query type.");
                }
                break;

            case "D":
                System.out.println("Enter the ID of the tournament to delete: ");
                long idDelete = Long.parseLong(scanner.nextLine());
                TournamentClient.deleteTournamentById(idDelete);
                System.out.println("Tournament deleted!");
                break;

            case "U":
                System.out.println("Enter the ID of the tournament to update: ");
                long id = Long.parseLong(scanner.nextLine());

                System.out.println("Fill in the following fields:");
                System.out.println("Heading: ");
                String headingNew = scanner.nextLine();
                System.out.println("Start Date: ");
                String startDateNew = scanner.nextLine();
                System.out.println("End Date: ");
                String endDateNew = scanner.nextLine();
                System.out.println("Location: ");
                String locationNew = scanner.nextLine();
                System.out.println("Fee: ");
                double feeNew = Double.parseDouble(scanner.nextLine());
                System.out.println("Prize: ");
                double prizeNew = Double.parseDouble(scanner.nextLine());
                System.out.println("Standings: ");
                String standingsNew = scanner.nextLine();
                System.out.println("Status: ");
                String statusNew = scanner.nextLine();


                TournamentClient.putTournamentById(id, headingNew, startDateNew, endDateNew, locationNew, feeNew, prizeNew, standingsNew, statusNew);
                System.out.println("Tournament updated!");
                break;

            default:
                System.out.println("Incorrect selection.");
        }
    }
}
