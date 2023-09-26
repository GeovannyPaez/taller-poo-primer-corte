import java.util.Scanner;

public class Cliente {
    // vetores paralelos
    private String[] names = new String[200];
    private long[] cedulas = new long[200];
    private long[] phoneNumber = new long[200];
    private int[] ages = new int[200];
    private String[] cities = new String[200];
    private String[] emails = new String[200];

    private Scanner scanner = new Scanner(System.in);
    private Resport resport = new Resport();

    public boolean createClient(String name, long cedula, long cellPhone, int age, String city, String email) {
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

    // Agregar
    // Usuario--------------------------------------------------------------------------------------------------------
    public void addClient() {
        String name = this.getStringValueClient("name");
        long cedula = this.getCedulaToCreateClient();
        long cellPhone = this.getValueLongClient("cell phone");
        int age = this.getAgeConsole();
        String city = this.getStringValueClient("city").toUpperCase();
        String email = this.getEmailConsole();
        if (this.createClient(name, cedula, cellPhone, age, city, email)) {
            System.out.println("Client created successfully");
        } else {
            System.out.println("Client not created");
        }
    }

    // Actualizar
    // Usuario------------------------------------------------------------------------------------------------------
    public void updateClient(int index, String name, long cedula, long cellPhone, int age, String city, String email) {
        this.names[index] = name;
        this.cedulas[index] = cedula;
        this.phoneNumber[index] = cellPhone;
        this.ages[index] = age;
        this.cities[index] = city;
        this.emails[index] = email;
    }

    // Eliminar
    // Usuario----------------------------------------------------------------------------------------------------------
    public boolean removeClient(long cedula) {
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

    // Actualizar Usuario por
    // Correo---------------------------------------------------------------------------------------------
    public void updateClientByEmail(String email) {
        int index = this.searchClientByEmail(email);
        if (index == -1) {
            System.out.println("Client not found");
            return;
        }
        String name = this.getStringValueClient("name");
        long cedula = this.getCedulaToCreateClient();
        long cellPhone = this.getValueLongClient("cell phone");
        int age = this.getAgeConsole();
        String city = this.getStringValueClient("city");
        this.updateClient(index, name, cedula, cellPhone, age, city, email);
        System.out.println("Client updated successfully");
    }

    // Actualziar Usuario por Cedula
    public boolean updateClientByCedula(long cedula) {
        int index = this.searchClientByCedula(cedula);
        if (index == -1) {
            System.out.println("Client not found");
            return false;
        }
        String name = this.getStringValueClient("name");
        long cellPhone = this.getValueLongClient("cell phone");
        int age = this.getAgeConsole();
        String city = this.getStringValueClient("city");
        String email = this.getEmailConsole();
        this.updateClient(index, name, cedula, cellPhone, age, city, email);
        return true;
    }

    // Metodos para tomar los valores, crear y hacer las actualizaciones
    // --------------------------------------------------------------
    public long getValueIntClient(String message) {
        System.out.println("Enter the client's " + message + ":");
        long value = scanner.nextInt();
        return value;
    }

    public long getValueLongClient(String message) {
        System.out.println("Enter the client's " + message + ":");
        long value = scanner.nextLong();
        return value;
    }

    public String getStringValueClient(String message) {
        System.out.println("Enter the client's " + message + ":");
        String value = scanner.next();
        return value;
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
        int age = (int) this.getValueIntClient("age");
        boolean isValidAge = Validate.isAge(age);
        while (!isValidAge) {
            System.out.println("Invalid age");
            System.out.println("the age must be greater than 18");
            age = (int) this.getValueIntClient("age");
            isValidAge = Validate.isAge(age);
        }
        return age;
    }

    public long getCedulaConsole() {
        long cedula = this.getValueLongClient("cedula"); // "Enter the client's cedula:
        boolean isValidCedula = Validate.isValidCedula(cedula);
        while (!isValidCedula) {
            System.out.println("Invalid cedula");
            cedula = scanner.nextInt();
            isValidCedula = Validate.isValidCedula(cedula);
        }
        return cedula;
    }

    public long getCedulaToCreateClient() {
        long cedula = this.getCedulaConsole();
        boolean isUniqueCedula = Validate.isUniqueCedula(this.cedulas, cedula);
        while (!isUniqueCedula) {
            System.out.println("Cedula already exists");
            cedula = this.getCedulaConsole();
            isUniqueCedula = Validate.isUniqueCedula(this.cedulas, cedula);
        }
        return cedula;
    }

    // --------------------------------------------------------------------------------------------------------------------------------
    // Buscar
    // usuarios--------------------------------------------------------------------------------------------------------------
    public int searchClientByEmail(String email) {
        for (int i = 0; i < this.emails.length; i++) {
            if (this.emails[i] != null && this.emails[i].equals(email)) {
                return i;
            }
        }
        return -1;
    }

    public int searchClientByCedula(long cedula) {
        for (int i = 0; i < this.cedulas.length; i++) {
            if (this.cedulas[i] != 0 && this.cedulas[i] == cedula) {
                return i;
            }
        }
        return -1;
    }

    public int searchClientByPhoneNumber(long phoneNumber) {
        for (int i = 0; i < this.phoneNumber.length; i++) {
            if (this.phoneNumber[i] != 0 && this.phoneNumber[i] == phoneNumber) {
                return i;
            }
        }
        return -1;
    }

    // Listar Usuarios
    // --------------------------------------------------------------------------------------------------------------
    public void listAllClients() {
        for (int i = 0; i < this.names.length; i++) {
            if (this.names[i] != null) {
                System.out.println("\nClient " + (i + 1));
                this.printClient(i);
            }
        }
    }

    public void listByRangeAge() {
        int minAge = (int) this.getValueIntClient("min age");
        int maxAge = (int) this.getValueIntClient("max age");
        this.printListClientsByRangeAge(minAge, maxAge);
    }

    public void listClientByPhoneNumber() {
        long phoneNumberToSearch = this.getValueLongClient("phone number to search");
        int index = this.searchClientByPhoneNumber(phoneNumberToSearch);
        if (index != -1) {
            System.out.println("Client found:");
            this.printClient(index);
        } else {
            System.out.println("Client not found");
        }
    }

    public void listClientByMail() {
        String mailToSearch = this.getStringValueClient("mail to search");
        int index = this.searchClientByEmail(mailToSearch);
        if (index != -1) {
            System.out.println("\nClient found:");
            this.printClient(index);
        } else {
            System.out.println("Client not found");
        }
    }

    public void listClientByCedula() {
        long cedulaToSearch = this.getValueLongClient("Cedula to search");
        int index = this.searchClientByCedula(cedulaToSearch);
        if (index != -1) {
            System.out.println("\nClient found:");
            this.printClient(index);
        } else {
            System.out.println("Client not found");
        }
    }

    public void listByCity() {
        String city = this.getStringValueClient("city");
        this.printListClientsByCity(city);
    }

    // Validar que la lista de usuarios no este llena
    public boolean validateToClientListIsFull(int[] cedulas) {
        for (int i = 0; i < this.cedulas.length; i++) {
            if (cedulas[i] == 0) {
                return false;
            }
        }
        return true;
    }

    // Imprimir usuarios
    // --------------------------------------------------------------------------------------------------------------
    public void printClient(int index) {
        System.out.println("\nName: " + this.names[index]);
        System.out.println("Cedula: " + this.cedulas[index]);
        System.out.println("Phone Number: " + this.phoneNumber[index]);
        System.out.println("Age: " + this.ages[index]);
        System.out.println("City: " + this.cities[index]);
        System.out.println("Email: " + this.emails[index]);
    }

    public void printListClientsByCity(String city) {
        for (int i = 0; i < this.names.length; i++) {
            if (this.names[i] != null && this.cities[i].equals(city)) {
                this.printClient(i);
            }
        }
    }

    public void printListClientsByRangeAge(int minAge, int maxAge) {
        for (int i = 0; i < this.names.length; i++) {
            if (this.names[i] != null && this.ages[i] >= minAge && this.ages[i] <= maxAge) {
                this.printClient(i);
            }
        }
    }

    // ---------------------------------------------------------------------------------------------------------------------------
    public void printResport() {
        int countClientsRegistered = (int) this.resport.countClientsRegistered(this.cedulas);
        float averageAge = this.resport.averageAge(this.ages);
        int countClientsByCityCucuta = this.resport.countClientsByCity("Cucuta", this.cities);
        int countClientsByCityPamplona = this.resport.countClientsByCity("Pamplona", this.cities);
        int countClientsByEmailOutlook = this.resport.countClientsByEmail("@outlook.com", this.emails);
        int countClientsByEmailGmail = this.resport.countClientsByEmail("@gmail.com", this.emails);

        System.out.println("\nCount clients registered: " + countClientsRegistered);
        System.out.println("Average age: " + averageAge);
        System.out.println("Count clients by city Cucuta: " + countClientsByCityCucuta);
        System.out.println("Count clients by city Pamplona: " + countClientsByCityPamplona);
        System.out.println("Count clients by email @outlook.com: " + countClientsByEmailOutlook);
        System.out.println("Count clients by email @gmail.com: " + countClientsByEmailGmail);

    }
}
