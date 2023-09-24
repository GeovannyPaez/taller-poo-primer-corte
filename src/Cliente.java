import java.util.Scanner;

public class Cliente {
    // vetores paralelos
    private String[] names = new String[200];
    private int[] cedulas = new int[200];
    private long[] phoneNumber = new long[200];
    private int[] ages = new int[200];
    private String[] cities = new String[200];
    private String[] emails = new String[200];

    private Scanner scanner = new Scanner(System.in);

    public boolean createClient(String name, int cedula, long cellPhone, int age, String city, String email) {
        for (int i = 0; i < this.names.length; i++) {
            if (this.names[i] == null) {
                this.names[i] = name;
                this.cedulas[i] = cedula;
                this.phoneNumber[i] = cellPhone;
                this.ages[i] = age;
                this.cities[i] = city;
                this.emails[i] = email;
                return true;
            }
        }
        return false;
    }

    public void addClient() {
        String name = this.getStringValueClient("name");
        int cedula = this.getCedulaToCreateClient();
        long cellPhone = this.getValueLongClient("cell phone");
        int age = this.getAgeConsole();
        String city = this.getStringValueClient("city");
        String email = this.getEmailConsole();
        if (this.createClient(name, cedula, cellPhone, age, city, email)) {
            System.out.println("Client created successfully");
        } else {
            System.out.println("Client not created");
        }
    }

    public void updateClientByEmail(String email) {
        int index = this.searchClientByEmail(email);
        if (index == -1) {
            System.out.println("Client not found");
            return;
        }
        String name = this.getStringValueClient("name");
        int cedula = this.getCedulaConsole();
        int cellPhone = this.getValueIntClient("cell phone");
        int age = this.getAgeConsole();
        String city = this.getStringValueClient("city");
    }

    public int getValueIntClient(String message) {
        System.out.println("Enter the client's " + message + ":");
        int value = scanner.nextInt();
        return value;
    }

    public long getValueLongClient(String message) {
        System.out.println("Enter the client's " + message + ":");
        long value = scanner.nextLong();
        return value;
    }

    public String getStringValueClient(String message) {
        System.out.println("Enter the client's " + message + ":");
        String value = scanner.nextLine();
        return value;
    }

    public int searchClientByEmail(String email) {
        for (int i = 0; i < this.emails.length; i++) {
            if (this.emails[i] != null && this.emails[i].equals(email)) {
                return i;
            }
        }
        return -1;
    }

    public int searchClientByCedula(int cedula) {
        for (int i = 0; i < this.cedulas.length; i++) {
            if (this.cedulas[i] != 0 && this.cedulas[i] == cedula) {
                return i;
            }
        }
        return -1;
    }

    public String getEmailConsole() {
        String email = this.getStringValueClient("email");
        boolean isValidEmail = Validate.isEmail(email);
        while (!isValidEmail) {
            System.out.println("Invalid email");
            email = this.getStringValueClient("email");
            isValidEmail = Validate.isEmail(email);
        }
        return email;
    }

    public int getAgeConsole() {
        int age = this.getValueIntClient("age");
        boolean isValidAge = Validate.isAge(age);
        while (!isValidAge) {
            System.out.println("Invalid age");
            System.out.println("the age must be greeter than 18");
            age = this.getValueIntClient("age");
            isValidAge = Validate.isAge(age);
        }
        return age;
    }

    public int getCedulaToCreateClient() {
        int cedula = this.getCedulaConsole();
        boolean isUniqueCedula = Validate.isUniqueCedula(this.cedulas, cedula);
        while (!isUniqueCedula) {
            System.out.println("Cedula already exists");
            cedula = this.getCedulaConsole();
            isUniqueCedula = Validate.isUniqueCedula(this.cedulas, cedula);
        }
        return cedula;
    }

    public boolean updateClientByCedula(int cedula) {
        int index = this.searchClientByCedula(cedula);
        if (index == -1) {
            System.out.println("Client not found");
            return false;
        }
        String name = this.getStringValueClient("name");
        int cellPhone = this.getValueIntClient("cell phone");
        int age = this.getAgeConsole();
        String city = this.getStringValueClient("city");
        String email = this.getEmailConsole();
        this.names[index] = name;
        this.phoneNumber[index] = cellPhone;
        this.ages[index] = age;
        this.cities[index] = city;
        this.emails[index] = email;
        return true;
    }

    public int getCedulaConsole() {
        int cedula = this.getValueIntClient("cedula"); // "Enter the client's cedula:
        boolean isValidCedula = Validate.isValidCedula(cedula);
        while (!isValidCedula) {
            System.out.println("Invalid cedula");
            cedula = scanner.nextInt();
            isValidCedula = Validate.isValidCedula(cedula);
        }
        return cedula;
    }

    public boolean removeClient(int cedula) {
        int index = this.searchClientByCedula(cedula);
        if (index != -1) {
            this.names[index] = null;
            this.cedulas[index] = 0;
            this.phoneNumber[index] = 0;
            this.ages[index] = 0;
            this.cities[index] = null;
            this.emails[index] = null;
            return true;
        }
        return false;
    }

    public void printListClients() {
        for (int i = 0; i < this.names.length; i++) {
            if (this.names[i] != null) {
                System.out.println("Nome: " + this.names[i]);
                System.out.println("Cedula: " + this.cedulas[i]);
                System.out.println("Phone Number: " + this.phoneNumber[i]);
                System.out.println("Age: " + this.ages[i]);
                System.out.println("City: " + this.cities[i]);
                System.out.println("Email: " + this.emails[i]);
            }
        }
    }

    public void printListClientsByRangeAge(int minAge, int maxAge) {
        for (int i = 0; i < this.names.length; i++) {
            if (this.names[i] != null && this.ages[i] >= minAge && this.ages[i] <= maxAge) {
                System.out.println("Nome: " + this.names[i]);
                System.out.println("Cedula: " + this.cedulas[i]);
                System.out.println("Phone Number: " + this.phoneNumber[i]);
                System.out.println("Age: " + this.ages[i]);
                System.out.println("City: " + this.cities[i]);
                System.out.println("Email: " + this.emails[i]);
            }
        }
    }

    public boolean validateToClientListIsFull(int[] cedulas) {
        for (int i = 0; i < this.cedulas.length; i++) {
            if (cedulas[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
