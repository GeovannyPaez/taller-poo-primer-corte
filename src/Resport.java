public class Resport {
    public long countClientsRegistered(long[] cedulas) {
        int count = 0;
        for (long cedula : cedulas) {
            if (cedula != 0) {
                count++;
            }
        }
        return count;
    }

    public float averageAge(int[] ages) {
        int sum = 0;
        int increment = 0;
        for (int age : ages) {
            System.out.println("age: " + age);
          if(age != 0) {
            sum += age;
            increment++;
          };
        }
        return (float) sum / increment;
    }

    public int countClientsByCity(String city, String[] cities) {
        int count = 0;
        for (String c : cities) {
            if (c != null && c.equals(city.toUpperCase())) {
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
