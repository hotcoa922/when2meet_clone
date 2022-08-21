package com.cotato.when2meet.promise.controller;

import com.cotato.when2meet.promise.model.Promisename;
import com.cotato.when2meet.promise.repository.PromisenameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/api", method = {RequestMethod.GET, RequestMethod.POST})    //405 오류 해결위해 코드 이렇게 변경
public class PromisenameController {

    @Autowired
    private PromisenameRepository promisenameRepository;

    @PostMapping("/promisename")
    public Promisename create(@RequestBody Promisename promisename) {
        return promisenameRepository.save(promisename);
    }

    @GetMapping("/promisename/{N_EN}")
    public String read(@PathVariable String N_EN) {

        Optional<Promisename> userOptional = promisenameRepository.findById(N_EN);
        userOptional.ifPresent(System.out::println);

        return "successfully executed";
    }

    /*
    @GetMapping("/get")
    public String getTest() {
        return "success";       //localhost:8080/get 가서 테스트
    }

     */
}
