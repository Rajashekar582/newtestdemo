package com.newtestdemo.demo;

import com.newtestdemo.demo.entity.User;
import com.newtestdemo.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        // Clear the repository before each test
        userRepository.deleteAll();
    }

    @Test
    void testSaveUser() {
        // Arrange
        User user = new User();
        user.setName("John");
        user.setEmail("john@example.com");

        // Act
        User savedUser = userRepository.save(user);

        // Assert
        assertNotNull(savedUser.getId());
        assertEquals("John", savedUser.getName());
        assertEquals("john@example.com", savedUser.getEmail());
        assertTrue(userRepository.count() >= 1);
    }

    @Test
    void testFindUserById() {
        // Arrange
        User user = new User();
        user.setName("Jane");
        user.setEmail("jane@example.com");
        User savedUser = userRepository.save(user);

        // Act
        var foundUser = userRepository.findById(savedUser.getId());

        // Assert
        assertTrue(foundUser.isPresent());
        assertEquals("Jane", foundUser.get().getName());
    }

    @Test
    void testRepositoryIsNotNull() {
        // Assert
        assertNotNull(userRepository);
    }
}
