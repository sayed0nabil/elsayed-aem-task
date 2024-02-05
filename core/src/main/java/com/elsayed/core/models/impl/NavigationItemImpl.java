package com.elsayed.core.models.impl;

import com.elsayed.core.models.NavigationItem;

public class NavigationItemImpl implements NavigationItem {


    private String title;
    private String path;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
