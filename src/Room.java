// RoomBean, RoomVO/RoomDTO/RoomEntity
public class Room {
	private static int count = 0;
	private final int number;
	private String name;
	private boolean status = false;
	private int price;
	private int party;
	private int maxParty;
	private int partyExtraCharge;
	private int roomNumber;

	RoomType type;

	enum RoomType {
		SINGLE("싱글룸"), TWIN("트윈룸"), DOUBLE("더블룸"), SUITE("스위트룸"), STUDIO("스튜디오룸");

		private final String name;

		RoomType(String name) {
			this.name = name;
		}

		public String getValue() {
			return name;
		}

	}

	public String getType() {
		return this.type.getValue();
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public Room() {
		this.number = ++count;
	}

	public Room(RoomType type, int roomNumber, String name, int price, int party, int maxParty, int partyExtraCharge) {
		this();
		this.type = type;
		this.roomNumber = roomNumber;
		this.name = name;
		this.price = price;
		this.party = party;
		this.maxParty = maxParty;
		this.partyExtraCharge = partyExtraCharge;
	}

//	public void setNumber(int number) {
//		this.number = number;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isReserved() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getParty() {
		return party;
	}

	public void setParty(int party) {
		this.party = party;
	}

	public int getMaxParty() {
		return maxParty;
	}

	public void setMaxParty(int maxParty) {
		this.maxParty = maxParty;
	}

	public int getPartyExtraCharge() {
		return partyExtraCharge;
	}

	public void setPartyExtraCharge(int partyExtraCharge) {
		this.partyExtraCharge = partyExtraCharge;
	}

	@Override
	public String toString() {
		return "[코드] " + number + ", [호실] " + roomNumber + ", [타입] " + type + ",  [이름] " + name + ",  [예약 여부] " + status
				+ ",  [가격] " + price + ",  [기본 인원] " + party + ",  [최대 인원] " + maxParty + ",  [추가 금액] "
				+ partyExtraCharge;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
}
