package io.github.seggan.liquid.machinery;

import com.google.common.collect.BiMap;
import io.github.seggan.liquid.Items;
import io.github.seggan.liquid.LiquidMetal;
import io.github.seggan.liquid.VanillaItems;
import io.github.seggan.liquid.objects.LContainer;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.CSCoreLibPlugin.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class Centrifuge extends LContainer implements RecipeDisplayItem {

    public Centrifuge(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    protected void registerDefaultRecipes() {
        BiMap<ItemStack, SlimefunItemStack> liquids = LiquidMetal.getLiquids();
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_4K), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_6K), liquids.get(Items.SLAG)
            }
        );
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_6K), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_8K), liquids.get(Items.SLAG)
            }
        );
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_8K), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_10K), liquids.get(Items.SLAG)
            }
        );
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_10K), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_12K), liquids.get(Items.SLAG)
            }
        );
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_12K), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_14K), liquids.get(Items.SLAG)
            }
        );
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_14K), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_16K), liquids.get(Items.SLAG)
            }
        );
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_16K), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_18K), liquids.get(Items.SLAG)
            }
        );
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_18K), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_20K), liquids.get(Items.SLAG)
            }
        );
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_20K), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_22K), liquids.get(Items.SLAG)
            }
        );
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_22K), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(SlimefunItems.GOLD_24K), liquids.get(Items.SLAG)
            }
        );
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.STEEL_INGOT), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(SlimefunItems.DAMASCUS_STEEL_INGOT), liquids.get(Items.SLAG)
            }
        );
        registerRecipe(
            5,
            new ItemStack[]{
                liquids.get(SlimefunItems.DAMASCUS_STEEL_INGOT), new ItemStack(Material.BUCKET)
            },
            new ItemStack[]{
                liquids.get(VanillaItems.IRON_INGOT), liquids.get(Items.SLAG)
            }
        );
    }

    @Nonnull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList<>(recipes.size() * 2);

        for (MachineRecipe recipe : recipes) {
            displayRecipes.add(new CustomItem(
                new ItemStack(Material.LAVA_BUCKET, recipe.getInput().length),
                "&3Multiple Input Recipe")); // Can't exactly show all 9 items at once
            displayRecipes.add(recipe.getOutput()[0]); // Main output should be the first item
        }

        return displayRecipes;
    }

    @Override
    public int getInventoryType() {
        return 1;
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.SUNFLOWER);
    }

    @Override
    public int getEnergyConsumption() {
        return 32;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public String getMachineIdentifier() {
        return "CENTRIFUGE";
    }

    @Override
    public int getCapacity() {
        return 64;
    }
}
