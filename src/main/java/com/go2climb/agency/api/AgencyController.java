package com.go2climb.agency.api;

import com.go2climb.agency.domain.entity.Agency;
import com.go2climb.agency.domain.service.AgencyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/agencies")
@AllArgsConstructor
public class AgencyController {
    @Autowired
    private AgencyService agencyService;

    @PostMapping
    public Agency save(@RequestBody Agency agency){
        return agencyService.save(agency);
    }

    @GetMapping
    public List<Agency> getAll() {return agencyService.getAll();}

    @GetMapping("{id}")
    public Agency getById(@PathVariable Integer id) {
        return agencyService.getById(id).get();
    }

    @PutMapping("{id}")
    public ResponseEntity<Agency> update (@PathVariable Integer id, @RequestBody Agency agency){
        if (id.equals(agency.getId())){
            agencyService.update(agency);
            return new ResponseEntity<>(agency, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Agency> delete(@PathVariable Integer id){
        if (agencyService.deleteById(id)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
