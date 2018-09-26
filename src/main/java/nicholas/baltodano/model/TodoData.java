package nicholas.baltodano.model;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    // Fields
    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    // Constructors
    public TodoData() {
        // adding dummy data, using the addItem method. addItem sets the ID
        addItem(new TodoItem("1st","thing to do1", LocalDate.now()));

        addItem(new TodoItem("2nd","thing to do2", LocalDate.now()));

        addItem(new TodoItem("3rd","thing to do3", LocalDate.now()));

        addItem(new TodoItem("4th","thing to do4", LocalDate.now()));
    }


    // Public Methods
    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }


    public void addItem (@NonNull TodoItem toAdd){
        toAdd.setId(idValue);
        idValue++;
        items.add(toAdd);
    }

    public void removeItem (int id){
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while(itemIterator.hasNext()){
            TodoItem item = itemIterator.next();

            if (item.getId() == id){
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem (int id){

        for(TodoItem item : items)
        {
            if(item.getId() == id)
                return item;
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate){
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while(itemIterator.hasNext()){
            TodoItem item = itemIterator.next();

            // Equality set on ID
            if (item.equals(toUpdate)){
                itemIterator.set(toUpdate);
                break;
            }
        }
    }
}
