package com.statistigz.main.entity.id;

import com.statistigz.main.entity.Criteria;
import com.statistigz.main.entity.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Embeddable
public class RegionCriteriaId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "regionid")
    private Region region;
    @ManyToOne
    @JoinColumn(name = "criteriaid")
    private Criteria criteria;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate updatedDate;
}
