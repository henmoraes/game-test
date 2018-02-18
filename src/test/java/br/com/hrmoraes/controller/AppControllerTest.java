package br.com.hrmoraes.controller;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {

	@Autowired
    private MockMvc mvc;

    @Test
    public void testDeveraCriarUmCrime() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/novo-crime").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        
        mvc.perform(MockMvcRequestBuilders.get("/crime").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(not("Ainda não há crime ! ")));
    }
    
    @Test
    public void testDeveraValidarCrimeIncorreto() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/novo-crime").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        
        ResultActions action = mvc.perform(MockMvcRequestBuilders
                .request(HttpMethod.POST, "/validar-teoria-crime")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"arma\":{	\"id\":0 }, \"local\":{\"id\":10},\"suspeito\":{\"id\":2}}"));
        		
        action.andExpect(status().isBadRequest())
        .andExpect(content().string(containsString("incorret")));
    }
    
    private String getId(String content, int q) {
    	String ret = "";
    	for(int i=0; i < q; i++) {
	    	int ind = content.indexOf(":");
	    	int ind2 = content.indexOf("-");
	    	ret = content.substring(ind+1, ind2);
	    	content = content.substring(ind2+1);
    	}
    	return ret.trim();
    }
    
    @Test
    public void testDeveraValidarCrimeCorreto() throws Exception {
    	ResultActions action = mvc.perform(MockMvcRequestBuilders.post("/novo-crime").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        
    	String retorno = action.andReturn().getResponse().getContentAsString();
    	
    	String idArma = getId(retorno,1);
    	String idLocal = getId(retorno,2);
    	String idSuspeito = getId(retorno,3);
    	
        action = mvc.perform(MockMvcRequestBuilders
                .request(HttpMethod.POST, "/validar-teoria-crime")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"arma\":{	\"id\":" + idArma + " }, \"local\":{\"id\":" + idLocal + "},\"suspeito\":{\"id\":" + idSuspeito + "}}"));
        		
        action.andExpect(status().isOk())
        .andExpect(content().string(equalTo("Parabéns, você resolveu o crime !")));
    }

}
