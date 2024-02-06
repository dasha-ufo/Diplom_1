import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class IngredientTests {
    Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;
    private static Random random = new Random();
    private static String randomName = RandomStringUtils.randomAlphabetic(12);
    private static float randomPrice = random.nextFloat();

    public IngredientTests(IngredientType type, String name, float price){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] setSexValue() {
        return new Object[][]{
                {SAUCE, randomName, randomPrice},
                {FILLING, null, 0F},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetName(){
        String result = ingredient.getName();
        Assert.assertEquals(name,result);
    }

    @Test
    public void checkGetPrice(){
        float result = ingredient.getPrice();
        Assert.assertEquals(price,result, 1e-9);
    }

    @Test
    public void checkGetType(){
        IngredientType result = ingredient.getType();
        Assert.assertEquals(type,result);
    }
}
