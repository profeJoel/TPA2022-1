package com.vaadinwork.tpademo;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainWindow extends VerticalLayout{
    public MainWindow(){
        H1 textoBienvenida = new H1("Hola Clase...");
        H2 subTexto = new H2("Subtítulo");
        Paragraph texto = new Paragraph("Esto es para entender cómo funciona Vaadin...");
        add(textoBienvenida, subTexto, texto);
    }    
}
