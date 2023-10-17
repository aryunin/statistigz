package com.statistigz.main.entity.id;

import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievementID implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projection_id")
    private Projection projection;
}
