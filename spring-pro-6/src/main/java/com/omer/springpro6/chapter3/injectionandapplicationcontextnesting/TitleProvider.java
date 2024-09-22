package com.omer.springpro6.chapter3.injectionandapplicationcontextnesting;

import io.micrometer.common.util.StringUtils;

public class TitleProvider {

    private String title = "Gravity";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static TitleProvider instance(final String title) {
        var childProvider = new TitleProvider();
        if (StringUtils.isNotBlank(title)) {
            childProvider.setTitle(title);
        }
        return childProvider;
    }
}


