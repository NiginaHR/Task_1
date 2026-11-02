package praktikum_test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BurgerTest {
    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredientOne;
    @Mock
    private Ingredient mockIngredientTwo;
    @Mock
    private Ingredient mockIngredientThree;


    @Test
    void testSetBuns() {
        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100f);


        Burger burger = new Burger();

        burger.setBuns(mockBun);

        assertEquals("black bun", burger.bun.getName());
        assertEquals(100f, burger.bun.getPrice(), 0.01f);
    }


    @Test
    void testAddIngredient() {
        when(mockIngredientOne.getName()).thenReturn("hot sauce");
        when(mockIngredientOne.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredientOne.getPrice()).thenReturn(100f);


        Burger burger = new Burger();

        burger.addIngredient(mockIngredientOne);

        assertEquals(1, burger.ingredients.size());

        assertEquals("hot sauce", burger.ingredients.get(0).getName());

    }

    @Test
    void testRemoveIngredient() {


        when(mockIngredientOne.getName()).thenReturn("hot sauce");
        when(mockIngredientOne.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredientOne.getPrice()).thenReturn(100f);

        when(mockIngredientTwo.getName()).thenReturn("cutlet");
        when(mockIngredientTwo.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredientTwo.getPrice()).thenReturn(100f);

        when(mockIngredientThree.getName()).thenReturn("sour cream");
        when(mockIngredientThree.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredientThree.getPrice()).thenReturn(200f);

        Burger burger = new Burger();

        burger.addIngredient(mockIngredientOne);
        burger.addIngredient(mockIngredientTwo);
        burger.addIngredient(mockIngredientThree);

        assertEquals(3, burger.ingredients.size());

        burger.removeIngredient(2);
        assertEquals(2, burger.ingredients.size());

    }


    @Test
    void testMoveIngredient() {

        when(mockIngredientOne.getName()).thenReturn("hot sauce");
        when(mockIngredientOne.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredientOne.getPrice()).thenReturn(100f);

        when(mockIngredientTwo.getName()).thenReturn("cutlet");
        when(mockIngredientTwo.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredientTwo.getPrice()).thenReturn(100f);

        when(mockIngredientThree.getName()).thenReturn("sour cream");
        when(mockIngredientThree.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredientThree.getPrice()).thenReturn(200f);

        Burger burger = new Burger();

        burger.addIngredient(mockIngredientOne);
        burger.addIngredient(mockIngredientTwo);
        burger.addIngredient(mockIngredientThree);

        assertEquals(3, burger.ingredients.size());

        burger.moveIngredient(2, 1);
        assertEquals(3, burger.ingredients.size());

    }


    @Test
    public void testGetReceipt() {

        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100f);

        when(mockIngredientOne.getName()).thenReturn("hot sauce");
        when(mockIngredientOne.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredientOne.getPrice()).thenReturn(50f);

        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientOne);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("black bun"), "Название булочки");
        assertTrue(receipt.contains("hot sauce"), "Наименование ингредиентов");
        assertTrue(receipt.contains("filling"), "Тип ингредиентов");
        assertTrue(receipt.contains("Price"), "Тип Цена");
        assertTrue(receipt.contains("250"), "Цена)");


    }
}




