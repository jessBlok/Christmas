package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Tag2Voice {

    public String getUserTag2(String tag2) {
        return " Your second tag is " + tag2 +".";
    }

}