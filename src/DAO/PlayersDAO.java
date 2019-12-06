package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Players;

public interface PlayersDAO {
	public ArrayList<Players> retrieveAll() throws ClassNotFoundException, SQLException;
}
