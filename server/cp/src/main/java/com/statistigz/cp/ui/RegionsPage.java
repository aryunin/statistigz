package com.statistigz.cp.ui;

import com.statistigz.cp.entity.Region;
import com.statistigz.cp.repository.RegionRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import jakarta.annotation.PostConstruct;

import java.util.List;

@Route("regions")
@RouteAlias("")
public class RegionsPage extends AppLayout {
    private final RegionRepository regionRepository;
    private final Grid<Region> grid;

    public RegionsPage(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;

        VerticalLayout commonLayout = new VerticalLayout();
        grid = new Grid<>();
        grid.setSizeFull();
        commonLayout.add(grid);

        setContent(grid);
    }

    @PostConstruct
    public void fillGrid() {
        List<Region> contacts = regionRepository.findAllByOrderByNameAsc();

        grid.addColumn(Region::getName).setHeader("Название региона");
        grid.addColumn(
                new NativeButtonRenderer<>(
                        "Редактировать", region -> UI.getCurrent().navigate(RegionEditPage.class, region.getId())
                )
        );

        grid.setItems(contacts);
    }
}
