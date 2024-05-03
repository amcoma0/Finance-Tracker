import java.util.ArrayList;
import java.util.Scanner;

public class Business {
    
    String businessName;
    Owner businessOwner;
    ArrayList<Employee> employees  = new ArrayList<Employee>();
    ArrayList<Project> projects  = new ArrayList<Project>();
    ArrayList<ProjectManager> projectManagers  = new ArrayList<ProjectManager>();
    
    public Business (String businessName, Owner businessOwner, ArrayList<Employee> employees, ArrayList<Project> projects, ArrayList<ProjectManager> projectManagers) {
        this.businessName = businessName;
        this.businessOwner = businessOwner;
        this.employees = employees;
        this.projects = projects;
        this.projectManagers = projectManagers;
    }

    public String getBusinessName() 
    {
        return this.businessName;
    }

    public Owner getBusinessOwner()
    {
        return this.businessOwner;
    }

    public ArrayList<Employee> getEmployees() 
    {
        return this.employees;
    }

    public ArrayList<Project> getProjects()
    {
        return this.projects;
    }

    public ArrayList<ProjectManager> getProjectManagers() 
    {
        return this.projectManagers;
    }

    public int ownerLogin(String username, String password)
    {
        if (businessOwner.getUsername().equals(username))
        {
            if (businessOwner.getPassword().equals(password))
            {
                return 1;
            }
        }
        return -1;
    }

    public int managerLogin(String username, String password)
    {
        for (int i = 0; i < projectManagers.size(); i++)
        {
            if (projectManagers.get(i).getUsername().equals(username))
            {
                if (projectManagers.get(i).getPassword().equals(password))
                {
                    return 1;
                }
            }
        }
        return -1;
    }

    public void getAllProjects()
    {
        for (int i = 0; i < projects.size(); i++)
        {
            System.out.println("Project Name: " + projects.get(i).getProjectName() + ", Project Cost: $" + projects.get(i).getProjectCost());
        }
        System.out.print("\n");
    }

    public void editProject()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which project would you like to edit the cost of? (Please select the number)");

        for (int i = 0; i < projects.size(); i++)
        {
            System.out.println((i + 1) + ". Project Name: " + projects.get(i).getProjectName() + ", Project Cost: $" + projects.get(i).getProjectCost());
        }

        int projectChoice = scanner.nextInt();

        for (int i = 0; i < projects.size(); i++)
        {
            if ((i + 1) == projectChoice)
            {
                System.out.println("What would you like the new cost of the project to be?");
                double newCost = scanner.nextDouble();

                projects.get(i).setProjectCost(newCost);
            }
        }

    }

    public void getAllEmployees()
    {
        for (int i = 0; i < employees.size(); i++)
        {
            System.out.println("Employee Name: ," + employees.get(i).getName() + "Salary: $" + employees.get(i).getSalary());
        }
    }

    public void editSalary()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Employee would you like to edit the salary of? (Please select the number)");

        for (int i = 0; i < employees.size(); i++)
        {
            System.out.println((i + 1) + ". Employee Name: " + employees.get(i).getName() + ", Salary: $" + employees.get(i).getSalary());
        }

        int employeeChoice = scanner.nextInt();

        for (int i = 0; i < employees.size(); i++)
        {
            if ((i + 1) == employeeChoice)
            {
                System.out.println("What would you like the new salary of " + employees.get(i).getName() + " to be?");
                double newSalary = scanner.nextDouble();

                employees.get(i).setSalary(newSalary);
            }
        }
    }
}