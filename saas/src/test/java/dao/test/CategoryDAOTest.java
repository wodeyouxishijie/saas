package dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doorcii.saas.daos.CategoryDAO;
import com.doorcii.saas.domains.CategoryDO;

public class CategoryDAOTest {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-*.xml"); 
	
	@Test
	public void testQueryCategoryByDate() throws Exception {
		CategoryDAO categoryDAO = (CategoryDAO)this.getBean("categoryDAO");
		List<CategoryDO> categoryList = categoryDAO.queryCategoryList("2014-06-15");
		System.out.println(categoryList);
	}
	
	public Object getBean(String date) {
		return context.getBean(date);
	}
	
}
