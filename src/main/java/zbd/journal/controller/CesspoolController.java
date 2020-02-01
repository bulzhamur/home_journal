package zbd.journal.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zbd.journal.domain.Cesspool;
import zbd.journal.repo.CesspoolRepo;

import java.util.List;

@RestController
@RequestMapping("cesspool")
public class CesspoolController {
    private final CesspoolRepo cesspoolRepo;

    @Autowired
    public CesspoolController(CesspoolRepo cesspoolRepo){
        this.cesspoolRepo = cesspoolRepo;
    }

    @GetMapping
    public List<Cesspool> list(){
        return cesspoolRepo.findAll();
    }

    @GetMapping("{id}")
    public Cesspool getOne(@PathVariable("id") Cesspool cesspool){
        return cesspool;
    }

    @PostMapping
    public Cesspool create(@RequestBody Cesspool cesspool){
        return cesspoolRepo.save(cesspool);
    }

    @PutMapping("{id}")
    public Cesspool update(@PathVariable("id") Cesspool cesspoolFromDb,
                          @RequestBody Cesspool cesspool){
        BeanUtils.copyProperties(cesspool, cesspoolFromDb, "id");
        return cesspoolRepo.save(cesspoolFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Cesspool cesspool){
        cesspoolRepo.delete(cesspool);
    }

}
