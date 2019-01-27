package danny8208.lazycore.common.recipes;

import danny8208.lazycore.api.recipe.NormalRecipes;
import danny8208.lazycore.common.blocks.ModBlocks;
import danny8208.lazycore.common.items.ModItems;
import net.minecraft.item.ItemStack;

public class CraftingRecipes {
    public static void uncompressionRecipes() {
        NormalRecipes.addUncompressionRecipe(new ItemStack(ModItems.ingotBronze, 9), "blockBronze");
        NormalRecipes.addUncompressionRecipe(new ItemStack(ModItems.ingotTin, 9), "blockTin");
        NormalRecipes.addUncompressionRecipe(new ItemStack(ModItems.ingotCopper, 9), "blockCopper");
        NormalRecipes.addUncompressionRecipe(new ItemStack(ModItems.ingotSteel, 9), "blockSteel");
        NormalRecipes.addUncompressionRecipe(new ItemStack(ModItems.ingotTungsten, 9), "blockTungsten");

        NormalRecipes.addUncompressionRecipe(new ItemStack(ModItems.nuggetBronze, 9), "ingotBronze");
        NormalRecipes.addUncompressionRecipe(new ItemStack(ModItems.nuggetTin, 9), "ingotTin");
        NormalRecipes.addUncompressionRecipe(new ItemStack(ModItems.nuggetCopper, 9), "ingotCopper");
        NormalRecipes.addUncompressionRecipe(new ItemStack(ModItems.nuggetSteel, 9), "ingotSteel");
        NormalRecipes.addUncompressionRecipe(new ItemStack(ModItems.nuggetTungsten, 9), "ingotTungsten");
    }

    public static void compressionRecipes() {
        NormalRecipes.addShapelessOreRecipe(new ItemStack(ModItems.ingotBronze), "nuggetBronze", "nuggetBronze", "nuggetBronze", "nuggetBronze", "nuggetBronze", "nuggetBronze", "nuggetBronze", "nuggetBronze", "nuggetBronze");
        NormalRecipes.addShapelessOreRecipe(new ItemStack(ModItems.ingotTin), "nuggetTin", "nuggetTin", "nuggetTin", "nuggetTin", "nuggetTin", "nuggetTin", "nuggetTin", "nuggetTin", "nuggetTin");
        NormalRecipes.addShapelessOreRecipe(new ItemStack(ModItems.ingotCopper), "nuggetCopper", "nuggetCopper", "nuggetCopper", "nuggetCopper", "nuggetCopper", "nuggetCopper", "nuggetCopper", "nuggetCopper", "nuggetCopper");
        NormalRecipes.addShapelessOreRecipe(new ItemStack(ModItems.ingotSteel), "nuggetSteel", "nuggetSteel", "nuggetSteel", "nuggetSteel", "nuggetSteel", "nuggetSteel", "nuggetSteel", "nuggetSteel", "nuggetSteel");
        NormalRecipes.addShapelessOreRecipe(new ItemStack(ModItems.ingotTungsten), "nuggetTungsten", "nuggetTungsten", "nuggetTungsten", "nuggetTungsten", "nuggetTungsten", "nuggetTungsten", "nuggetTungsten", "nuggetTungsten", "nuggetTungsten");

        NormalRecipes.addShapelessOreRecipe(new ItemStack(ModBlocks.blockBronze), "ingotBronze", "ingotBronze", "ingotBronze", "ingotBronze", "ingotBronze", "ingotBronze", "ingotBronze", "ingotBronze", "ingotBronze");
        NormalRecipes.addShapelessOreRecipe(new ItemStack(ModBlocks.blockTin), "ingotTin", "ingotTin", "ingotTin", "ingotTin", "ingotTin", "ingotTin", "ingotTin", "ingotTin", "ingotTin");
        NormalRecipes.addShapelessOreRecipe(new ItemStack(ModBlocks.blockCopper), "ingotCopper", "ingotCopper", "ingotCopper", "ingotCopper", "ingotCopper", "ingotCopper", "ingotCopper", "ingotCopper", "ingotCopper");
        NormalRecipes.addShapelessOreRecipe(new ItemStack(ModBlocks.blockSteel), "ingotSteel", "ingotSteel", "ingotSteel", "ingotSteel", "ingotSteel", "ingotSteel", "ingotSteel", "ingotSteel", "ingotSteel");
        NormalRecipes.addShapelessOreRecipe(new ItemStack(ModBlocks.blockTungsten), "ingotTungsten", "ingotTungsten", "ingotTungsten", "ingotTungsten", "ingotTungsten", "ingotTungsten", "ingotTungsten", "ingotTungsten", "ingotTungsten");
    }

    public static void miscRecipes() {
        NormalRecipes.addShapelessOreRecipe(new ItemStack(ModItems.ingotBronze), "ingotCopper", "ingotCopper", "ingotCopper", "ingotTin");
    }

    public static void smeltingRecipes() {
        NormalRecipes.addSmelting(ModBlocks.oreTin, new ItemStack(ModItems.ingotTin), 0.1F);
        NormalRecipes.addSmelting(ModBlocks.oreCopper, new ItemStack(ModItems.ingotCopper), 0.1F);
        NormalRecipes.addSmelting(ModBlocks.oreTungsten, new ItemStack(ModItems.ingotTungsten), 0.1F);
    }
}
