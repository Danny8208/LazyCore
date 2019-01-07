package danny8208.lazycore.common;

public class CraftingRecipes {
  public void nuggetIngot() {
    NormalRecipes.addShapelessRecipe(new ItemStack(ModItems.nuggetTungsten, 9), "ingotTungsten");
    NormalRecipes.addShapelessRecipe(new ItemStack(ModItems.nuggetCopper, 9), "ingotCopper");
    NormalRecipes.addShapelessRecipe(new ItemStack(ModItems.nuggetBronze, 9), "ingotBronze");
    NormalRecipes.addShapelessRecipe(new ItemStack(ModItems.nuggetSteel, 9), "ingotSteel");
    NormalRecipes.addShapelessRecipe(new ItemStack(ModItems.nuggetTin, 9), "ingotTin");
  }
  
  public void ingotNugget() {
  }
}
