package App;

public class Event {
    private String name;
    private double revenue;
    private int attendees;
    private String Description;

    public Event(String name, double revenue) {
        this.name = name;
        this.revenue = revenue;
    }

    public Event(String name, double revenue, int attendees) {
        this.name = name;
        this.revenue = revenue;
        this.attendees = attendees;
    }

    public Event(String name, double revenue, int attendees, String description) {
        this.name = name;
        this.revenue = revenue;
        this.attendees = attendees;
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
