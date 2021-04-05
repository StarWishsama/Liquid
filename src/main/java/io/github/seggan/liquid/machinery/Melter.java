package io.github.seggan.liquid.machinery;

import io.github.mooy1.infinitylib.slimefun.abstracts.TickingContainer;
import io.github.seggan.liquid.Items;
import io.github.seggan.liquid.LiquidAddon;
import io.github.seggan.liquid.items.fluids.FluidHoldingContainer;
import io.github.seggan.liquid.items.fluids.FluidTankTextures;
import io.github.seggan.liquid.items.fluids.PortableFluidTank;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class Melter extends TickingContainer implements FluidHoldingContainer, EnergyNetComponent {

    private static final int[] BACKGROUND = new int[]{0, 4, 6, 7, 8, 9, 13, 18, 27, 31, 36, 40, 41, 42, 43, 44};
    private static final int[] INPUT_BORDER = new int[]{1, 3, 10, 12, 19, 21, 28, 30, 37, 38, 39};
    private static final int[] OUTPUT_BORDER = new int[]{14, 15, 16, 17, 23, 26, 32, 33, 34, 35};

    private static final int[] OUTPUT_SLOTS = new int[]{24, 25};

    private static final int SOLID_LABEL = 2;
    private static final int SOLID_SLOT = 11;

    private static final int TANK_LABEL = 20;
    private static final int TANK_SLOT = 29;

    private static final int CONTENTS = 22;

    private static final int ENABLED = 5;

    private static final ItemStack ENABLED_ITEM = new CustomItem(
        Material.STRUCTURE_VOID,
        "&aEnabled",
        "",
        "&7Click to disable the Melter"
    );
    private static final ItemStack DISABLED_ITEM = new CustomItem(
        Material.BARRIER,
        "&cDisabled",
        "",
        "&7Click to enable the Melter"
    );

    public static final RecipeType RECIPE_TYPE = new RecipeType(
        new NamespacedKey(LiquidAddon.getInstance(), "melter"),
        Items.MELTER
    );

    private static final int CAPACITY = 162;

    public Melter(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    protected void setupMenu(@Nonnull BlockMenuPreset preset) {
        preset.drawBackground(BACKGROUND);

        for (int i : INPUT_BORDER) {
            preset.addItem(i, ChestMenuUtils.getInputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int i : OUTPUT_BORDER) {
            preset.addItem(i, ChestMenuUtils.getOutputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }

        preset.addItem(ENABLED, DISABLED_ITEM);

        preset.addItem(SOLID_LABEL, new CustomItem(
            Material.IRON_INGOT,
            "&fInsert Solid Here"
        ), ChestMenuUtils.getEmptyClickHandler());

        preset.addItem(TANK_LABEL, new CustomItem(
            SkullItem.fromBase64(FluidTankTextures.EMPTY.getTexture()),
            "&fInsert Portable Fluid Tank Here"
        ), ChestMenuUtils.getEmptyClickHandler());

        preset.addItem(CONTENTS, new CustomItem(
            Material.LAVA_BUCKET,
            "&6Contents",
            "",
            "&7Liquid: None",
            "&7Amount: 0"
        ), ChestMenuUtils.getEmptyClickHandler());
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) {
        if (Boolean.parseBoolean(BlockStorage.getLocationInfo(b.getLocation(), "enabled"))) {
            menu.replaceExistingItem(ENABLED, ENABLED_ITEM);
            menu.addMenuClickHandler(ENABLED, (p, slot, item, action) -> {
                BlockStorage.addBlockInfo(b, "enabled", Boolean.toString(false));
                onNewInstance(menu, b);
                return false;
            });
        } else {
            menu.replaceExistingItem(ENABLED, DISABLED_ITEM);
            menu.addMenuClickHandler(ENABLED, (p, slot, item, action) -> {
                BlockStorage.addBlockInfo(b, "enabled", Boolean.toString(true));
                onNewInstance(menu, b);
                return false;
            });
        }
    }

    @Override
    protected void tick(@Nonnull BlockMenu menu, @Nonnull Block b, @Nonnull Config data) {

    }

    @Nonnull
    @Override
    protected int[] getTransportSlots(@Nonnull DirtyChestMenu menu, @Nonnull ItemTransportFlow flow, ItemStack item) {
        if (flow == ItemTransportFlow.INSERT) {
            if (SlimefunItem.getByItem(item) instanceof PortableFluidTank) {
                return new int[]{TANK_SLOT};
            } else {
                return new int[]{SOLID_SLOT};
            }
        } else {
            return OUTPUT_SLOTS;
        }
    }

    @Override
    public int getLiquidCapacity() {
        return 162;
    }


    @Nonnull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public int getCapacity() {
        return 512;
    }
}
