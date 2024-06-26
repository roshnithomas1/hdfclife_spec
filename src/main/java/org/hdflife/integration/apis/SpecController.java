package org.hdflife.integration.apis;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecController {

    @PostMapping("/generate/spec")
     String createSpec(@RequestBody OpenAPI swagger) {
        System.out.println(swagger.getOpenapi().toString());
       return swagger.getOpenapi().toString();
    }
}
