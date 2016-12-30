package com.hibernation.controller;

import com.hibernation.model.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by jonathan on 26/12/16.
 */

@Controller
public class GOD {


    // tickling GOD creates new animals in the animal kingdom and sends
    // them into hibernation.
    @RequestMapping(value="/animals/", method= RequestMethod.GET)
    public void tickleGod(){


//        Bear    bear    = new Bear();
//        Snake   snake   = new Snake();
//        Frog    frog    = new Frog();
//        Bee     bee     = new Bee();


        //sendToHibernation();

        /*
        *  how to move away from the controller to a main class .. ?
        *
        * */

    }

}
