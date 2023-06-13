package com.nextMagnus.backend.Controller;


import com.nextMagnus.backend.FenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ApiController {

    @Autowired
    private MoveService moveService;

    @PostMapping("/move")
    public ResponseEntity<FenDTO> handleGetRequest(@RequestBody FenDTO fenObject) {
        return ResponseEntity.ok(moveService.get(fenObject));
    }

}
