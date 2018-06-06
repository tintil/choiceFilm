package com.diplom.ogromazina.choicefilm.conroller;

import com.diplom.ogromazina.choicefilm.data.Profile;

/**
 * Created by OGromazina on 6/6/2018.
 */

public class Controller {
    private boolean flagLogIn = false;
    private static Controller sInstance = null;
    private Profile mProfile;

    private Controller(){
        mProfile = null;
    }



    public void logInTrue(){
        flagLogIn = true;
    }

    public boolean isLogIn (){
        return flagLogIn;
    }

    public void exit(){
        flagLogIn = false;
    }

    public static Controller Inst (){
        if (sInstance == null){
            sInstance = new Controller();
        }
        return sInstance;
    }

}
