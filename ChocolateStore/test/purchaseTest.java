import static org.junit.Assert.*;

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
		
		bl.updateInventory("Snickers", 50);
		
		try {
			assertTrue(dao.read(3).getStockAmount()==50);
		} catch (StorableNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
