public class Validate {
    public static String[] emailsValids = { "@gmail.com", "@hotmail.com", "@outlook.com" };

    public static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isEmail(String value) {
        for (String email : emailsValids) {
            if (value.contains(email)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAge(int value) {
        return value >= 18;
    }

    public static boolean isValidCedula(long cedula) {
        return cedula >= 100000 && cedula <= 9999999999L;
    }

    public static boolean isUniqueCedula(long[] cedulas, long cedula) {
        for (long cedu : cedulas) {
            if (cedu == cedula) {
                return false;
            }
        }
        return true;
    }
}
