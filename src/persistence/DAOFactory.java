package persistence;

import persistence.dao.CameraDAO;
import persistence.dao.PrenotazioneHotelDAO;
import persistence.dao.HotelDAO;
import persistence.dao.PrenotazioneVoloDAO;
import persistence.dao.RecensioneDAO;
import persistence.dao.UtenteDAO;
import persistence.dao.VoloDAO;

public abstract class DAOFactory {

	// --- List of supported DAO types ---

	/**
	 * Numeric constant '1' corresponds to explicit MySQL choice
	 */
	public static final int MYSQL = 1;
	
	/**
	 * Numeric constant '2' corresponds to explicit Postgres choice
	 */
	public static final int POSTGRESQL = 2;
	
	
	// --- Actual factory method ---
	
	/**
	 * Depending on the input parameter
	 * this method returns one out of several possible 
	 * implementations of this factory spec 
	 */
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch ( whichFactory ) {
		
		case MYSQL:
			return null;//new HsqldbDAOFactory();
		case POSTGRESQL:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}
	
	
	
	// --- Factory specification: concrete factories implementing this spec must provide this methods! ---
	
	/**
	 * Method to obtain a DATA ACCESS OBJECT
	 * for the datatype 'Utente'
	 */
	public abstract UtenteDAO getUtenteDAO();
	
	public abstract RecensioneDAO getRecensioneDAO();
	
	public abstract VoloDAO getVoloDAO();
	
	public abstract CameraDAO getCameraDAO();
	
	public abstract HotelDAO getHotelDAO();
	
	public abstract PrenotazioneVoloDAO getPrenotazioneVoloDAO();
	
	public abstract PrenotazioneHotelDAO getPrenotazioneHotelDAO();

}
