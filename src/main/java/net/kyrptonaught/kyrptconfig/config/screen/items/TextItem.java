package net.kyrptonaught.kyrptconfig.config.screen.items;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;

public class TextItem extends ConfigItem<String> {

    TextFieldWidget valueEntry;

    public TextItem(Text name, String value, String defaultValue) {
        super(name, value, defaultValue);
        useDefaultResetBTN();
        valueEntry = new TextFieldWidget(MinecraftClient.getInstance().textRenderer, 0, 0, 96, 18, Text.literal("Text Entry"));
        setMaxLength(256);
        valueEntry.setText(value);
        valueEntry.setChangedListener(this::setValue);
    }

    public TextItem setMaxLength(int length) {
        valueEntry.setMaxLength(length);
        return this;
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
    }

    @Override
    public void resetToDefault() {
        setValue(defaultValue);
        valueEntry.setText(value);
    }

    @Override
    public boolean keyPressed(KeyInput input) {
        super.keyPressed(input);
        return valueEntry.keyPressed(input);
    }

    @Override
    public boolean charTyped(CharInput input) {
        return valueEntry.charTyped(input);
    }

    @Override
    public void mouseClicked(Click click, boolean doubled) {
        super.mouseClicked(click, doubled);
        valueEntry.setFocused(valueEntry.mouseClicked(click, doubled));
    }

    @Override
    public void render(DrawContext context, int x, int y, int mouseX, int mouseY, float delta) {
        super.render(context, x, y, mouseX, mouseY, delta);

        if (valueEntry.isFocused())
            this.valueEntry.setWidth(150);
        else
            this.valueEntry.setWidth(96);

        this.valueEntry.setY(y + 1);
        this.valueEntry.setX(resetButton.getX() - (valueEntry.getWidth()) - 7);

        valueEntry.render(context, mouseX, mouseY, delta);
    }
}