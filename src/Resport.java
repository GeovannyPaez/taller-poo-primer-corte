public class Resport {
    public int countClientsRegistered(int[] cedulas) {
        int count = 0;
        for (int cedula : cedulas) {
            if (cedula != 0) {
                count++;
            }
        }
        return count;
    }

    public int averageAge(int[] ages) {
        int sum = 0;
        for (int age : ages) {
            sum += age;
        }
        return sum / ages.length;
    }

    public int countClientsByCity(String city, String[] cities) {
        int count = 0;
        for (String c : cities) {
            if (c != null && c.equals(city)) {
                count++;
            }
        }
        return count;
    }

    public int countClientsByEmail(String email, String[] emails) {
        int count = 0;
        for (String e : emails) {
            if (e != null && e.contains(email)) {
                count++;
            }
        }
        return count;
    }
}
