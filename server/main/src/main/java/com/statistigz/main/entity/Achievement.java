package com.statistigz.main.entity;

import com.statistigz.main.entity.id.AchievementId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@Immutable
public class Achievement {
    @EmbeddedId
    private AchievementId id;
    private Double score;
}
