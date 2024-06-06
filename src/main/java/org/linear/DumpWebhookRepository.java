package org.linear;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Repository
public class DumpWebhookRepository {
    private final ObjectMapper mapper;

    @Autowired
    public DumpWebhookRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @SneakyThrows
    public void dump(Object data, String type) {
        String filename = createFileName(type);
        mapper.writeValue(new File(filename), data);
    }

    private String createFileName(String type) {
        long now = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        return String.format("src/main/resources/dump_%s.%s", now, type);
    }
}
