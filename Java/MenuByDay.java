package Java;


public class MenuByDay {



    private String date,day, recipe1,recipe2, recipe3;

    public MenuByDay(String date, String day, String recipe1,String recipe2, String recipe3)
    {
        this.setDate(date);
        this.setDay(day);
        this.setRecipe1(recipe1);
        this.setRecipe2(recipe2);
        this.setRecipe3(recipe3);
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRecipe1() {
        return recipe1;
    }

    public void setRecipe1(String recipe1) {
        this.recipe1 = recipe1;
    }

    public String getRecipe2() {
        return recipe2;
    }

    public void setRecipe2(String recipe2) {
        this.recipe2 = recipe2;
    }

    public String getRecipe3() {
        return recipe3;
    }

    public void setRecipe3(String recipe3) {
        this.recipe3 = recipe3;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
}
