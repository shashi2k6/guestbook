package com.galvanize.guestbook.controller;

import com.galvanize.guestbook.bean.GuestEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GuestController {

    private List guestList =  new ArrayList();

    @GetMapping("/entries")
    public List getAllGuestEntries(){
        guestList.add(new GuestEntry(1,"Abaram Lincoln","Awesome site"));
        return guestList;
    }
}
