package dto;

public class Players {
	
	private int id;
	private String name;
	private String team;
	private String status;
	
	public Players(int id, String name, String team, String status) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Players() {
		
	}

}
