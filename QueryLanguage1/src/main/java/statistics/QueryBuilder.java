package statistics;

import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.PlaysIn;

public class QueryBuilder {

    PlaysIn olio;
    HasAtLeast olio2;
    HasFewerThan olio3;
    
    public QueryBuilder() {

    }

    QueryBuilder playsIn(String joukkue) {
        this.olio = new PlaysIn(joukkue);
       return this;
    }

    QueryBuilder hasAtLeast(int lkm, String mita) {
        this.olio2 = new HasAtLeast(lkm, mita);
        return this;
    }

    QueryBuilder hasFewerThan(int lkm, String mita) {
        this.olio3 = new HasFewerThan(lkm, mita);
        return this;
    }

    QueryBuilder build() {
        Matcher m = new And(olio, olio2, olio3);
        return this;
    }
}
