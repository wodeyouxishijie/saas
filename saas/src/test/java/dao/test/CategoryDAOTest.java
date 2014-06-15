package dao.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doorcii.saas.daos.CommonDAO;

public class CategoryDAOTest {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-*.xml"); 
	
	
	@Test
	public void testQueryCommentDAO() throws Exception {
		CommonDAO commentDAO = (CommonDAO)this.getBean("commonDAO");
		commentDAO.executeReturnList("GET_RESERVE_CATEGORY_BY_DATE", new String[]{"2014-03-15"});
	}
	
	public Object getBean(String date) {
		return context.getBean(date);
	}
	
}
