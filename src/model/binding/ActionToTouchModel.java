package model.binding;

public class ActionToTouchModel {

    private boolean isSelected;

    public ActionToTouchModel() {
        this.isSelected = false;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}