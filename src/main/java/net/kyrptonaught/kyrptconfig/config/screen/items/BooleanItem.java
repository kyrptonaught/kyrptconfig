package net.kyrptonaught.kyrptconfig.config.screen.items;

import net.kyrptonaught.kyrptconfig.config.screen.NotSuckyButton;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.ColorHelper;

public class BooleanItem extends ConfigItem<Boolean> {
    private final NotSuckyButton boolWidget;

    public BooleanItem(Text name, Boolean value, Boolean defaultValue) {
        super(name, value, defaultValue);
        this.boolWidget = new NotSuckyButton(0, 0, 100, 20, Text.literal("BoolButton"), widget -> {
            setValue(!this.value);
        });
        setValue(value);
        useDefaultResetBTN();
    }

    @Override
    public void setValue(Boolean value) {
        super.setValue(value);
        if (value) {
            boolWidget.setMessage(Text.translatable("key.kyrptconfig.config.true"));
            boolWidget.setButtonColor(ColorHelper.withAlpha(0xff, DyeColor.LIME.getFireworkColor()));
        } else {
            boolWidget.setMessage(Text.translatable("key.kyrptconfig.config.false"));
            boolWidget.setButtonColor(Colors.RED);
        }
    }

    @Override
    public void mouseClicked(Click click, boolean doubled) {
        super.mouseClicked(click, doubled);
        boolWidget.mouseClicked(click, doubled);
    }

    @Override
    public void render(DrawContext context, int x, int y, int mouseX, int mouseY, float delta) {
        super.render(context, x, y, mouseX, mouseY, delta);
        this.boolWidget.setY(y);
        this.boolWidget.setX(resetButton.getX() - resetButton.getWidth() - (boolWidget.getWidth() / 2) - 20);

        boolWidget.render(context, mouseX, mouseY, delta);
    }
}