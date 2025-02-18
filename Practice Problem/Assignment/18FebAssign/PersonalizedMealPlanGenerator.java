interface MealPlan {
    String getPlanDetails();
}

class VegetarianMeal implements MealPlan {
    private String dish;
    public VegetarianMeal(String dish) {
        this.dish = dish;
    }
    @Override
    public String getPlanDetails() {
        return "Vegetarian dish: " + dish;
    }
}

class VeganMeal implements MealPlan {
    private String dish;
    public VeganMeal(String dish) {
        this.dish = dish;
    }
    @Override
    public String getPlanDetails() {
        return "Vegan dish: " + dish;
    }
}

class KetoMeal implements MealPlan {
    private String dish;
    public KetoMeal(String dish) {
        this.dish = dish;
    }
    @Override
    public String getPlanDetails() {
        return "Keto dish: " + dish;
    }
}

class HighProteinMeal implements MealPlan {
    private String dish;
    public HighProteinMeal(String dish) {
        this.dish = dish;
    }
    @Override
    public String getPlanDetails() {
        return "High Protein dish: " + dish;
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;
    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }
    public T getMealPlan() {
        return mealPlan;
    }
    @Override
    public String toString() {
        return mealPlan.getPlanDetails();
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        if (mealPlan == null) {
            throw new IllegalArgumentException("MealPlan cannot be null");
        }
        return new Meal<>(mealPlan);
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal("Vegetable Stir Fry"));
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal("Quinoa Salad"));
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal("Grilled Chicken with Avocado"));
        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal("Beef Steak with Broccoli"));

        System.out.println(vegetarianMeal);
        System.out.println(veganMeal);
        System.out.println(ketoMeal);
        System.out.println(highProteinMeal);
    }
}
