package com.mingrisoft.enums;

public enum Size {
    SMALL("我是小号匹萨"), MEDIUM("我是中号匹萨"), LARGE("我是大号匹萨");
    private String description;
    
    private Size(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public static void main(String[] args) {
        for (Size size : Size.values()) {
            System.out.println(size + ":" + size.getDescription());
        }
    }
}
