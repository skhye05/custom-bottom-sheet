package com.eljo.skhye05.custombottomsheet;

public class CustomBottomSheetItem {
    private String title;
    private int icon;

    public CustomBottomSheetItem() {
    }

    public CustomBottomSheetItem(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public int geticon() {
        return icon;
    }

    public void seticon(int icon) {
        this.icon = icon;
    }
    
}
