package net.kyrptonaught.kyrptconfig.config.screen;

import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.util.Colors;

public class NotSuckyButton extends ButtonWidget.Text {
    int buttonColor = Colors.WHITE;
    public boolean disableHover = false;

    public NotSuckyButton(int x, int y, int width, int height, net.minecraft.text.Text message, PressAction onPress) {
        super(x, y, width, height, message, onPress, DEFAULT_NARRATION_SUPPLIER);
    }

    public void setButtonColor(int color) {
        this.buttonColor = color;
    }

    public boolean detectHover(int mouseX, int mouseY) {
        return mouseX >= this.getX() && mouseY >= this.getY() && mouseX < this.getX() + this.width && mouseY < this.getY() + this.height;
    }

    @Override
    public net.minecraft.text.Text getMessage() {
        net.minecraft.text.Text message = super.getMessage();
        if (this.active) message = message.copy().withColor(buttonColor);
        return message;
    }

    @Override
    public boolean isHovered() {
        return !disableHover && super.isHovered();
    }
}
