package board;

public class BoardJoinDto {
	private String title;
	private String content;
	private int hit;
	private String regdate;
	private String userid;
	private String username;
	private String email;
	public BoardJoinDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardJoinDto(String title, String content, int hit, String regdate, String userid, String username,
			String email) {
		super();
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regdate = regdate;
		this.userid = userid;
		this.username = username;
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
