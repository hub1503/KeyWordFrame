package com.hub.util;

public class Locator {
    private ByType byType;
    private String value;

    public enum ByType{
        xpath, id, linkText, name, className, cssSelector, partialLinkText, tagName;
    }

    public ByType getByType() {
        return byType;
    }

    public void setByType(ByType byType) {
        this.byType = byType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
