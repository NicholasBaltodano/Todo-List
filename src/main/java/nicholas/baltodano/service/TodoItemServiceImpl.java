package nicholas.baltodano.service;

import lombok.Getter;
import nicholas.baltodano.model.TodoData;
import nicholas.baltodano.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    // Fields
    @Getter
     private final TodoData data = new TodoData();

    // Public Methods
    @Override
    public void addItem(TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int toRemove) {
        data.removeItem(toRemove);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }

    @Override
    public TodoItem getItem(int toGet) {
        return data.getItem(toGet);
    }
}
