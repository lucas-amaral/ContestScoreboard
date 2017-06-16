package model;

import java.util.*;

/**
 * Created by Lucas on 22/02/2016.
 */
public class Contestant implements Comparable<Contestant> {
    Integer number;
    Integer time = 0;
    Set<Integer> problems = new LinkedHashSet<>();

    public Contestant(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<Integer> getProblems() {
        return problems;
    }

    public void setProblems(Set<Integer> problems) {
        this.problems = problems;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getNumberOfProblems() {
        return problems.size();
    }

    @Override
    public int compareTo(Contestant o) {
        if (getNumberOfProblems() < o.getNumberOfProblems()) {
            return 1;
        } else if (getNumberOfProblems().equals(o.getNumberOfProblems())) {
            if (getTime() < o.getTime()) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }
}
