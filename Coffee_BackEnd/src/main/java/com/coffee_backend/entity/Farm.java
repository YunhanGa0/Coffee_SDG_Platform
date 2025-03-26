package com.coffee_backend.entity;

import com.coffee_backend.enumType.SoilType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "farms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "farm_name", nullable = false)
    private String farmName;

    @Column(name = "country", nullable = false)
    private String country; // 国家

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Double size; // 农场大小，单位可以是公顷

    @Column(name = "established_year")
    private Integer establishedYear;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private Integer elevation; // 海拔高度，单位为米

    @Enumerated(EnumType.STRING)
    @Column(name = "soil_type")
    private SoilType soilType; // 使用枚举表示土壤类型

    @Column(name = "is_certificated")
    private Boolean isCertificated;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name="blog_title")
    private String blogTitle; // 博客标题

    @Column(name="blog_content", columnDefinition = "TEXT")
    private String blogContent; // 博客内容

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
