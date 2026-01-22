package net.kyrptonaught.kyrptconfig.config.screen.items.lists.entries;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.List;

public class IconEntry<E> extends ListStringEntry {
    protected boolean allowTags = false;
    protected List<E> enteredTag;
    int selectedTag = 0;
    float deltas;

    public IconEntry(String value, boolean allowTags) {
        super(value);
        this.allowTags = allowTags;
    }

    public ItemConvertible getItemToRender(float delta) {
        return Items.BARRIER;
    }

    public void tickTags(float delta) {
        deltas += delta;
        if (deltas > 45 && allowTags && enteredTag != null) {
            selectedTag++;
            deltas = 0;
        }
        if (enteredTag == null || selectedTag >= enteredTag.size()) selectedTag = 0;
    }

    @Override
    public void render(DrawContext context, int x, int y, int mouseX, int mouseY, float delta) {
        super.render(context, x, y, mouseX, mouseY, delta);
        if (deleted) return;
        ItemConvertible item = getItemToRender(delta);
        context.drawItem(new ItemStack(item), x, y);
    }
}
