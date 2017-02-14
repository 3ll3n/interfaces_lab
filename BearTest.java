// methods
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
// classes
import org.junit.*;

public class BearTest {

  Bear bear;
  Salmon salmon;
  Human human;
  Chicken chicken;

  @Before 
  public void before() {
    bear = new Bear("Baloo");
    human = new Human();
    salmon = new Salmon();
    chicken = new Chicken();
  }

  @Test
  public void hasName(){
    assertEquals("Baloo", bear.getName());
  }

  @Test
  public void bellyStartsEmpty(){
    assertEquals(0, bear.foodCount());
  }

  @Test
  public void canEatSalmon(){
    bear.eat(salmon);
    assertEquals(bear.foodCount(), 1);
  }

  @Test
  public void shouldEmptyBellyAfterSleeping(){
    bear.eat(salmon);
    bear.sleep();
    assertEquals(bear.foodCount(), 0);
  }

  @Test
  public void canEatHuman(){
   bear.eat(human);
   assertEquals(1, bear.foodCount());
  }

  @Test
  public void canThrowUp() {
    bear.eat(chicken);
    Edible food = bear.throwUp();
    assertNotNull(food);
    Chicken original = (Chicken)food;
    assertEquals("cluck cluck", original.canCluck());
  }

  @Test
  public void canEatChicken(){
    bear.eat(chicken);
    assertEquals(1, bear.foodCount());
  }

  @Test
  public void chickenCanCluck(){
    assertEquals("cluck cluck", chicken.canCluck());
  }

  @Test
  public void nutritionValueChicken(){
    assertEquals(200, chicken.nutritionValue());
  }

  @Test
  public void nutritionValueSalmon(){
    assertEquals(300, salmon.nutritionValue());
  }

  @Test
  public void nutritionValueHuman(){
    assertEquals(10, human.nutritionValue());
  }

  @Test
  public void totalNutritionBear(){
    bear.eat(human);
    bear.eat(chicken);
    bear.eat(salmon);
    assertEquals(510, bear.totalNutrition());
  }

}