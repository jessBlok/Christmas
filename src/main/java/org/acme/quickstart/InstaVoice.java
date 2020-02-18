package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InstaVoice {

    public String getUserInsta(String insta) {
        return " You're using your Instagram " + insta +".";
    }

}