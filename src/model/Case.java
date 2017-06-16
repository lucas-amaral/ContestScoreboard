package model;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Lucas on 16/06/2017.
 */
public class Case {
    private Integer number;
    private Map<Integer, Contestant> contestants = new TreeMap<>();

    public Case(Integer number) {
        this.number = number;
    }

    public Map<Integer, Contestant> getContestants() {
        return contestants;
    }

    public void setContestants(Map<Integer, Contestant> contestants) {
        this.contestants = contestants;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
