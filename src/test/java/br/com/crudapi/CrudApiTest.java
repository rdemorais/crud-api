package br.com.crudapi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.crudapi.list.Column;
import br.com.crudapi.list.Row;

@ContextConfiguration("/META-INF/app-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CrudApiTest {

	@Autowired
	private CRUDRegister crudRegister;
	
	@Autowired
	private CrudListManager crudListManager;

	private EmbeddedDatabase db;

	@Before
	public void setUp() {
		db = new EmbeddedDatabaseBuilder()
		.setType(EmbeddedDatabaseType.HSQL)
		.addScript("db/create-db.sql")
		.addScript("db/insert-db.sql")
		.build();
	}

	@Test
	public void testCrudApi() throws ClassNotFoundException, InterruptedException {
		Class<?> crud1 = crudRegister.lookupCrud("crud1");
		
		assertEquals(crud1.getCanonicalName(), "br.com.crudapi.CrudTest");
		
		List<Column> cols = crudListManager.extractColumnsFromCrud(crud1);
		
		List<Row> rows = crudListManager.loadRows(crud1, cols, 0, 0);
		
		System.out.println(rows);
		
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:dataSource", "--user", "sa", "--password", "" });
		
		//Thread.sleep(10000);
	}

	@After
	public void tearDown() {
		db.shutdown();
	}
}