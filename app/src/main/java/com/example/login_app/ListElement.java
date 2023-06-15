package com.example.login_app;

public class ListElement {
    public String equipment_type;
    public String equipment_name;
    public String reference_no;
    public String status;
    public String schedule_dateAndTime;

    public ListElement(String equipment_type, String equipment_name, String reference_no, String status, String schedule_dateAndTime) {
        this.equipment_type = equipment_type;
        this.equipment_name = equipment_name;
        this.reference_no = reference_no;
        this.status = status;
        this.schedule_dateAndTime = schedule_dateAndTime;
    }

    public String getEquipment_type() {
        return equipment_type;
    }

    public void setEquipment_type(String equipment_type) {
        this.equipment_type = equipment_type;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    public String getReference_no() {
        return reference_no;
    }

    public void setReference_no(String reference_no) {
        this.reference_no = reference_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSchedule_dateAndTime() {
        return schedule_dateAndTime;
    }

    public void setSchedule_dateAndTime(String schedule_dateAndTime) {
        this.schedule_dateAndTime = schedule_dateAndTime;
    }
}
