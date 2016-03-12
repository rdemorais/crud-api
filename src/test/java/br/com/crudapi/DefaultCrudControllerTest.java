package br.com.crudapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration("/META-INF/app-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DefaultCrudControllerTest {
	
	private MockMvc mockMvc;
	
	private String jsonToCreate = "{\"nome\":\"nome codigo\",\"endereco\":\"endereco do codigo\"}";
	private String jsonToUpdate = "{\"nome\":\"nome up\"}";
	
	@Autowired
	WebApplicationContext wac;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testBlankForm() throws Exception {
		mockMvc.perform(get("/crud/new/{idCrud}", "crud1"));
	}
	
	@Test
	public void testList() throws Exception {
		mockMvc.perform(get("/crud/list/{idCrud}/{offset}/{max}", "crud1", 0, 0));
	}
	
	@Test
	public void testCreate() throws Exception{
		mockMvc.perform(post("/crud/create/{idCrud}", "crud1")
				.contentType(MediaType.APPLICATION_JSON).content(jsonToCreate));
	}
	
	@Test
	public void testUpdate() throws Exception{
		mockMvc.perform(post("/crud/update/{idCrud}/{pk}", "crud1", new Long(1))
				.contentType(MediaType.APPLICATION_JSON).content(jsonToUpdate));
	}
	
	//@Test
	public void testDelete() throws Exception{
		mockMvc.perform(post("/crud/delete/{idCrud}/{id}", "crud1", 32768L));
	}
	
	@Test
	public void testLoad() throws Exception{
		mockMvc.perform(post("/crud/load/{idCrud}/{id}", "crud1", 1L));
	}
}
