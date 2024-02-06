import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import java.util.List;
import static org.junit.Assert.*;

public class DatabaseTests {

private Database database;

@Before
public void setUp() {
    database = new Database();
}

@Test
public void checkListBuns(){
    List<Bun> result = database.availableBuns();
    assertEquals(3, result.size());
    }

@Test
public void checkListIngredients(){
    List<Ingredient> result = database.availableIngredients();
    assertEquals(6, result.size());
    }
}
