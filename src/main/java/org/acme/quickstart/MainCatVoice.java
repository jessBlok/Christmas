package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MainCatVoice {

    public String getUserMainCat(String maincat) {
        return " Your main category on Amazon is " + maincat +".";
    }

}