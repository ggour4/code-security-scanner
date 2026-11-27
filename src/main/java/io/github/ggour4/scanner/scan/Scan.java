package io.github.ggour4.scanner.scan;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scans")
public class Scan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;

    private String code;

    @Enumerated(EnumType.STRING)
    private ScanStatus status;

    @Column(name = "created_at")
    private Instant createdAt;

    protected Scan() {
    }

    public Scan(String language, String code, ScanStatus status) {
        this.language = language;
        this.code = code;
        this.status = status;
        this.createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public String getCode() {
        return code;
    }

    public ScanStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
} 