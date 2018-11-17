package danny8208.lazycore.api.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.GameData;

public class NormalRecipes {
    public static void addShapedRecipe(ItemStack output, Object... input) {
        ResourceLocation location = getNameForRecipe(output);
        CraftingHelper.ShapedPrimer primer = CraftingHelper.parseShaped(input);
        ShapedRecipes recipe = new ShapedRecipes(output.getItem().getRegistryName().toString(), primer.width, primer.height, primer.input, output);
        recipe.setRegistryName(location);
        GameData.register_impl(recipe);
    }

    public static void addShapelessRecipe(ItemStack output, Object... input) {
        ResourceLocation location = getNameForRecipe(output);
        ShapelessRecipes recipe = new ShapelessRecipes(location.getResourceDomain(), output, buildInput(input));
        recipe.setRegistryName(location);
        GameData.register_impl(recipe);
    }

    public static void addSmeltingRecipe(Block input, ItemStack output, float xp) {
        GameRegistry.addSmelting(input, output, xp);
    }

    public static void addSmeltingRecipe(Item input, ItemStack output, float xp) {
        GameRegistry.addSmelting(input, output, xp);
    }

    public static ResourceLocation getNameForRecipe(ItemStack output) {
        ModContainer activeContainer = Loader.instance().activeModContainer();
        ResourceLocation baseLoc = new ResourceLocation(activeContainer.getModId(), output.getItem().getRegistryName().getResourcePath());
        ResourceLocation recipeLoc = baseLoc;
        int index = 0;
        while(CraftingManager.REGISTRY.containsKey(recipeLoc)) {
            index++;
            recipeLoc = new ResourceLocation(activeContainer.getModId(), baseLoc.getResourcePath() + "_" + index);
        }
        return recipeLoc;
    }

    public static NonNullList<Ingredient> buildInput(Object[] input) {
        NonNullList<Ingredient> list = NonNullList.create();
        for(Object object : input) {
            if(object instanceof Ingredient) {
                list.add((Ingredient)object);
            } else {
                Ingredient ingredient = CraftingHelper.getIngredient(object);
                if(ingredient == null) {
                    ingredient = Ingredient.EMPTY;
                }
                list.add(ingredient);
            }
        }
        return list;
    }
}
