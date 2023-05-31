import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    public void everyBranch() {
        // Test case 1: missing information
        RuntimeException ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // Test case 2: username is null (gets set to email), user with same username and email already exists
        ArrayList<User> users1 = new ArrayList<>();
        users1.add(new User("email@mail.com", "somePassword", "email@mail.com"));
        assertFalse(SILab2.function(new User(null, "strongPassword", "email@mail.com"), users1));

        // Test case 3: email is invalid, password is weak
        assertFalse(SILab2.function(new User("username", "weak", "mail"), new ArrayList<>()));

        // Test case 4: information is valid, user with same username or email doesn't exist
        ArrayList<User> users2 = new ArrayList<>();
        users2.add(new User("differentEmail@mail.com", "somePassword^", "differentMail@mail.com"));
        assertTrue(SILab2.function(new User("username", "VeryStrongPassword!!!", "email@mail.com"), users2));

        // Test case 5: password contains whitespace character (" ")
        assertFalse(SILab2.function(new User("username", "my password", "mail"), new ArrayList<>()));
    }

    @Test
    public void multipleCondition() {
        // Test case 1: user is null (TXX)
        RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<>()));
        assertTrue(ex1.getMessage().contains("Mandatory information missing!"));

        // Test case 2: password is null (FTX)
        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", "email@mail.com", null), new ArrayList<>()));
        assertTrue(ex2.getMessage().contains("Mandatory information missing!"));

        // Test case 3: password is null (FFT)
        RuntimeException ex3 = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", null, "password"), new ArrayList<>()));
        assertTrue(ex3.getMessage().contains("Mandatory information missing!"));

        // Test case 4: all needed information is present
        assertDoesNotThrow(() -> SILab2.function(new User("username", "password", "email@mail.com"), new ArrayList<>()), "Mandatory information missing!");
    }

}
