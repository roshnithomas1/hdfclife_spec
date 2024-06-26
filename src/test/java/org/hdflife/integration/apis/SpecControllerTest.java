package org.hdflife.integration.apis;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@RunWith(SpringRunner.class)
@WebMvcTest(SpecController.class)
class SpecControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void reciveOpenAPIspecReturnYaml() throws Exception {
        String exampleRequest = readFileAsString("request.json");
        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/generate/spec")
                .contentType(MediaType.APPLICATION_JSON)
                .content(exampleRequest));
    }

    public static String readFileAsString(String file)throws Exception
    {
        Path pathToFile = Paths.get(file);
        System.out.println(pathToFile.toAbsolutePath());
        return new String(Files.readAllBytes(pathToFile));
    }
}