package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public class FindEl {
        public static int indexOf(String[] value, String key) throws ElementNotFoundException {
            for (int i = 0; i < value.length; i++) {
                if (value[i].equals(key)) {
                    return i;
                }
            }
            throw new ElementNotFoundException();
        }

        public static void main(String[] value, String key) {
            try {
                indexOf(value, key);
            } catch (ElementNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
