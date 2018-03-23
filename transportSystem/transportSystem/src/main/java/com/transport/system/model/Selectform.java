package com.transport.system.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Selectform {

    private Timestamp dateOne;

    private Timestamp dateTwo;

    public Timestamp getDateOne() {
        return dateOne;
    }

    public void setDateOne(Timestamp dateOne) {
        this.dateOne = dateOne;
    }

    public Timestamp getDateTwo() {
        return dateTwo;
    }

    public void setDateTwo(Timestamp dateTwo) {
        this.dateTwo = dateTwo;
    }

    private int stationOne;

    private int stationTwo;



    public int getStationOne() {
        return stationOne;
    }

    public void setStationOne(int stationOne) {
        this.stationOne = stationOne;
    }

    public int getStationTwo() {
        return stationTwo;
    }

    public void setStationTwo(int stationTwo) {
        this.stationTwo = stationTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Selectform that = (Selectform) o;

        if (stationOne != that.stationOne) return false;
        if (stationTwo != that.stationTwo) return false;
        if (dateOne != null ? !dateOne.equals(that.dateOne) : that.dateOne != null) return false;
        return dateTwo != null ? dateTwo.equals(that.dateTwo) : that.dateTwo == null;
    }

    @Override
    public int hashCode() {
        int result = dateOne != null ? dateOne.hashCode() : 0;
        result = 31 * result + (dateTwo != null ? dateTwo.hashCode() : 0);
        result = 31 * result + stationOne;
        result = 31 * result + stationTwo;
        return result;
    }

    @Override
    public String toString() {
        return "Selectform{" +
                "dateOne=" + dateOne +
                ", dateTwo=" + dateTwo +
                ", stationOne=" + stationOne +
                ", stationTwo=" + stationTwo +
                '}';
    }
}
