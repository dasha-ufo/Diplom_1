import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;


public class BunTests {
private Bun bun;
private String name;
private float price;
private Random random;


    @Before
    public void setUp() {
        name = RandomStringUtils.randomAlphabetic(6);
        random = new Random();
        price = random.nextFloat();
        bun = new Bun(name, price);
    }

    @Test
    public void checkGetName(){
        String result = bun.getName();
        Assert.assertEquals(name,result);
    }

    @Test
    public void checkGetPrice(){
        float result = bun.getPrice();
        Assert.assertEquals(price,result, 1e-9);
    }
}