package com.zhangbo.lovepets.controller;

import com.zhangbo.lovepets.pojo.Pet;
import com.zhangbo.lovepets.service.PetService;
import com.zhangbo.lovepets.until.Result;
import com.zhangbo.lovepets.until.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("pets")
public class PetController {
    @Autowired
    private PetService service;
    @PostMapping
    public Result save_pet(@RequestBody Pet pet){
        service.save(pet);
        return Result.resultFactory(Status.INSERT_INFO_SUCCESS);
    }

}
