package com.example.application.main;


import com.example.application.supplier_category_service.CategoryDTO;
import com.example.application.supplier_category_service.CategoryProxy;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "CategoryView", layout = MainLayout.class)
@PageTitle("Category | Vaadin ")
public class CategoryView extends VerticalLayout {

    Grid<CategoryDTO> grid;

    CategoryProxy categoryProxy;
    TextField textFieldTitle;

    public CategoryView(CategoryProxy categoryProxy) {
        this.categoryProxy = categoryProxy;

        textFieldTitle = new TextField();
        textFieldTitle.setClearButtonVisible(true);
        textFieldTitle.setValue("Title");
        textFieldTitle.setLabel("label");

        Button createButton = new Button("Save");
        createButton.addThemeVariants(ButtonVariant.LUMO_LARGE);

        createButton.addClickListener(buttonClickEvent -> {
            String title=textFieldTitle.getValue();
            String logo=textFieldTitle.getLabel();

            CategoryDTO categoryDTO =new CategoryDTO();
            categoryDTO.setTitle(title);
            categoryDTO.setLogo(logo);
            categoryProxy.save(categoryDTO);
            System.out.println("success done");
            Notification notification = Notification.show("Successfully submitted!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            fillGrid();

        });



        HorizontalLayout creatLayout = new HorizontalLayout(textFieldTitle,createButton);

        add(creatLayout);




        /////////////////make grid


        grid = new Grid<>(CategoryDTO.class, false);
        grid.addColumn(CategoryDTO::getId).setHeader("Id");
        grid.addColumn(CategoryDTO::getTitle).setHeader("Title");




        grid.addSelectionListener(selectionEvent -> {
            selectionEvent.getFirstSelectedItem().ifPresent(carCategory -> {
                Notification.show(carCategory.getId() + " is selected");
            });
        });

        fillGrid();


        add(grid);
    }

    public  void fillGrid(){

        List<CategoryDTO> categoryDTOList= categoryProxy.getAll();

        grid.setItems(categoryDTOList);
    }

}
