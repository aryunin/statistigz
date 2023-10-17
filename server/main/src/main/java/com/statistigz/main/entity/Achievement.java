package com.statistigz.main.entity;

import com.statistigz.main.entity.id.AchievementID;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@Immutable
public class Achievement {
    @EmbeddedId
    private AchievementID id;
    private Double score;
}
