package org.hdflife.integration.apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecController {

    @PostMapping("/generate/spec")
     String createSpec(@RequestBody OpenAPI swagger) throws JsonProcessingException {
        final String swaggerJson = Yaml.mapper().writeValueAsString(swagger);
       return swaggerJson;
    }
}
