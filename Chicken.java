public class Chicken implements Edible {

  // you can also declare an instance variable and return nutritionValue(getter) in the method. More private. To vary nutrition - pass into constructor.
  // private int nutritionValue = 200;

  public String canCluck(){
    return "cluck cluck";
  }

  public int nutritionValue(){
    return 200;
  }

}