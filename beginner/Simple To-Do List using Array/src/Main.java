import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Task> tasks = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        showMenu(scanner,tasks);

        scanner.close();


    }

    public static void showMenu(Scanner scanner,ArrayList<Task> tasks){

        boolean isValid = false;
        int option = 0;

        while (!isValid){
            System.out.println("============== To-Do List ================");
            System.out.println("1 - Enter a new task");
            System.out.println("2 - List all tasks");
            System.out.println("3 - Check a task as completed");
            System.out.println("4 - Delete a task");
            System.out.println("5 - Edit a task");
            System.out.println("6 - Filter By Category / Priority");
            System.out.println("0 - Quit");

            if (scanner.hasNextInt()){
                option = scanner.nextInt();
                if (option == 0) {
                    System.out.println("Exiting... 👋");
                    return;
                } else if (option >= 1 && option <= 6) {
                    isValid = true;
                } else {
                    System.out.println("Choose a valid option between 1 and 5");
                }


            }
            else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }

        }

        switch (option){
            case 1:
                EnterNewTask(tasks,scanner);
                showMenu(scanner,tasks);
                break;
            case 2:
                ListAllTasks(tasks);
                showMenu(scanner,tasks);
                break;
            case 3:
                if(CheckTaskAsCompleted(tasks,scanner)){
                    System.out.println("Taks has been sucessfully checked");
                }else {
                    System.out.println("There is no task with the given ID");
                }
                showMenu(scanner,tasks);
                break;
            case 4:
                if(DeleteTask(tasks,scanner)){
                    System.out.println("Task has been successfully deleted");
                }else {
                    System.out.println("There is no task with the given ID");
                }
                showMenu(scanner,tasks);
                break;
            case 5:
                EditTask(tasks,scanner);
                showMenu(scanner,tasks);
                break;
            case 6:
                FilterByCategoryOrPriority(tasks,scanner);
                showMenu(scanner,tasks);
                break;

        }




    }

    public static void EnterNewTask(ArrayList<Task> tasks, Scanner scanner) {
        scanner.nextLine();

        System.out.println("Please enter the description of the task:");
        String description = scanner.nextLine();

        Priorities priorities = null;
        Category categories = null;


        while (priorities == null) {
            System.out.println("Choose a Priority:");
            System.out.println("    1 - LOW\n    2 - MEDIUM\n    3 - HIGH");

            if (scanner.hasNextInt()) {
                int priority = scanner.nextInt();
                switch (priority) {
                    case 1 -> priorities = Priorities.LOW;
                    case 2 -> priorities = Priorities.MEDIUM;
                    case 3 -> priorities = Priorities.HIGH;
                    default -> System.out.println("Please choose a valid option.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }


        while (categories == null) {
            System.out.println("Choose a Category:");
            System.out.println("    1 - PERSONAL\n    2 - WORK\n    3 - STUDY\n    4 - SHOPPING\n    5 - OTHER");

            if (scanner.hasNextInt()) {
                int category = scanner.nextInt();
                switch (category) {
                    case 1 -> categories = Category.PERSONAL;
                    case 2 -> categories = Category.WORK;
                    case 3 -> categories = Category.STUDY;
                    case 4 -> categories = Category.SHOPPING;
                    case 5 -> categories = Category.OTHER;
                    default -> System.out.println("Please choose a valid option.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }

        Task task = new Task(description, LocalDate.now(), priorities, categories);
        tasks.add(task);
        System.out.println("✅ Task successfully added!\n");
    }


    public static void ListAllTasks(ArrayList<Task> tasks){
        if (tasks.isEmpty()){
            System.out.println("There are no tasks in the List");
        }
        else {
            for(Task task : tasks){
                System.out.println(task.toString());
            }
        }

    }

    public static boolean  CheckTaskAsCompleted(ArrayList<Task> tasks,Scanner scanner){
        if (tasks.isEmpty()){
            System.out.println("There are no tasks in the List");
            return false;
        }

        System.out.println("Choose the ID of the task");
        for(Task task : tasks){
            System.out.println(task.toString());
        }

        if (scanner.hasNextInt()){
            int id = scanner.nextInt();

            for(Task task : tasks){
                if (task.getId() == id){
                    task.setDone(true);
                    return  true;
                }
            }
        }else {
            System.out.println("Please enter a valid number");
            scanner.next();
        }

        return false;
    }

    public static boolean DeleteTask(ArrayList<Task> tasks, Scanner scanner){
        if (tasks.isEmpty()){
            System.out.println("There are no tasks in the List");
            return false;
        }

        System.out.println("Choose the ID of the task you want to delete");
        for(Task task : tasks){
            System.out.println(task.toString());
        }

        if (scanner.hasNextInt()){
            int id = scanner.nextInt();

            return tasks.removeIf(task -> task.getId() == id);

            }
        else {
            System.out.println("Please enter a valid number");
            scanner.next();
        }
        return false;
    }

    public static boolean EditTask(ArrayList<Task> tasks, Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks in the list.");
            return false;
        }

        System.out.println("Choose the ID of the task you want to edit:");
        for (Task task : tasks) {
            System.out.println(task.toString());
        }

        Task taskToEdit = null;

        if (scanner.hasNextInt()) {
            int id = scanner.nextInt();
            scanner.nextLine();


            for (Task task : tasks) {
                if (task.getId() == id) {
                    taskToEdit = task;
                    break;
                }
            }

            if (taskToEdit == null) {
                System.out.println("No task found with the provided ID.");
                return false;
            }


            System.out.println("Enter the new description for the task:");
            String description = scanner.nextLine();


            Priorities priority = null;
            while (priority == null) {
                System.out.println("Choose a Priority:");
                System.out.println("    1 - LOW\n    2 - MEDIUM\n    3 - HIGH");

                if (scanner.hasNextInt()) {
                    int p = scanner.nextInt();
                    switch (p) {
                        case 1 -> priority = Priorities.LOW;
                        case 2 -> priority = Priorities.MEDIUM;
                        case 3 -> priority = Priorities.HIGH;
                        default -> System.out.println("Please choose a valid option.");
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                }
            }


            Category category = null;
            while (category == null) {
                System.out.println("Choose a Category:");
                System.out.println("    1 - PERSONAL\n    2 - WORK\n    3 - STUDY\n    4 - SHOPPING\n    5 - OTHER");

                if (scanner.hasNextInt()) {
                    int c = scanner.nextInt();
                    switch (c) {
                        case 1 -> category = Category.PERSONAL;
                        case 2 -> category = Category.WORK;
                        case 3 -> category = Category.STUDY;
                        case 4 -> category = Category.SHOPPING;
                        case 5 -> category = Category.OTHER;
                        default -> System.out.println("Please choose a valid option.");
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                }
            }


            taskToEdit.setDescription(description);
            taskToEdit.setPriority(priority);
            taskToEdit.setCategory(category);

            System.out.println("✅ Task updated successfully.\n");
            return true;

        } else {
            System.out.println("Please enter a valid number.");
            scanner.next();
            return false;
        }
    }

    public static void FilterByCategoryOrPriority(ArrayList<Task> tasks, Scanner scanner) {

        boolean isValid = false;
        System.out.println("Please Choose the field you want to filter");

        System.out.println("    1 - Priority\n    2 - Category\n ");

        while (!isValid) {

            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        FilterByPriority(tasks,scanner);
                        isValid = true;
                        break;
                    case 2:
                        FilterByCategory(tasks,scanner);
                        isValid = true;
                        break;
                    default:
                        System.out.println("Please choose a valid option");
                        break;
                }


            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }
    }


    public static void FilterByCategory(ArrayList<Task> tasks, Scanner scanner){

        System.out.println("Choose the Category you want to filter:");

        Category category = null;
        while (category == null) {
            System.out.println("Choose a Category:");
            System.out.println("    1 - PERSONAL\n    2 - WORK\n    3 - STUDY\n    4 - SHOPPING\n    5 - OTHER");

            if (scanner.hasNextInt()) {
                int c = scanner.nextInt();
                switch (c) {
                    case 1 -> category = Category.PERSONAL;
                    case 2 -> category = Category.WORK;
                    case 3 -> category = Category.STUDY;
                    case 4 -> category = Category.SHOPPING;
                    case 5 -> category = Category.OTHER;
                    default -> System.out.println("Please choose a valid option.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }

        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                if (task.getCategory() == category) {
                    System.out.println(task.toString());

                }
            }
        }
        else {
            System.out.println("The List is empty or There are no items with that category");
        }
    }

    public static void FilterByPriority(ArrayList<Task> tasks, Scanner scanner){

        System.out.println("Choose the Priority you want to filter:");

        Priorities priority = null;
        while (priority == null) {
            System.out.println("Choose a Priority:");
            System.out.println("    1 - LOW\n    2 - MEDIUM\n    3 - HIGH");

            if (scanner.hasNextInt()) {
                int c = scanner.nextInt();
                switch (c) {
                    case 1 -> priority = Priorities.LOW;
                    case 2 -> priority = Priorities.MEDIUM;
                    case 3 -> priority = Priorities.HIGH;
                    default -> System.out.println("Please choose a valid option.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }

        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                if (task.getPriority() == priority) {
                    System.out.println(task.toString());
                }
            }
        }
        else {
            System.out.println("The List is empty or There are no items with that Priority");
        }
    }
}