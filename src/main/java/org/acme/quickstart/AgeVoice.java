package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgeVoice {

    public String getUserAge(String age) {
    	//int IntAge = Integer.parseInt(age);
        return " You are " + age + ".";
    }
    public Integer getIntAge(String age) {
    	int IntAge = 0 + Integer.parseInt(age);
    	//int IntAge = Integer.parseInt(age);
    	return IntAge;
    }

}