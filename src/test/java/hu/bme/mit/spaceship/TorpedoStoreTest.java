package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Failure() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 1.0);
        
        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(false, result);
    }

    @Test
    void fire_Exception_numberOfTorpedos_More() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 0.0);
        
        // Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(10));
    }

    @Test
    void fire_Exception_numberOfTorpedos_Less() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 0.0);
        
        // Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(-2));
    }

    @Test 
    void isEmpty_True() {
        // Arrange
        TorpedoStore store = new TorpedoStore(0, 0.0);

         // Act
        boolean result = store.isEmpty();

        assertEquals(true, result);
    }

    @Test 
    void isEmpty_False() {
        // Arrange
        TorpedoStore store = new TorpedoStore(10, 0.0);

         // Act
        boolean result = store.isEmpty();

        assertEquals(false, result);
    }
}
