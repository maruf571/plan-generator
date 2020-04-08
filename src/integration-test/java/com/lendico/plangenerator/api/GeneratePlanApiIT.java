package com.lendico.plangenerator.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lendico.plangenerator.dto.RepaymentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Calendar;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class GeneratePlanApiIT {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void should_post_payload_and_get_response() throws Exception {
        // Given
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 0, 1);

        RepaymentDto repaymentDto = new RepaymentDto();
        repaymentDto.setDuration(24);
        repaymentDto.setLoanAmount(BigDecimal.valueOf(5000));
        repaymentDto.setNominalRate(BigDecimal.valueOf(5.00));
        repaymentDto.setStartDate(calendar.getTime());


        // Then
         this.mockMvc.perform(post(GeneratePlanApi.GENERATE_PLAN_API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getObjectAsString(repaymentDto))
         )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.planList").isNotEmpty())
                .andExpect(jsonPath("$.planList[0].borrowerPaymentAmount").value (219.36))
                .andExpect(jsonPath("$.planList[0].initialOutstandingPrincipal").value (5000))
                .andExpect(jsonPath("$.planList[0].interest").value (20.83))
                .andExpect(jsonPath("$.planList[0].principal").value (198.53))
                .andExpect(jsonPath("$.planList[0].remainingOutstandingPrincipal").value (4801.47))

                 .andExpect(jsonPath("$.planList[1].borrowerPaymentAmount").value (219.36))
                 .andExpect(jsonPath("$.planList[1].initialOutstandingPrincipal").value (4801.47))
                 .andExpect(jsonPath("$.planList[1].interest").value (20.01))
                 .andExpect(jsonPath("$.planList[1].principal").value (199.35))
                 .andExpect(jsonPath("$.planList[1].remainingOutstandingPrincipal").value (4602.12))
          ;

    }

    private String getObjectAsString(Object o)throws Exception{
        return objectMapper.writeValueAsString(o);
    }
}
