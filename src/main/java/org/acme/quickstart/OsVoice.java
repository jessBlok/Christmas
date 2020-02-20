package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OsVoice {

    public String getUserOs(String os) {
//    	int IntAge = Integer.parseInt(age);
        return " Your os is " + os + ".";
    }

}