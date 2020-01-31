import com.vincewang.pojo.Books;
import com.vincewang.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    @Test
    public void tets1(){
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService=(BookService)classPathXmlApplicationContext.getBean("BookServiceImpl");
        for(Books books:bookService.queryAllBook()){
            System.out.println(books);
        }
    }
}
