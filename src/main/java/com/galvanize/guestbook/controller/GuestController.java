package com.galvanize.guestbook.controller;

import com.galvanize.guestbook.bean.GuestEntry;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.jws.HandlerChain;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GuestController {

    private List<GuestEntry> guestList =  new ArrayList();

    @GetMapping("/entries")
    public List getAllGuestEntries(){
        guestList.add(new GuestEntry(1,"Abaram Lincoln","Awesome site"));
        return guestList;
    }


    @PostMapping("/entries")
    @ResponseStatus(HttpStatus.CREATED)
    public GuestEntry createEntry(@RequestBody GuestEntry guestEntry){
        guestList.add(guestEntry);
        return guestList.get(guestList.size()-1);
    }
}
