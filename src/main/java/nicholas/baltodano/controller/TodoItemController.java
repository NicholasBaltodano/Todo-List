package nicholas.baltodano.controller;


import lombok.extern.slf4j.Slf4j;
import nicholas.baltodano.model.TodoData;
import nicholas.baltodano.model.TodoItem;
import nicholas.baltodano.service.TodoItemService;
import nicholas.baltodano.util.AttributeNames;
import nicholas.baltodano.util.Mappings;
import nicholas.baltodano.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@Slf4j
public class TodoItemController {

    //Fields
    private final TodoItemService todoItemService;

    // Constructors
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // Model Attributes
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }


    // Handler Methods
    // localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                              Model model){
        log.info("Editing id = {}", id);

        // Grab item to be edited
        TodoItem todoItem = todoItemService.getItem(id);

        // If it does does not exist, create a new one
        if(todoItem == null)
            todoItem = new TodoItem("","",LocalDate.now());


        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);

        return ViewNames.ADD_ITEM;

    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("Adding todo Item : {}", todoItem);

        if(todoItem.getId() == 0){
            todoItemService.addItem(todoItem);
        }
        else
            todoItemService.updateItem(todoItem);

        return  "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        log.info("Deleting Item: {}", id);
        todoItemService.removeItem(id);

        return "redirect:/" + Mappings.ITEMS;

    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        log.info("Viewing Item: {}", id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItemService.getItem(id));
        return ViewNames.VIEW_ITEM;
    }
}
