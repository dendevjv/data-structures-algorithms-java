package dsalgjava.ch06.progproj.pp0605;

import java.util.Scanner;

public class GroupApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of group: ");
        int groupSize = in.nextInt();
        Group group = new Group(groupSize);
        while (true) {
            System.out.print("Enter size of team (or -1): ");
            int teamSize = in.nextInt();
            if (teamSize < 0) {
                break;
            }
            System.out.println("Teams of size " + teamSize + ":");
            group.showTeams(teamSize);
        }
        in.close();
    }

}
