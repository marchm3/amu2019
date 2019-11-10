package com.example.demo.controller;

import com.example.demo.WordWrapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("echo")
public class Echo {

    @GetMapping("{word}")
    public String getEcho(@PathVariable("word") String word) {
        return word;
    }

    @GetMapping()
    public String getEcho2(@RequestParam("word") String word) {
        return word;
    }

    @PostMapping()
    public String postEcho(@RequestBody String word) {
        return word;
    }

    @PostMapping("json")
    public String postEcho(@RequestBody WordWrapper word) {
        return word.getWord();
    }

    @GetMapping("json/{word}")
    public WordWrapper getEcho3(@PathVariable("word") String word) {
        WordWrapper wordWrapper = new WordWrapper();
        wordWrapper.setWord(word);
        return wordWrapper;
    }
}
