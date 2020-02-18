package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Tag1Voice {

    public String getUserTag1(String tag1) {
        return " Your first tag is " + tag1 +".";
    }

}