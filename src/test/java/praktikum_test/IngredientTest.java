package praktikum_test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {


    static Stream<Arguments> ingredientData() {
        return Stream.of(
                Arguments.of(IngredientType.SAUCE, "hot sauce", 100f),
                Arguments.of(IngredientType.SAUCE, "sour cream", 200f),
                Arguments.of(IngredientType.FILLING, "cutlet", 100f),
                Arguments.of(IngredientType.SAUCE, "chili sauce", 300f),
                Arguments.of(IngredientType.FILLING, "dinosaur", 200f),
                Arguments.of(IngredientType.FILLING, "sausage", 300f)
        );
    }



    @ParameterizedTest
    @MethodSource("ingredientData")
    public void showGetName (IngredientType type, String name, float price) {
        Ingredient ingredient=new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }



    @ParameterizedTest
    @MethodSource("ingredientData")
    public void showGetPrice (IngredientType type, String name, float price) {
        Ingredient ingredient=new Ingredient(type, name, price);

        assertEquals(price, ingredient.getPrice());

    }

    @ParameterizedTest
    @MethodSource("ingredientData")
    public void showGetType (IngredientType type, String name, float price) {
        Ingredient ingredient=new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());

    }




}

