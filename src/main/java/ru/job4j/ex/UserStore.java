package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int rsl = -1;
        try {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == login) {
                    User = i;
                }
            }
        } catch (UserNotFoundException e) {
            System.out.println("User not found.");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
            return user.isValid();
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = findUser(users, "Petr Arsentev");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
    }
}
