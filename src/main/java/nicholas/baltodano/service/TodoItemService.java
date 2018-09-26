package nicholas.baltodano.service;

import nicholas.baltodano.model.TodoData;
import nicholas.baltodano.model.TodoItem;

public interface TodoItemService {

    // Methods
    void addItem(TodoItem toAdd);

    void removeItem(int toRemove);

    void updateItem(TodoItem toUpdate);

    TodoData getData();

    TodoItem getItem(int toGet);


}