package nicholas.baltodano.controller;

import nicholas.baltodano.model.TodoData;
import nicholas.baltodano.util.Mappings;
import nicholas.baltodano.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    // Model Attributes
    @ModelAttribute
    public TodoData todoData(){
        return new TodoData();
    }


    // Handler Methods
    // localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }
}
