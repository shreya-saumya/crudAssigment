package com.example.cruddemoproject.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UsersTest {
    @Test
    void testCanEqual() {
        assertFalse((new Users()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        Users users = new Users();

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(0);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertTrue(users.canEqual(users1));
    }

    @Test
    void testConstructor() {
        Users actualUsers = new Users();
        actualUsers.setAddress("42 Main St");
        actualUsers.setEmail("jane.doe@example.org");
        actualUsers.setId(123L);
        actualUsers.setName("Name");
        actualUsers.setPhone(1);
        assertEquals("42 Main St", actualUsers.getAddress());
        assertEquals("jane.doe@example.org", actualUsers.getEmail());
        assertEquals(123L, actualUsers.getId().longValue());
        assertEquals("Name", actualUsers.getName());
        assertEquals(1, actualUsers.getPhone().intValue());
        assertEquals("Users(id=123, name=Name, email=jane.doe@example.org, address=42 Main St, phone=1)",
                actualUsers.toString());
    }

    @Test
    void testEquals() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        assertFalse(users.equals(null));
    }

    @Test
    void testEquals2() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        assertFalse(users.equals("Different type to Users"));
    }

    @Test
    void testEquals3() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        assertTrue(users.equals(users));
        int expectedHashCodeResult = users.hashCode();
        assertEquals(expectedHashCodeResult, users.hashCode());
    }

    @Test
    void testEquals4() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertTrue(users.equals(users1));
        int expectedHashCodeResult = users.hashCode();
        assertEquals(expectedHashCodeResult, users1.hashCode());
    }

    @Test
    void testEquals5() {
        Users users = new Users();
        users.setEmail("Name");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertFalse(users.equals(users1));
    }

    @Test
    void testEquals6() {
        Users users = new Users();
        users.setEmail(null);
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertFalse(users.equals(users1));
    }

    @Test
    void testEquals7() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(0);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertFalse(users.equals(users1));
    }

    @Test
    void testEquals8() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(null);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertFalse(users.equals(users1));
    }

    @Test
    void testEquals9() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(0L);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertFalse(users.equals(users1));
    }

    @Test
    void testEquals10() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(null);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertFalse(users.equals(users1));
    }

    @Test
    void testEquals11() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("jane.doe@example.org");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertFalse(users.equals(users1));
    }

    @Test
    void testEquals12() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName(null);
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertFalse(users.equals(users1));
    }

    @Test
    void testEquals13() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("Name");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertFalse(users.equals(users1));
    }

    @Test
    void testEquals14() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress(null);

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertFalse(users.equals(users1));
    }

    @Test
    void testEquals15() {
        Users users = new Users();
        users.setEmail(null);
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail(null);
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertTrue(users.equals(users1));
        int expectedHashCodeResult = users.hashCode();
        assertEquals(expectedHashCodeResult, users1.hashCode());
    }

    @Test
    void testEquals16() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(null);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(null);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertTrue(users.equals(users1));
        int expectedHashCodeResult = users.hashCode();
        assertEquals(expectedHashCodeResult, users1.hashCode());
    }

    @Test
    void testEquals17() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(null);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(null);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        assertTrue(users.equals(users1));
        int expectedHashCodeResult = users.hashCode();
        assertEquals(expectedHashCodeResult, users1.hashCode());
    }

    @Test
    void testEquals18() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName(null);
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName(null);
        users1.setAddress("42 Main St");
        assertTrue(users.equals(users1));
        int expectedHashCodeResult = users.hashCode();
        assertEquals(expectedHashCodeResult, users1.hashCode());
    }
}

