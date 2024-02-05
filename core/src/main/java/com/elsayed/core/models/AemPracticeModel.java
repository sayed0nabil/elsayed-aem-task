package com.elsayed.core.models;

import java.util.List;

public interface AemPracticeModel {

    String getImagePath();

    boolean isBackgroundImage();

    List<NavigationItem> getNavigationItems();
}
