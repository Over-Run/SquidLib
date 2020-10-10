package io.github.overrun.squidlib.util;

import net.minecraft.util.ResourceLocation;

/**
 * @author squid233
 * @since 2020/10/10
 */
public class Identifier extends ResourceLocation {
    public Identifier(String id) {
        super(id);
    }

    public Identifier(String namespace, String path) {
        super(namespace, path);
    }
}
