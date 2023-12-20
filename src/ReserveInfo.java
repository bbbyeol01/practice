public class ReserveInfo {
	static int count = 0;
	private int code = ++count;
	private String name;
	private String phone;
	private String reserveNumber;
	private int party;
	private int payment;
	private Room reserveRoom = null;
	private User user;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReserveNumber() {
		return reserveNumber;
	}

	public void setReserveNumber(String reserveNumber) {
		this.reserveNumber = reserveNumber;
	}

	public int getParty() {
		return party;
	}

	public void setParty(int party) {
		this.party = party;
	}

	public Room getReserveRoom() {
		return reserveRoom;
	}

	public void setReserveRoom(Room reserveRoom) {
		this.reserveRoom = reserveRoom;
	}

	@Override
	public String toString() {
		return "[예약자명] " + name + "\n" + "[연락처] " + phone + "\n" + "[예약번호] " + reserveNumber + "\n" + "[예약인원] " + party
				+ "\n" + "[지불금액] " + payment + "\n" + "[예약 방 정보] " + reserveRoom;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
