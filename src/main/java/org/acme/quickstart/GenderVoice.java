package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenderVoice {

    public String getUserGender(String gender) {
//    	int IntAge = Integer.parseInt(age);
        return " You're gender is " + gender + ".";
    }

}