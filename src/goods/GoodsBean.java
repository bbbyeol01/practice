	/*
	 * 	gid int AI PK 
		gname varchar(45) 
		gcontent varchar(200) 
		gcnt int 
		getc varchar(45)
	 */

	package goods;

public class GoodsBean {
	private int gid;
	private String gname;
	private String gcontent;
	private int gcnt;
	private String getc;
	
	public GoodsBean() {
		super();
	}
	
	public GoodsBean(String gname, String gcontent, int gcnt, String getc) {
		super();
		this.gname = gname;
		this.gcontent = gcontent;
		this.gcnt = gcnt;
		this.getc = getc;
	}

	public GoodsBean(int gid, String gname, String gcontent, int gcnt, String getc) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gcontent = gcontent;
		this.gcnt = gcnt;
		this.getc = getc;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGcontent() {
		return gcontent;
	}

	public void setGcontent(String gcontent) {
		this.gcontent = gcontent;
	}

	public int getGcnt() {
		return gcnt;
	}

	public void setGcnt(int gcnt) {
		this.gcnt = gcnt;
	}

	public String getGetc() {
		return getc;
	}

	public void setGetc(String getc) {
		this.getc = getc;
	}

	@Override
	public String toString() {
//		return "GoodsBean [gid=" + gid + ", gname=" + gname + ", gcontent=" + gcontent + ", gcnt=" + gcnt + ", getc="
//				+ getc + "]";
		
		return "[코드] " + gid + "  [이름] " + gname + "  [설명] " + gcontent + "  [수량] " + gcnt + "  [비고] " + getc;
	}
	
	
	
	
}
