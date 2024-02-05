package com.elsayed.core.models.impl;


import com.elsayed.core.models.Image;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.settings.SlingSettingsService;


@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Image.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ImageImpl implements Image {

    @ValueMapValue
    private String imageTitle;


    @SlingObject
    private SlingSettingsService slingSettingsService;

    @ScriptVariable
    Page currentPage;

    @Override
    public String getImageTitle() {
        return imageTitle;
    }

    @Override
    public boolean getIsAuthor() {
        if (slingSettingsService != null) {
            return slingSettingsService.getRunModes().contains("author");
        }
        return false;
    }


    @Override
    public boolean getIsPublisher() {
        if (slingSettingsService != null) {
            return slingSettingsService.getRunModes().contains("publisher");
        }
        return false;
    }

    @Override
    public String getPageTitle() {
        return currentPage.getTitle();
    }

    @Override
    public String getPagePath() {
        return currentPage.getPath();
    }

}
