package net.kyrptonaught.kyrptconfig.config.screen.items.lists.entries;

import net.kyrptonaught.kyrptconfig.config.screen.NotSuckyButton;
import net.kyrptonaught.kyrptconfig.config.screen.items.ConfigItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;

public class ListStringEntry extends ConfigItem<String> {
    boolean deleted = false;
    TextFieldWidget valueEntry;
    protected NotSuckyButton delButton;

    public ListStringEntry(String value) {
        super(Text.literal(""), value, value);
        valueEntry = new TextFieldWidget(MinecraftClient.getInstance().textRenderer, 0, 0, 125, 18, Text.literal("Text Entry"));
        valueEntry.setMaxLength(256);
        valueEntry.setText(value);
        this.delButton = new NotSuckyButton(0, 0, 35, 20, Text.translatable("key.kyrptconfig.config.delete"), widget -> {
            setDeleted(true);
        });
    }

    public void setDeleted(boolean isDeleted) {
        this.deleted = isDeleted;
        if (deleted) valueEntry.setText("");
    }

    public String getValue() {
        if (deleted || valueEntry.getText() == null) return null;
        if (valueEntry.getText().isEmpty() || valueEntry.getText().isBlank()) return null;
        return valueEntry.getText();
    }

    @Override
    public int getContentSize() {
        if (deleted) return -23;
        return super.getContentSize();
    }

    @Override
    public boolean keyPressed(KeyInput input) {
        super.keyPressed(input);
        if (deleted) return false;
        return valueEntry.keyPressed(input);
    }

    @Override
    public boolean charTyped(CharInput input) {
        if (deleted) return false;
        return valueEntry.charTyped(input);
    }

    @Override
    public void mouseClicked(Click click, boolean doubled) {
        super.mouseClicked(click, doubled);
        if (deleted) return;
        delButton.mouseClicked(click, doubled);
        valueEntry.setFocused(valueEntry.mouseClicked(click, doubled));
    }

    @Override
    public void render(DrawContext context, int x, int y, int mouseX, int mouseY, float delta) {
        if (deleted) return;
        super.render(context, x, y, mouseX, mouseY, delta);
        this.delButton.setY(y);
        this.delButton.setX(MinecraftClient.getInstance().getWindow().getScaledWidth() - delButton.getWidth() - 20);
        this.delButton.render(context, mouseX, mouseY, delta);

        if (valueEntry.isFocused())
            this.valueEntry.setWidth(175);
        else
            this.valueEntry.setWidth(125);

        this.valueEntry.setY(y + 1);
        this.valueEntry.setX(delButton.getX() - (valueEntry.getWidth()) - 7);
        this.valueEntry.render(context, mouseX, mouseY, delta);
    }
}