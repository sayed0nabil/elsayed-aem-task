package com.elsayed.core.models.impl;


import com.elsayed.core.models.AemPracticeModel;
import com.elsayed.core.models.NavigationItem;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Model(adaptables = Resource.class, adapters = AemPracticeModel.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AemPracticeModelImpl implements AemPracticeModel {
    private static final Logger LOG = LoggerFactory.getLogger(AemPracticeModelImpl.class);

    @Inject
    Resource resource;


    @ValueMapValue
    private String imagePath;

    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public boolean isBackgroundImage() {
        return true;
    }



    @Override
    public List<NavigationItem> getNavigationItems() {
        List<NavigationItem> navigationItems=new ArrayList<>();
        try {
            Resource navigationItems1 = resource.getChild("navigationItems");
            if(navigationItems1!=null){
                for (Resource navigationItemResource : navigationItems1.getChildren()) {

                    NavigationItem navigationItem = new NavigationItemImpl();
                    navigationItem.setTitle(navigationItemResource.getValueMap().get("title",String.class));
                    navigationItem.setPath(navigationItemResource.getValueMap().get("path",String.class));
                    navigationItems.add(navigationItem);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
        }
        return navigationItems;
    }

}
