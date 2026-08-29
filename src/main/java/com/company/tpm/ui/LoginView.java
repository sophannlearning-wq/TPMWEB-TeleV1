package com.company.tpm.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("login")
@PageTitle("Login | TPM")
@AnonymousAllowed
public class LoginView extends VerticalLayout {
    public LoginView() {
        addClassName("login-page");
        setSizeFull();
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        var card = new Div();
        card.addClassName("glass-card");

        var form = new LoginForm();
        form.setAction("login");

        card.add(new H1("TPM Training System"), new Paragraph("Secure training management platform"), form);
        add(card);
    }
}

