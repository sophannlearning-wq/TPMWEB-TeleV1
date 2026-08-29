package com.company.tpm.common;
import jakarta.persistence.*; import java.time.Instant; import java.util.UUID;
@MappedSuperclass public abstract class BaseEntity {
 @Id @GeneratedValue(strategy=GenerationType.UUID) private UUID id; @Version private long version;
 @Column(nullable=false,updatable=false) private Instant createdAt; @Column(nullable=false) private Instant updatedAt;
 @PrePersist void create(){createdAt=updatedAt=Instant.now();} @PreUpdate void update(){updatedAt=Instant.now();}
 public UUID getId(){return id;} public long getVersion(){return version;} public Instant getCreatedAt(){return createdAt;} public Instant getUpdatedAt(){return updatedAt;}
}
