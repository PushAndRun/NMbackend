package com.nextMagnus.backend.Controller;


import com.nextMagnus.backend.FenDTO;
import com.nextMagnus.backend.Model.Board;
import com.nextMagnus.backend.Model.MonteCarloTreeSearch;
import com.nextMagnus.backend.Model.MoveGenerator;
import com.nextMagnus.backend.Model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @Autowired
    private MoveService moveService;

    @GetMapping("/move")
    public ResponseEntity<FenDTO> handleGetRequest(@RequestBody FenDTO fenObject) {
        return ResponseEntity.ok(moveService.get(fenObject));
    }

}
