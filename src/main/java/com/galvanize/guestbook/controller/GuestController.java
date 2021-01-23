package com.galvanize.guestbook.controller;

import com.galvanize.guestbook.bean.GuestEntry;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class GuestController {

    private List<GuestEntry> guestList = new ArrayList();

    @GetMapping("/entries")
    public List getAllGuestEntries() {
        return guestList;
    }

    @PostMapping("/entries")
    @ResponseStatus(HttpStatus.CREATED)
    public GuestEntry createEntry(@RequestBody GuestEntry guestEntry) {
        guestList.add(guestEntry);
        return guestEntry;
    }
}
