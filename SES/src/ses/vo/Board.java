package ses.vo;

public class Board {
	
	private int boardNum;
	private String id;
	private String name;
	private String content;
	private String indate;
	
	public Board() {}

	public Board(String id, String name, String content) {
		
		this.id = id;
		this.name = name;
		this.content = content;
	}
	

	
	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ID : " + id + "\n이름: " + name + "\n내용 : " + content;
	}
	
	
	
	
	
	
}
