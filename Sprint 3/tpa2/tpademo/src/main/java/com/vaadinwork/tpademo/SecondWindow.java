package com.vaadinwork.tpademo;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/second")
public class SecondWindow extends VerticalLayout{

    public SecondWindow(){
        VerticalLayout todosList = new VerticalLayout();
        TextField taskField = new TextField();
        Button addButton = new Button("Add");
        addButton.addClickListener(click -> {
            Checkbox checkbox = new Checkbox(taskField.getValue());
            taskField.clear();
            todosList.add(checkbox);
        });
        addButton.addClickShortcut(Key.ENTER);

        add(
            new H1("Vaadin Todo"),
            todosList,
            new HorizontalLayout(
                taskField,
                addButton
            )
        );

    }
    
}
