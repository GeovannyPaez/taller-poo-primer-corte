import java.util.Scanner;

public class Menu {
    private int option = 0;
    private Scanner scanner = new Scanner(System.in);
    private Cliente cliente = new Cliente();

    public void run() {
        System.out.println("Welcome to the client manager");
        System.out.println("Please select an option");
        do {
            this.printMenu();
        } while (this.option != 6);
    }

    public void printMenu() {
        System.out.println("1. Add client");
        System.out.println("2. Remove client");
        System.out.println("3. Update client");
        System.out.println("4. Search clients");
        System.out.println("5. Cliente Report");
        System.out.println("6. Exit");
        this.option = scanner.nextInt();

        switch (this.option) {
            case 1:
                System.out.println("Add client");
                this.cliente.addClient();
                break;
            case 2:
                System.out.println("Remove client");
                int cedula = this.cliente.getCedulaConsole();
                boolean isDeleted = this.cliente.removeClient(cedula);
                if (isDeleted) {
                    System.out.println("Client deleted successfully");
                } else {
                    System.out.println("Client not deleted");
                }
                break;
            case 3:
                System.out.println("Update client");
                this.updateClient();
                break;
            case 4:
                System.out.println("Search clients");
                this.manageListPeople();
                break;
            case 5:
                System.out.println("Cliente Report");
                break;
            case 6:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public void manageListPeople() {
        int option = 0;
        System.out.println("1. List all clients");
        System.out.println("2. List by range age");
        System.out.println("3. List by city");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("List all clients");
                break;
            case 2:
                System.out.println("List by range age");
                break;
            case 3:
                System.out.println("List by city");
                break;
            default:
                System.out.println("Invalid option");
                this.manageListPeople();
                break;
        }
    }

    public void updateClient() {
        int option = 0;
        System.out.println("1. Update by cedula");
        System.out.println("2. Update by email");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Update by cedula");
                int cedula = this.cliente.getCedulaConsole();
                this.cliente.updateClientByCedula(cedula);
                break;
            case 2:
                System.out.println("Update by email");
                String email = this.cliente.getEmailConsole();
                this.cliente.updateClientByEmail(email);
                break;
            default:
                System.out.println("Invalid option");
                this.updateClient();
                break;
        }

    }

}
