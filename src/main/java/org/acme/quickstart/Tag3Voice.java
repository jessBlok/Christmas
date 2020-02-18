package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Tag3Voice {

    public String getUserTag3(String tag3) {
        return " Your third tag is " + tag3 +".";
    }

}