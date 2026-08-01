package dev.waddadelmehdi.billingservice.dao.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public record HalPage<T>(@JsonProperty("_embedded") Map<String, List<T>> embedded) {
    public List<T> content() {
        if (embedded == null || embedded.isEmpty()) return List.of();
        return embedded.values().iterator().next();
    }
}