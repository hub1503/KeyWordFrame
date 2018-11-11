package com.hub.util;

public class Step {
    private String desc;
    private String keyWord;
    private String param;
    private Locator locator;
    private String result;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Locator getlocator() {
        return locator;
    }

    public void setlocator(Locator element) {
        this.locator = element;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
