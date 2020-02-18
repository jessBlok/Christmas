package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloVoice {

    public String getUserName(String name) {
        return " Hello " + name +".";
    }

}