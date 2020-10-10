package io.github.overrun.squidlib.block;

import io.github.overrun.squidlib.SquidLib;
import io.github.overrun.squidlib.item.ItemLib;
import io.github.overrun.squidlib.util.Identifier;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author squid233
 * @since 2020/10/10
 */
@Mod.EventBusSubscriber
public class Blocks {
    public static final Block SQUID_BLOCK = BlockLib.createBlock(new Identifier(SquidLib.MODID, "squid_block"), new Block(Material.GROUND));

    private static final Block[] BLOCKS = {SQUID_BLOCK};

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> e) {
        e.getRegistry().registerAll(BLOCKS);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> e) {
        for (Block block : BLOCKS) {
            e.getRegistry().register(ItemLib.createItem(block.getRegistryName(), new ItemBlock(block)));
        }
    }

    @SubscribeEvent
    public static void registerModel(ModelRegistryEvent e) {
        for (Block block : BLOCKS) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }
}
