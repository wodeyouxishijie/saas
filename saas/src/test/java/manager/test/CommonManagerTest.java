package manager.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doorcii.saas.domains.Result;
import com.doorcii.saas.manager.CommonManager;

public class CommonManagerTest {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-*.xml"); 
	
	@Test
	public void testCommonManager() {
		CommonManager cm = (CommonManager)this.getBean("commonManager");
		Result<List<Map<String, String>>> result = cm.invokeProcedureList("GET_RESERVE_CATEGORY_BY_DATE1", new String[]{"2013-05-06"});
		System.out.println(result.getValue());
		System.out.println(result.getErrorMsg());
	}
	
	public Object getBean(String date) {
		return context.getBean(date);
	}
}
