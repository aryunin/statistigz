package com.statistigz.main.entity.id;

import com.statistigz.main.entity.Criteria;
import com.statistigz.main.entity.Region;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
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
    @Column(name = "updatedate")
    private LocalDate updateDate;
}
