package io.github.overrun.squidlib.block;

import io.github.overrun.squidlib.SquidLib;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

/**
 * @author squid233
 * @since 2020/10/10
 */
public class BlockLib {
    public static Block createBlock(ResourceLocation id, Block block) {
        SquidLib.getLogger().info("Created block: " + id);
        return block.setRegistryName(id).setUnlocalizedName(id.getResourceDomain() + '.' + id.getResourcePath());
    }
}
