import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;

import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.springmvc.BusinessLogic;


public class purchaseTest {

	@Test
	public void testAfterPurchaseInventory(){
		BusinessLogic bl = new BusinessLogic();
		ProductDAO dao = new ProductDAO();
		try {
		bl.updateInventory("Snickers", 5, "email@email.com");
		
		
			assertTrue(dao.read(3).getStockAmount()==25);
		} catch (StorableNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
