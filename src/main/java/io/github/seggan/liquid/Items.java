package io.github.seggan.liquid;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public final class Items {

    private Items() {}

    public static final ItemGroup CATEGORY = new ItemGroup(
        new NamespacedKey(Liquid.getInstance(), "liquids"),
        new CustomItemStack(Material.LAVA_BUCKET, "&6Liquids")
    );

    public static final SlimefunItemStack MELTER = new SlimefunItemStack(
        "MELTER",
        Material.BLAST_FURNACE,
        "&6熔化机",
        "",
        "&7一个高温熔炉",
        LoreBuilder.powerPerSecond(32),
        LoreBuilder.powerBuffer(64)
    );

    public static final SlimefunItemStack SOLIDIFIER = new SlimefunItemStack(
        "SOLIDIFIER",
        Material.LIGHT_BLUE_STAINED_GLASS,
        "&b固化机",
        "",
        "&7高级版的冰箱",
        LoreBuilder.powerPerSecond(8),
        LoreBuilder.powerBuffer(16)
    );

    public static final SlimefunItemStack TESTLCONTAINER = new SlimefunItemStack(
        "TESTLCONTAINER",
        Material.HAY_BLOCK,
        "&bTest LContainer",
        "",
        "&7Test Item"
    );

    public static final SlimefunItemStack TESTLCONTAINER_2 = new SlimefunItemStack(
        "TESTLCONTAINER_2",
        Material.HAY_BLOCK,
        "&bTest LContainer 2",
        "",
        "&7Test Item"
    );

    public static final SlimefunItemStack MIXER = new SlimefunItemStack(
        "MIXER",
        Material.BLAST_FURNACE,
        "&6混合机",
        "",
        "&7这个升级后的熔化机",
        "&7非常适合用来混合液体",
        LoreBuilder.powerPerSecond(64),
        LoreBuilder.powerBuffer(128)
    );

    public static final SlimefunItemStack CENTRIFUGE = new SlimefunItemStack(
        "CENTRIFUGE",
        Material.HAY_BLOCK,
        "&6离心分离机",
        "",
        "&7离心机可以用来分离液体",
        LoreBuilder.powerPerSecond(32),
        LoreBuilder.powerBuffer(64)
    );

    public static final SlimefunItemStack CRYSTALLIZER = new SlimefunItemStack(
        "CRYSTALLIZER",
        Material.DIAMOND_BLOCK,
        "&b结晶器",
        "",
        "&7结晶器能够用来固化晶体",
        LoreBuilder.powerPerSecond(8),
        LoreBuilder.powerBuffer(16)
    );

    public static final SlimefunItemStack SPRAY_SOLIDIFIER = new SlimefunItemStack(
        "SPRAY_SOLIDIFIER",
        Material.SMITHING_TABLE,
        "&b喷雾固化机",
        "",
        "&7这台固化机通过喷出液体",
        "&7将液体以粉尘形式固化,",
        "&7因此运行速度更快,",
        "&7但也比普通的固化机更消耗能量.",
        LoreBuilder.powerPerSecond(64),
        LoreBuilder.powerBuffer(128)
    );

    public static final SlimefunItemStack SLAG = new SlimefunItemStack(
        "SLAG",
        Material.CHARCOAL,
        "&7熔渣",
        "",
        "&7垃圾可能是别人眼中的宝藏..."
    );
}
