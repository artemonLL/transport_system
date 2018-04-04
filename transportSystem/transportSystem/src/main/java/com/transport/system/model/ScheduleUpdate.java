package com.transport.system.model;

import java.sql.Timestamp;

/**
 *The class for using at JSP page to Edit {@link Schedule}.
 */

public class ScheduleUpdate
{
    private String new_id;
    private Timestamp date_time;

    public String getNew_id() {
        return new_id;
    }

    public void setNew_id(String new_id) {
        this.new_id = new_id;
    }



    @Override
    public int hashCode() {
        int result =new_id!= null ? new_id.hashCode() : 0;
        result = 31 * result + (date_time != null ? date_time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ScheduleUpdate{" +
                "schedule_id='" + new_id + '\'' +
                ", date_time=" + date_time +
                '}';
    }


    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }


}
