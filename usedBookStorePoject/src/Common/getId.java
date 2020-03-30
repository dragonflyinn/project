package Common;

	import java.sql.Connection;
	import dao.UserDAO;
	import static db.JdbcUtil.*;

	public class getId {

		public String getIdBySerial(int user_serial_number) throws Exception{
			// TODO Auto-generated method stub
			
			Connection con = getConnection();
			UserDAO userDAO = UserDAO.getInstance();
			userDAO.setConnection(con);
			String ID = userDAO.findUserBySerial(user_serial_number);
			
			close(con);
			return ID;
			
		}

	}