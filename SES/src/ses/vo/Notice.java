package ses.vo;

public class Notice {
	
	private int noticeNum;
	private String content;
	
	public Notice() {}
	
	public Notice(int noticeNum, String content) {
		
		this.noticeNum = noticeNum;
		this.content = content;
	}

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notice [noticeNum=" + noticeNum + ", content=" + content + "]";
	}
	
	

}
