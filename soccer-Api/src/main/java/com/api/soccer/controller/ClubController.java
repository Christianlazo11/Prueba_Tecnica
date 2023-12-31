package com.api.soccer.controller;


import com.api.soccer.dto.ClubDTO;
import com.api.soccer.service.ClubService;
import com.api.soccer.utils.AppGlobalConts;
import com.api.soccer.utils.ClubResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping
    public ResponseEntity<ClubResponse> findAll(
            @RequestParam(value = "pageNo", defaultValue = AppGlobalConts.DEFAULT_PAGE_NUM, required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = AppGlobalConts.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortAsc", defaultValue = AppGlobalConts.DEFAULT_ORDER_ASC, required = false) String sortAsc) {

        return new ResponseEntity<>(clubService.findAll(pageNum,pageSize,sortAsc), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDTO> findById(@PathVariable(name = "id") Integer id) {
        ClubDTO clubFind = clubService.findById(id);
        return new ResponseEntity<>(clubFind, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClubDTO> save(@Valid @RequestBody ClubDTO clubDTO) {
        ClubDTO clubSave = clubService.save(clubDTO);
        return new ResponseEntity<>(clubSave, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClubDTO> update(@PathVariable(name = "id") Integer id,@Valid @RequestBody ClubDTO clubDTO) {
        ClubDTO clubUpdate = clubService.update(clubDTO, id);
        return new ResponseEntity<>(clubUpdate, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
        clubService.delete(id);
        return new ResponseEntity<>("Club Eliminado con éxito!", HttpStatus.OK);
    }
}
