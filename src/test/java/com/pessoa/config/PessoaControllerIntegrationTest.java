package com.pessoa.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.pessoa.Application;
import com.pessoa.model.Pessoa;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PessoaControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllPessoas() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/pessoa", HttpMethod.GET, entity,
				String.class);
		assertNotNull(response.getBody());
	}
	
    @Test
    public void testGetPessoaById() {
        Pessoa pessoa = restTemplate.getForObject(getRootUrl() + "/pessoa/1", Pessoa.class);
        System.out.println(pessoa.getNome());
        assertNotNull(pessoa);
    }
    
    @Test
    public void testCreatePessoa() {
    	Pessoa pessoa = new Pessoa();
    	pessoa.setNome("Gabriel Vilela");
    	pessoa.setRg("331.335.356-X");
    	pessoa.setCpf("740.815.84");
    	pessoa.setDtnascimento("14/03/2984");
    	pessoa.setAtivo(true);
    	
    	
        ResponseEntity<Pessoa> postResponse = restTemplate.postForEntity(getRootUrl() + "/pessoa", pessoa, Pessoa.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }
    
    @Test
    public void testUpdateEmployee() {
        int id = 1;
        Pessoa pessoa = restTemplate.getForObject(getRootUrl() + "/pessoa/" + id, Pessoa.class);
        pessoa.setNome("Gabriel Vilela da Silva");
    	pessoa.setRg("331.222.333-X");
    	pessoa.setCpf("740.775.88");
        
        restTemplate.put(getRootUrl() + "/pessoa/" + id, pessoa);
        Pessoa updatedEmployee = restTemplate.getForObject(getRootUrl() + "/pessoa/" + id, Pessoa.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteEmployee() {
         int id = 1;
         Pessoa pessoa = restTemplate.getForObject(getRootUrl() + "/pessoa/" + id, Pessoa.class);
         assertNotNull(pessoa);
         restTemplate.delete(getRootUrl() + "/pessoa/" + id);
         try {
        	 pessoa = restTemplate.getForObject(getRootUrl() + "/pessoa/" + id, Pessoa.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }


}
