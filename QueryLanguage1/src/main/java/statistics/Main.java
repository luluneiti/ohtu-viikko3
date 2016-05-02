package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        /* Matcher m = new And(new HasAtLeast(10, "goals"),
         new HasAtLeast(10, "assists"),
         new PlaysIn("PHI")
         );

         for (Player player : stats.matches(m)) {
         System.out.println(player);
         }
         Matcher m2 = new And(new HasFewerThan(25, "goals")
         );

         for (Player player : stats.matches(m2)) {
         System.out.println(player);
         }

         Matcher m3 = new Or(new HasAtLeast(10, "goals"),
         new PlaysIn("PHI")
         );

         for (Player player : stats.matches(m3)) {
         System.out.println(player);
         }*/
        QueryBuilder query = new QueryBuilder();

        Matcher m4 = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();
        );
        
        for (Player player : stats.matches(m4)) {
            System.out.println(player);
        }
    }
}
