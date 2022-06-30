package com.vaadinwork.tpademo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainWindow extends VerticalLayout{
    public MainWindow(){
        H1 textoBienvenida = new H1("Hola Clase...");
        H2 subTexto = new H2("Subtítulo");
        Paragraph texto = new Paragraph("Esto es para entender cómo funciona Vaadin...");
        NativeButton goToSecond = new NativeButton("Ir a página Second");

        goToSecond.addClickListener( click -> {
            goToSecond.getUI().ifPresent( ui -> ui.navigate("second"));
        });

        add(textoBienvenida, subTexto, texto, goToSecond);
    }    
}
