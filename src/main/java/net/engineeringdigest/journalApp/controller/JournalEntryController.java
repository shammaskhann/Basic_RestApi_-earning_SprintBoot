package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
     private Map<Long, JournalEntry> journalEntries = new HashMap<>();

     @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){
         journalEntries.put(entry.getId(), entry);
         return true;
    }

    @GetMapping("{myId}")
    public JournalEntry getEntry(@PathVariable long myId){
         return journalEntries.get(myId);
    }

    @DeleteMapping("{myId}")
    public JournalEntry deleteEntry(@PathVariable long myId){
         return journalEntries.remove(myId);
    }

    @PutMapping("{myID}")
    public JournalEntry updateEntry(@PathVariable long myId, @RequestBody JournalEntry entry){
         return journalEntries.put(myId, entry);

    }
}
