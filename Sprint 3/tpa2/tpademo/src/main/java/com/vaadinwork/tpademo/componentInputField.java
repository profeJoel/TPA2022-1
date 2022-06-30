package com.vaadinwork.tpademo;

import javax.validation.constraints.Email;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("componentInputField")
public class componentInputField extends VerticalLayout{

    private Icon checkIcon;
    private Span passwordStrengthText;

    public componentInputField(){

        //ejemplo 1
        EmailField emailField = new EmailField();
        emailField.setLabel("Email address");
        add(new Div(emailField)); // se agrega un elemento Div para contener el componente EmailField // Luego, este div se añade al layout

        //ejemplo 2
        TextField textField = new TextField();
        textField.getElement().setAttribute("aria-label", "search");
        textField.setPlaceholder("search");
        textField.setClearButtonVisible(true);
        textField.setPrefixComponent(VaadinIcon.SEARCH.create()); //ver más íconos en: https://vaadin.com/docs/latest/components/icons
        add(new Div(textField)); //Pasa algo similar acá, para no causar soliciones entre componentes.

        //ejemplo 3
        TextField textField1 = new TextField();
        textField1.setLabel("Phone number");
        textField1.setHelperText("Include country and area prefixes");

        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");
        passwordField.setRevealButtonVisible(false);

        checkIcon = VaadinIcon.CHECK.create();
        checkIcon.setVisible(false);
        passwordField.setSuffixComponent(checkIcon);

        Div passwordStrength = new Div();
        passwordStrengthText = new Span();
        passwordStrength.add(new Text("Password strength: "), passwordStrengthText);
        passwordField.setHelperComponent(passwordStrength);

        add(new HorizontalLayout(textField1, passwordField));

        passwordField.setValueChangeMode(ValueChangeMode.EAGER);
        passwordField.addValueChangeListener(e -> {
            String password = e.getValue();
            updateHelper(password);
        });

        updateHelper("");

        //ejemplo 4
        TextField textField2 = new TextField();
        textField2.setLabel("Phone number");
        textField2.setHelperText("Include country and area prefixes");
        textField2.addThemeVariants(TextFieldVariant.LUMO_HELPER_ABOVE_FIELD);
        textField2.setWidth("15em");
        add(textField2);


        //ejemplo 5
        TextField textField3 = new TextField();;
        textField3.setLabel("Name");
        textField3.setRequiredIndicatorVisible(true);
        textField3.setErrorMessage("This field is required");
    
        DatePicker datePicker = new DatePicker();
        datePicker.setLabel("Date of birth");
    
        add(new HorizontalLayout(textField3, datePicker));


        //ejemplo 6 

        
        
    }

    private void updateHelper(String password) {
        if (password.length() > 9) {
          passwordStrengthText.setText("strong");
          passwordStrengthText.getStyle().set("color", "var(--lumo-success-color)");
          checkIcon.setVisible(true);
        } else if (password.length() > 5) {
          passwordStrengthText.setText("moderate");
          passwordStrengthText.getStyle().set("color", "#e7c200");
          checkIcon.setVisible(false);
        } else {
          passwordStrengthText.setText("weak");
          passwordStrengthText.getStyle().set("color", "var(--lumo-error-color)");
          checkIcon.setVisible(false);
        }
      }
}
