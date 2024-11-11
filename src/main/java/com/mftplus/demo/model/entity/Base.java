package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@MappedSuperclass

public class Base {
    @Version
    @JsonbTransient
    private Long versionId;
    @JsonbTransient
    private boolean editing = false;
    @JsonbTransient
    private boolean deleted = false;
    @JsonbTransient
    private boolean locked;
}
