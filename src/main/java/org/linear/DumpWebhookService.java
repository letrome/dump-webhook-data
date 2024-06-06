package org.linear;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DumpWebhookService {
    DumpWebhookRepository repository;

    @Autowired
    public DumpWebhookService(DumpWebhookRepository repository) {
        this.repository = repository;
    }

    public void dump(Object data, String type) {
        repository.dump(data, type);
    }
}
