package com.transport.system.model;

import java.sql.Date;

public class Selectform {

    private Date dateOne;

    private Date dateTwo;

    private int stationOne;

    private int stationTwo;

    public Date getDateOne() {
        return dateOne;
    }

    public void setDateOne(Date dateOne) {
        this.dateOne = dateOne;
    }

    public Date getDateTwo() {
        return dateTwo;
    }

    public void setDateTwo(Date dateTwo) {
        this.dateTwo = dateTwo;
    }

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
