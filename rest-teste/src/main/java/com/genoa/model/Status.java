package com.genoa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import java.util.List;

@AutoProperty
public class Status {
    private final int status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long lote;

    private final String message;

    public Status(int status, String message, Long lote) {
        this.status = status;
        this.message = message;
        this.lote = lote;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Long getLote() {
        return lote;
    }

    @Override
    public String toString() {
        return Pojomatic.toString(this);
    }
}
