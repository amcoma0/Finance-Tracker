import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.ArrayList;


public class Driver {

    public static void main(String[] args)
    {
        


        try{
            ArrayList<ProjectManager> projectManagers = new ArrayList<ProjectManager>();
            ArrayList<Project> projects = new ArrayList<Project>();
            ArrayList<Employee> employees = new ArrayList<Employee>();

            BufferedReader reader = new BufferedReader(new FileReader("Owner.txt"));
            String ownerData = reader.readLine();
            String[] ownerAttributes = ownerData.split(",");
            Owner owner = new Owner(Integer.parseInt(ownerAttributes[0]), ownerAttributes[1], ownerAttributes[2], ownerAttributes[3]);
            reader.close();

            BufferedReader managerReader = new BufferedReader(new FileReader("ProjectManagers.txt"));
            String projectManagerData;
            while ((projectManagerData = managerReader.readLine()) != null)
            {
                String[] managerAttributes = projectManagerData.split(",");
                
                ProjectManager projectManager = new ProjectManager(Integer.parseInt(managerAttributes[0]), managerAttributes[1], managerAttributes[2], managerAttributes[3]);
                projectManagers.add(projectManager);
            }
            managerReader.close();

            BufferedReader employeeReader = new BufferedReader(new FileReader("Employees.txt"));
            String employeeData;
            while ((employeeData = employeeReader.readLine()) != null)
            {
                String[] employeeAttributes = employeeData.split(",");
                
                Employee employee = new Employee(Integer.parseInt(employeeAttributes[0]), employeeAttributes[1], Double.parseDouble(employeeAttributes[2]));
                employees.add(employee);
            }
            employeeReader.close();

            BufferedReader projectsReader = new BufferedReader(new FileReader("Projects.txt"));
            String projectData;
            while ((projectData = projectsReader.readLine()) != null)
            {
                String[] projectAttributes = projectData.split(",");
                
                Project project = new Project(projectAttributes[0], Double.parseDouble(projectAttributes[1]));
                projects.add(project);
            }
            projectsReader.close();
            
            Business business = new Business("SoftwareForNoobs", owner, employees, projects, projectManagers);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to McComas Financial!");
            System.out.println("\nAre you an Owner or a Project Manager? (O/P)");
            String person = scanner.nextLine();
            System.out.print("\n");
            boolean isOwner = false;
            boolean isManager = false;

            int login = -1;
            while (login == -1) {
                System.out.println("Username: ");
                String username = scanner.nextLine();
                System.out.println("Password: ");
                String password = scanner.nextLine();

                if (person.toUpperCase().equals("O"))
                {
                    login = business.ownerLogin(username, password);
                    if (login == -1)
                    {
                        System.out.println("Failure to login. Please try again.");
                        System.out.print("\n");
                    }
                    isOwner = true;
                }
                else if (person.toUpperCase().equals("P"))
                {
                    login = business.managerLogin(username, password);
                    if (login == -1)
                    {
                        System.out.println("Failure to login. Please try again.");
                        System.out.print("\n");
                    }
                    isManager = true;
                }
            }

            System.out.println("-----------------------------------------------------------");
            System.out.println("Welcome to your financial management software!");
            System.out.println("-----------------------------------------------------------");
            System.out.print("\n");

            int keepGoing = 1;
            while (keepGoing == 1) 
            {
                System.out.println("Would you like to view the Projects or Employees? (Type the corresponding number)");
                System.out.println("1.  Projects");
                System.out.println("2.  Employees");
                System.out.println("3. Exit");
                System.out.print("\n");
                int sectionSelect = scanner.nextInt();
                System.out.print("\n");

                if (sectionSelect == 1)
                {
                    System.out.println("Would you like to view or edit the Project financials? (Type the corresponding number)");
                    System.out.println("1.  View");
                    System.out.println("2.  Edit");
                    System.out.print("\n");
                    int viewChoice = scanner.nextInt();
                    System.out.print("\n");

                    if (viewChoice == 1)
                    {
                        business.getAllProjects();
                    }
                    else if (viewChoice == 2)
                    {
                        business.editProject();
                    }
                }
                else if (sectionSelect == 2)
                {
                    System.out.println("Would you like to view or edit the Employee financials? (Type the corresponding number)");
                    System.out.println("1.  View");
                    System.out.println("2.  Edit");
                    int viewChoice = scanner.nextInt();
                    System.out.print("\n");

                    if (viewChoice == 1)
                    {
                        business.getAllEmployees();
                    }
                    else if (viewChoice == 2)
                    {
                        if (isOwner == false)
                        {
                            System.out.println("");
                        }
                        business.editSalary();
                    }
                }
                else if (sectionSelect == 3)
                {
                    System.out.println("Thank you for visiting! Come again!");
                    keepGoing = 2;
                }    
            }

            FileWriter projectsWriter = new FileWriter("Projects.txt");
            ArrayList<Project> updatedProjects = business.getProjects();
            for (int i = 0; i < updatedProjects.size(); i++)
            {
                if (i == 0)
                {
                    String projectInfo = updatedProjects.get(i).getProjectName() + "," + updatedProjects.get(i).getProjectCost();
                    projectsWriter.write(projectInfo);
                }
                else {
                    String projectInfo = "\n" + updatedProjects.get(i).getProjectName() + "," + updatedProjects.get(i).getProjectCost();
                    projectsWriter.write(projectInfo);
                }
            }
            projectsWriter.close();

            FileWriter employeeWriter = new FileWriter("Employees.txt");
            ArrayList<Employee> updatedEmployees = business.getEmployees();
            for (int i = 0; i < updatedEmployees.size(); i++)
            {
                if (i == 0)
                {
                    String employeeInfo = updatedEmployees.get(i).getUserID() + "," + updatedEmployees.get(i).getName() + "," + updatedEmployees.get(i).getSalary();
                    employeeWriter.write(employeeInfo);
                }
                else {
                    String employeeInfo = "\n" + updatedEmployees.get(i).getUserID() + "," + updatedEmployees.get(i).getName() + "," + updatedEmployees.get(i).getSalary();
                    employeeWriter.write(employeeInfo);
                }
            }
            employeeWriter.close();

            scanner.close();
        }
        catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        
    }
}