import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.Validate.notEmpty;
import static org.junit.Assert.*;

    @RunWith(MockitoJUnitRunner.class)
    public class BurgerTests {

    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
    burger = new Burger();
}

    @Test
    public void checkSetBun(){
    assertNull(burger.bun);
    burger.setBuns(bun);
    assertNotNull(burger.bun);
}


    @Test
    public void checkAddIngredients(){
    isEmpty(burger.ingredients);
    burger.addIngredient(ingredient);
    notEmpty(burger.ingredients);
}

    @Test
    public void checkRemoveIngredients(){
    burger.addIngredient(ingredient);
    burger.addIngredient(ingredient);
    int sizeOfList = burger.ingredients.size();
    burger.removeIngredient(sizeOfList-1);
    assertEquals(sizeOfList - 1, burger.ingredients.size());
}

    @Test
    public void checkMoveIngredients(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        int index = burger.ingredients.size() - 1;
        int newIndex = burger.ingredients.size() - 2;
        burger.moveIngredient(index,newIndex);
        assertEquals(newIndex, burger.ingredients.size()-2);
    }

    @Test
    public void checkGetPrice(){
        Random random = new Random();
        float bunPrice = random.nextFloat() + 10;
        float ingredientPrice = random.nextFloat() + 20;

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        float expectation = bunPrice * 2 + ingredientPrice;
        float result = burger.getPrice();
        assertEquals(expectation,result, 1e-9);
    }


        @Test
        public void checkGetReceipt(){
            burger.setBuns(bun);
            burger.addIngredient(ingredient);

            Mockito.when(bun.getName()).thenReturn("Булочка с маком");
            Mockito.when(ingredient.getName()).thenReturn("Малиновое варенье");
            Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
            Mockito.when(burger.getPrice()).thenReturn(300.901000F);

            String nameBun = bun.getName();
            String nameIngredient = ingredient.getName();
            String type = ingredient.getType().toString().toLowerCase();
            String price = String.format("%,6f", burger.getPrice());

            String result = burger.getReceipt();
            String expectation = "(==== " + nameBun + " ====)\n= "+ type +" "+ nameIngredient + " =\n(==== " + nameBun + " ====)\n\nPrice: "+ price +"\n";
            System.out.println(result);
            System.out.println(expectation);
            assertEquals(expectation, result);
        }

}
