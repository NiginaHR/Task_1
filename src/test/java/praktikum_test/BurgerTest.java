package praktikum_test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

public class BurgerTest {
 static  Stream<Arguments> bunData() {
        return Stream.of(
                Arguments.of("Чикенбургер", 150f)
        );
    }

    @ParameterizedTest
    @MethodSource("bunData")
    public void testGetPrice(String name, float price) {

        Bun bun=new Bun(name, price);

        assertEquals(price, bun.getPrice());

    }



    @Test
    void testSetBuns()  {

        Burger burger = new Burger();

        Bun bun = new Bun("black bun", 100f);
        burger.setBuns(bun);

        assertEquals("black bun", burger.bun.getName());
        assertEquals(100f, burger.bun.getPrice(), 0.01f);
    }



    @Test
    void testAddIngredient() {
        Burger burger = new Burger();

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100f);
        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());

        assertEquals("hot sauce", burger.ingredients.get(0).getName());

    }

    @Test
    void testRemoveIngredient() {

        Burger burger = new Burger();

        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100f);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient sauce2 = new Ingredient(IngredientType.SAUCE, "sour cream", 200f);

        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.addIngredient(sauce2);

        assertEquals(3, burger.ingredients.size());

        burger.removeIngredient(2);
        assertEquals(2, burger.ingredients.size());

    }


    @Test
    void testMoveIngredient() {

        Burger burger = new Burger();

        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100f);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient sauce2 = new Ingredient(IngredientType.SAUCE, "sour cream", 200f);

        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.addIngredient(sauce2);

        assertEquals(3, burger.ingredients.size());

        burger.moveIngredient(2, 1);
        assertEquals(3, burger.ingredients.size());

    }


    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient;


    @Test
    public void testGetReceipt() {

        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100f);

        when(mockIngredient.getName()).thenReturn("hot sauce");
        when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient.getPrice()).thenReturn(50f);

        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("black bun"), "Название булочки");
        assertTrue(receipt.contains("hot sauce"), "Наименование ингредиентов");
        assertTrue(receipt.contains("filling"), "Тип ингредиентов");
        assertTrue(receipt.contains("Price"), "Тип Цена");
        assertTrue(receipt.contains("250"), "Цена)");


    }
}




