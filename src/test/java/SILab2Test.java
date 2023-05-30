import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    void userNullException()
    {
        User user = null;
        List<User> users = new ArrayList<>();
        assertThrows(RuntimeException.class,()->{
            SILab2.function(user,users);
        });
    }

    @Test
    void EmptyUserListValidUser()
    {
        User user = new User("Dimitar","dimitar1337#","dimitar@dimchez.com");
        List<User> users = new ArrayList<>();
        assertEquals(false,SILab2.function(user,users));
    }
    @Test
    void uniquePassword()
    {
        List<User> users = new ArrayList<>();
        User user = new User("Petko","pet4e","petko@outlook.com");
        users.add(new User("Dimchez","@dim1337","dimchez@gmail.com"));

        assertEquals(false,SILab2.function(user,users));
    }
    @Test
    void identicalPassword()
    {
        List<User> users = new ArrayList<>();
        User user = new User("Dimitar","dimchezijata!","dimchezijata@gmail.com");
        users.add(new User("Petko","pet4e","pet4eto@gmail.com"));
        assertEquals(true,SILab2.function(user,users));
    }
    @Test
    void passwordContainsWhiteSpace()
    {
        List<User> users = new ArrayList<>();
        User user = new User("Dimitar","dimchez dimchezijata","dim@gmail.com");
        users.add(new User("Petko","petkopetkovski","petkovskip@gmail.com"));
        assertEquals(false,SILab2.function(user,users));
    }

    @Test
    void passwordDoesNotContainSpecialChar()
    {
        List<User> users = new ArrayList<>();
        User user = new User("Dimitar","dimchezijata","dimchezijata@gmail.com");
        users.add(new User("Petko","petkopetko","petko@gmail.com"));
        assertEquals(false,SILab2.function(user,users));

    }

    @Test
    void emailNull()
    {
        List<User> users = new ArrayList<>();
        User user = new User("Petkoo","petko","");
        users.add(new User("Trajcheto","trajche","trajchee@gmail.com"));
        assertEquals(false,SILab2.function(user,users));
    }

    @Test
    void passwordNull()
    {
        List<User> users = new ArrayList<>();
        User user = new User("Dimitar","","dimchezijata@gmail.com");
        users.add(new User("Petko","asldkj","petkos@gmail.com"));
        assertEquals(false,SILab2.function(user,users));

    }

    @Test
    void passwordAndEmailNull()
    {
        List<User> users = new ArrayList<>();
        User user = new User("Dimchez","","");
        users.add(new User("Petko","petkopetkovski","petkooo@gmail.com"));
        assertEquals(false,SILab2.function(user,users));
    }

    @Test
    void userListEmpty()
    {
        List<User> users = new ArrayList<>();
        User user = new User("Dimitar","dimitard","dimitarde@gmail.com");
        assertEquals(false, SILab2.function(user,users));
    }

    @Test
    void invalidEmail()
    {
        List<User> users = new ArrayList<>();
        User user = new User("Dimitar","dimitar123","dimcheziajta@gmail.com");
        assertFalse(SILab2.function(user,users));
    }

    @Test
    void longPassword()
    {
        List<User> users = new ArrayList<>();
        User user = new User("Dimitar","dimchezijtadimchezijata1234#@#","dimchezijata@gmail.com");
        assertEquals(true,SILab2.function(user,users));
    }
}