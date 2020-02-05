package zbd.journal.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zbd.journal.domain.WaterFilter;
import zbd.journal.repo.WaterFilterRepo;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("waterfilter")
public class WaterFilterController {
    private final WaterFilterRepo waterFilterRepo;

    @Autowired
    public WaterFilterController(WaterFilterRepo waterFilterRepo){
        this.waterFilterRepo = waterFilterRepo;
    }

    @GetMapping
    public List<WaterFilter> list(){
        return waterFilterRepo.findAll();
    }

    @GetMapping("{id}")
    public WaterFilter getOne(@PathVariable("id") Integer idWaterfilter){
        return this.waterFilterRepo.getOne(idWaterfilter);
    }

    @PostMapping
    public WaterFilter create(@RequestBody WaterFilter waterfilter){
        waterfilter.setCreatedAt(LocalDateTime.now());
        return waterFilterRepo.save(waterfilter);
    }

    @PutMapping("{id}")
    public WaterFilter update(@PathVariable("id") WaterFilter waterfilterFromDb,
                          @RequestBody WaterFilter waterfilter){
        BeanUtils.copyProperties(waterfilter, waterfilterFromDb, "id");
        return waterFilterRepo.save(waterfilterFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") WaterFilter waterfilter){
        waterFilterRepo.delete(waterfilter);
    }

}
