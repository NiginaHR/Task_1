package praktikum_test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Bun;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {


    static Stream<Arguments> bunData() {
        return Stream.of(
                Arguments.of("Чикенбургер", 150f),
                Arguments.of("Фрешролл", 100f),
                Arguments.of("Чикенфреш", 205f)
        );
    }



    @ParameterizedTest
    @MethodSource("bunData")
    public void testGetName(String name, float price) {
        Bun bun=new Bun(name, price);
        assertEquals(name, bun.getName());
    }



    @ParameterizedTest
    @MethodSource("bunData")
    public void testGetPrice(String name, float price) {

        Bun bun=new Bun(name, price);

        assertEquals(price, bun.getPrice());

    }

}


