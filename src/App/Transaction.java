package App;

public class Transaction {
    private String Name;
    private double revenue;
    private String description;

    public Transaction(String name, double revenue) {
        Name = name;
        this.revenue = revenue;
    }

    public Transaction(String name, double revenue, String description) {
        Name = name;
        this.revenue = revenue;
        this.description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
