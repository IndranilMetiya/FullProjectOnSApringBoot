package com.full.project.entity.mysql;


import com.full.project.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_profiles")
public class UserProfile extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Column(name = "bio", length = 1000)
    private String bio;

    @Column(name = "company")
    private String company;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "website")
    private String website;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "preferred_language")
    private Language preferredLanguage = Language.ENGLISH;

    @Enumerated(EnumType.STRING)
    @Column(name = "timezone")
    private TimeZone timezone = TimeZone.UTC;


}

enum Language {
    ENGLISH, SPANISH, FRENCH, GERMAN, CHINESE, JAPANESE
}

enum TimeZone {
    UTC, EST, PST, CET, JST, IST
}

