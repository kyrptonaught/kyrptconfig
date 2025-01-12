package net.kyrptonaught.kyrptconfig;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class TagHelper {

    public static List<Identifier> getBlockIDsInTag(Identifier blockTagKey) {
        List<Identifier> blocks = new ArrayList<>();
        List<RegistryEntryList.Named<Block>> tags = Registries.BLOCK.streamTags().toList();

        for (RegistryEntryList.Named<Block> tagKey : tags) {
            if (tagKey.getTag().id().equals(blockTagKey)) {
                Registries.BLOCK.iterateEntries(tagKey.getTag()).forEach(registryEntry -> {
                    registryEntry.getKey().ifPresent(registryEntry2 -> blocks.add(registryEntry2.getValue()));
                });
                break;
            }
        }
        return blocks;
    }

    public static List<Block> getBlocksInTag(Identifier blockTagKey) {
        List<Block> blocks = new ArrayList<>();
        List<RegistryEntryList.Named<Block>> tags = Registries.BLOCK.streamTags().toList();

        for (RegistryEntryList.Named<Block> tagKey : tags) {
            if (tagKey.getTag().id().equals(blockTagKey)) {
                Registries.BLOCK.iterateEntries(tagKey.getTag()).forEach(registryEntry -> {
                    blocks.add(registryEntry.value());
                });
                break;
            }
        }
        return blocks;
    }

    public static List<Identifier> getItemsIDsInTag(Identifier blockTagKey) {
        List<Identifier> items = new ArrayList<>();
        List<RegistryEntryList.Named<Item>> tags = Registries.ITEM.streamTags().toList();

        for (RegistryEntryList.Named<Item> tagKey : tags) {
            if (tagKey.getTag().id().equals(blockTagKey)) {
                Registries.ITEM.iterateEntries(tagKey.getTag()).forEach(registryEntry -> {
                    registryEntry.getKey().ifPresent(registryEntry2 -> items.add(registryEntry2.getValue()));
                });
                break;
            }
        }
        return items;
    }

    public static List<Item> getItemsInTag(Identifier blockTagKey) {
        List<Item> items = new ArrayList<>();
        List<RegistryEntryList.Named<Item>> tags = Registries.ITEM.streamTags().toList();

        for (RegistryEntryList.Named<Item> tagKey : tags) {
            if (tagKey.getTag().id().equals(blockTagKey)) {
                Registries.ITEM.iterateEntries(tagKey.getTag()).forEach(registryEntry -> {
                    items.add(registryEntry.value());
                });
                break;
            }
        }
        return items;
    }
}