package com.calculator.controller;

import com.calculator.calculator.Calculator;
import com.calculator.service.CalculatorService;
import com.calculator.service.SolutionFormatter;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@WebMvcTest(controllers = {CalculatorController.class, CalculatorService.class})
@ExtendWith(SpringExtension.class)
public class CalculatorControllerSIT {

   @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SolutionFormatter solutionFormatter;

    @MockBean
    private Calculator calculator;

    @Test
    public void givenAUser_whenRequestIsMadeToAdd_thenASolutionSouldBeShown() throws Exception {
       //GIVEN
        when(calculator.add(2,3)).thenReturn(5);
        //WHEN
        final MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/calculator")
                    .param("leftArgument", "2")
                    .param("rightArgument", "3")
                    .param("calculationType", "ADDITION"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        //THEN
        assertThat(result.getResponse().getContentAsString())
                .contains("id=\"solution\"")
                .contains(">5</span");
        verify(calculator).add(2, 3);
        verify(solutionFormatter).format(5);
    }
}
