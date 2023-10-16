package com.statistigz.main.entity.id;

import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class AchievementId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "regionid")
    private Region region;
    @ManyToOne
    @JoinColumn(name = "projectionid")
    private Projection projection;
}
