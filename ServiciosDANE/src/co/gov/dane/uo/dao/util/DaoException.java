package co.gov.dane.uo.dao.util;

/**
*
* @author <a href="mailto:dgomez@vortexbird.com">Diego A Gomez</a>
* @project zathuracode
* @class DaoException
* @date Nov 01, 2013
*
*/
public class DaoException extends Exception {
   private static final long serialVersionUID = 1L;

   public DaoException() {
       super();
   }

   public DaoException(String message, Throwable cause) {
       super(message, cause);
   }

   public DaoException(String message) {
       super(message);
   }

   public DaoException(Throwable cause) {
       super(cause);
   }
}

