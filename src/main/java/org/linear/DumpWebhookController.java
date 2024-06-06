package org.linear;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DumpWebhookController {
    private final DumpWebhookService service;
    private final Logger logger;

    private final ObjectMapper mapper;


    @Autowired
    public DumpWebhookController(DumpWebhookService service, ObjectMapper mapper) {
        this.service = service;
        this.logger = LoggerFactory.getLogger(DumpWebhookController.class);
        this.mapper = mapper;
    }

    @PostMapping
    public void dumpString(@RequestHeader("Content-Type") String contentType, @RequestBody String input) {
        try {
            String type = contentType.contains("json")
                    ? "json"
                    : "txt";

            Object data = "json".equals(type)
                    ? mapper.readTree(input)
                    : input;

            service.dump(data, type);
        } catch (Exception e) {
            logger.error("error catched for input {}", input, e);
        }
    }
}
