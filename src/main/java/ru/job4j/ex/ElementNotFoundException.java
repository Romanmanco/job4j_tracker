package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public class FindEl {
        public static int indexOf(String[] value, String key) throws ElementNotFoundException {
            int rsl = -1;
            for (int i = 0; i < value.length; i++) {
                if (value[i] == key) {
                    return i;
                }
            }
            return rsl;
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
