import java.util.*;

class SpringSeason {
    boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt(), day = sc.nextInt();
        SpringSeason season = new SpringSeason();
        System.out.println(season.isSpringSeason(month, day) ? "Its a Spring Season" : "Not a Spring Season");
    }
}
