package stasVasechko;

public class Company {

    private Company parent;
    private long employeeCount;

    public Company(Company parent, long employeeCount) {
        this.parent = parent;
        this.employeeCount = employeeCount;
    }

    public Company getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Company{" +
                "parent = " + parent +
                '}';
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }
}
