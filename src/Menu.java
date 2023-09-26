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
        System.out.println("\n1. Add client");
        System.out.println("2. Remove client");
        System.out.println("3. Update client");
        System.out.println("4. Search clients");
        System.out.println("5. Client Report");
        System.out.println("6. Exit\n");
        this.option = scanner.nextInt();

        switch (this.option) {
            case 1:
                System.out.println("Add client");
                this.cliente.addClient();
                break;
            case 2:
                System.out.println("Remove client");
                long cedula = this.cliente.getCedulaConsole();
                boolean isDeleted = this.cliente.removeClient(cedula);
                if (isDeleted) {
                    System.out.println("Client deleted successfully");
                } else {
                    System.out.println("Not found client");
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
                this.cliente.printResport();
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
        System.out.println("2. List by cedula");
        System.out.println("3. List by email");
        System.out.println("4. List by phone number");
        System.out.println("5. List by range age");
        System.out.println("6. List by city");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("List all clients");
                this.cliente.listAllClients();
                break;
            case 2:
                System.out.println("List by Cedula");
                this.cliente.listClientByCedula();
                break;
            case 3:
                System.out.println("List by Email");
                this.cliente.listClientByMail();
                break;
            case 4:
                System.out.println("List by Phone Number");
                this.cliente.listClientByPhoneNumber();
                break;
            case 5:
                System.out.println("List by range age");
                this.cliente.listByRangeAge();
                break;
            case 6:
                System.out.println("List by city");
                this.cliente.listByCity();
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
                long cedula = this.cliente.getCedulaConsole();
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
