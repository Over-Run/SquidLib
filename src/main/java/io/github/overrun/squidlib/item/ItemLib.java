package io.github.overrun.squidlib.item;

import io.github.overrun.squidlib.SquidLib;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;

/**
 * @author squid233
 * @since 2020/10/09
 */
public class ItemLib {
    public static final Comp EMPTY = new Comp();

    public static Item createItem(ResourceLocation id, Item item) {
        SquidLib.getLogger().info("Created item: " + id);
        return item.setRegistryName(id).setUnlocalizedName(id.getResourceDomain() + '.' + id.getResourcePath());
    }

    /**
     * Create an item, auto set registry name to {@code namespace:path} and set unlocalized name to {@code item.namespace.path.name}.<br>
     * For example: <code>public static final {@link Item} EXAMPLE = ItemLib.createItem(new {@link io.github.overrun.squidlib.util.Identifier Identifier}("example", "item"));</code>
     *
     * @param id The item's identifier.
     * @return An item.
     * @see ItemLib#createItem(ResourceLocation, Comp)
     */
    public static Item createItem(ResourceLocation id) {
        return createItem(id, new Item());
    }

    /**
     * Create item, with comp.
     *
     * @param id Item's identifier.
     * @param comp The comps, include CreativeTab, maxStackSize, etc.
     * @return The item.
     * @see ItemLib#createItem(ResourceLocation)
     */
    public static Item createItem(ResourceLocation id, Comp comp) {
        if (comp == null) {
            comp = EMPTY;
        }
        Item item;
        if (comp.isFood && comp.foodComponent != null) {
            FoodComponent fc = comp.foodComponent;
            item = createItem(id, new ItemFood(fc.getHunger(), fc.getSaturation(), fc.isMeat()));
            ((ItemFood) item).setPotionEffect(fc.getPotionEffect(), fc.getProbability());
        } else {
            item = createItem(id);
        }
        if (comp.group != null) {
            item.setCreativeTab(comp.group);
        }
        if (comp.stackSize != 0) {
            item.setMaxStackSize(comp.stackSize);
        }
        return item;
    }

    public static class Comp {
        private CreativeTabs group;
        private int stackSize;
        private boolean isFood;
        private FoodComponent foodComponent;

        public Comp group(CreativeTabs group) {
            this.group = group;
            return this;
        }

        public Comp stackSize(int stackSize) {
            this.stackSize = stackSize;
            return this;
        }

        public Comp food(FoodComponent foodComponent) {
            this.foodComponent = foodComponent;
            isFood = true;
            return this;
        }
    }
}
