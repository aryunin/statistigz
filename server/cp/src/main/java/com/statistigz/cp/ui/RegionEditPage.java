package com.statistigz.cp.ui;

import com.statistigz.cp.entity.Region;
import com.statistigz.cp.entity.RegionPhoto;
import com.statistigz.cp.repository.RegionPhotoRepository;
import com.statistigz.cp.repository.RegionRepository;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.Command;
import com.vaadin.flow.server.StreamResource;
import org.vaadin.firitin.components.upload.UploadFileHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Route("region")
public class RegionEditPage extends VerticalLayout implements HasUrlParameter<Long> {
    // Datasource
    private final RegionRepository regionRepository;
    private final RegionPhotoRepository regionPhotoRepository;

    // Model
    private final Binder<Region> binder = new Binder<>(Region.class);
    private Region region;

    // Form
    private final TextField nameField       = new TextField("Название");
    private final TextArea descriptionField = new TextArea("Описание");
    private final Button saveFormButton     = new Button("Сохранить форму");
    private final Button cancelFormButton   = new Button("Отменить");

    // Photo
    private final Button addPhotoButton    = new Button("Добавить фото");
    private final Button deletePhotoButton = new Button("Удалить все фото");

    private final ComponentEventListener<ClickEvent<Image>> photoClickListener = event -> {
        Image source = event.getSource();
        Image target = new Image(source.getSrc(), source.getAlt().orElse(""));
        target.setMaxWidth(100, Unit.PERCENTAGE);
        target.setMaxHeight(100, Unit.PERCENTAGE);
        Dialog dialog = new Dialog();
        dialog.setMaxHeight(95, Unit.PERCENTAGE);
        dialog.setMaxWidth(75, Unit.PERCENTAGE);
        dialog.add(target);
        dialog.open();
    };

    public RegionEditPage(RegionRepository regionRepository, RegionPhotoRepository regionPhotoRepository) {
        this.regionRepository = regionRepository;
        this.regionPhotoRepository = regionPhotoRepository;

        binder.bind(nameField, Region::getName, Region::setName);
        binder.bind(descriptionField, Region::getDescription, Region::setDescription);
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, Long regionId) {
        region = regionRepository.findByIdFetchPhotos(regionId).orElseThrow();

        VerticalLayout formLayout = new VerticalLayout();
        nameField.setWidthFull();
        descriptionField.setWidthFull();
        formLayout.add(nameField, descriptionField);

        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.setWidthFull();
        saveFormButton.addClickListener(this::onSaveClicked);
        cancelFormButton.addClickListener(this::onCancelClicked);
        buttonsLayout.add(saveFormButton, cancelFormButton);

        HorizontalLayout photoLayout = new HorizontalLayout();
        photoLayout.setWidthFull();
        photoLayout.setPadding(true);
        region.getPhotos().stream()
                .map(RegionPhoto::getData)
                .map(data -> new StreamResource(region.getName(), () -> new ByteArrayInputStream(data)))
                .map(resource -> new Image(resource, region.getName()))
                .peek(image -> image.addClickListener(photoClickListener))
                .peek(image -> {
                    image.setWidth(256, Unit.PIXELS);
                    image.setHeight(256, Unit.PIXELS);
                })
                .forEach(photoLayout::add);
        Scroller photoScroller = new Scroller();
        photoScroller.setWidthFull();
        photoScroller.setContent(photoLayout);

        HorizontalLayout photoButtonsLayout = new HorizontalLayout();
        photoButtonsLayout.setWidthFull();
        UploadFileHandler uploadFileHandler = new UploadFileHandler(this::onAddPhotoClicked);
        uploadFileHandler.setUploadButton(addPhotoButton);
        uploadFileHandler.withDragAndDrop(false);
        uploadFileHandler.allowMultiple();
        deletePhotoButton.addClickListener(this::onDeletePhotoClicked);
        photoButtonsLayout.add(uploadFileHandler, deletePhotoButton);

        VerticalLayout commonLayout = new VerticalLayout();
        commonLayout.setWidth(75, Unit.PERCENTAGE);
        commonLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        commonLayout.add(formLayout, buttonsLayout, photoScroller, photoButtonsLayout);

        setAlignItems(FlexComponent.Alignment.CENTER);
        setSizeFull();
        add(commonLayout);

        binder.readBean(region);
    }

    private Command onAddPhotoClicked(InputStream inputStream, UploadFileHandler.FileDetails fileDetails) {
        return () -> {
            try {
                BufferedImage image = ImageIO.read(inputStream);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", bos);
                byte[] imageBytes = bos.toByteArray();
                RegionPhoto photo = new RegionPhoto();
                photo.setRegion(region);
                photo.setData(imageBytes);
                regionPhotoRepository.save(photo);
                getUI().orElseThrow().access(()-> UI.getCurrent().getPage().reload());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    private void onSaveClicked(ClickEvent<Button> event) {
        Region beforeState = region;
        try {
            binder.writeBean(region);
            regionRepository.save(region);
            Notification.show("Форма успешно сохранена", 5000, Notification.Position.BOTTOM_START)
                    .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } catch (ValidationException ex) {
            Notification.show("Ошибка сохранения формы", 5000, Notification.Position.BOTTOM_START)
                    .addThemeVariants(NotificationVariant.LUMO_ERROR);
            binder.readBean(beforeState);
        }
    }

    private void onCancelClicked(ClickEvent<Button> event) {
        binder.readBean(region);
    }


    private void onDeletePhotoClicked(ClickEvent<Button> event) {
        regionPhotoRepository.deleteAll(region.getPhotos());
        UI.getCurrent().getPage().reload();
    }
}
