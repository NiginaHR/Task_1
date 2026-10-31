package praktikum_test;
import org.junit.jupiter.api.Test;

import praktikum.Database;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class DatabaseTest {

    @Test

    public void showAvailableBuns()  {

        Database database = new Database();

        assertNotNull(database.availableBuns());
        assertEquals(3, database.availableBuns().size());
    }



    @Test
    public void showAvailableIngredients()  {

        Database database = new Database();
        assertNotNull(database.availableIngredients());
        assertEquals(6, database.availableIngredients().size());
}
}

