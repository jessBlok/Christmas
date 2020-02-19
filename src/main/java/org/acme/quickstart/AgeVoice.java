package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgeVoice {

    public String getUserAge(String age) {
//    	int IntAge = Integer.parseInt(age);
        return " Your age is " + age + ".";
    }

}