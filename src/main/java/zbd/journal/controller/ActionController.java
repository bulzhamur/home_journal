package zbd.journal.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zbd.journal.domain.Action;
import zbd.journal.repo.ActionRepo;

import java.util.List;

@RestController
@RequestMapping("action")
public class ActionController {
    private final ActionRepo actionRepo;

    @Autowired
    public ActionController(ActionRepo actionRepo){
        this.actionRepo = actionRepo;
    }

    @GetMapping
    public List<Action> list(){
        return actionRepo.findAll();
    }

    @GetMapping("{id}")
    public Action getOne(@PathVariable("id") Action action){
        return action;
    }

    @PostMapping
    public Action create(@RequestBody Action action){
        return actionRepo.save(action);
    }

    @PutMapping("{id}")
    public Action update(@PathVariable("id") Action actionFromDb,
                          @RequestBody Action action){
        BeanUtils.copyProperties(action, actionFromDb, "id");
        return actionRepo.save(actionFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Action action){
        actionRepo.delete(action);
    }

}
