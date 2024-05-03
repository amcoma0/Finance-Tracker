public class Project {

    private String projectName;
    private double projectCost;

    public Project(String projectName, double projectCost) {
        this.projectName = projectName;
        this.projectCost = projectCost;
    }

    public void setProjectCost(double projectCost) {
        this.projectCost = projectCost;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public double getProjectCost() {
        return this.projectCost;
    }
}