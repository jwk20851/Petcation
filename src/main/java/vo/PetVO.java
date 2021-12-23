package vo;

public class PetVO {
	private String pet_Num;
	private String user_Id;
	private String pet_Kind;
	private String pet_Name;
	private int pet_Age;
	private String pet_Breed;
	private String pet_Gender;
	private float pet_Weight;
	private String pet_Disease;
	private String pet_Infodetail;
	private String pet_Filename;

	public String getPet_Num() {
		return pet_Num;
	}

	public void setPet_Num(String pet_Num) {
		this.pet_Num = pet_Num;
	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	public String getPet_Kind() {
		return pet_Kind;
	}

	public void setPet_Kind(String pet_Kind) {
		this.pet_Kind = pet_Kind;
	}

	public String getPet_Name() {
		return pet_Name;
	}

	public void setPet_Name(String pet_Name) {
		this.pet_Name = pet_Name;
	}

	public int getPet_Age() {
		return pet_Age;
	}

	public void setPet_Age(int pet_Age) {
		this.pet_Age = pet_Age;
	}

	public String getPet_Breed() {
		return pet_Breed;
	}

	public void setPet_Breed(String pet_Breed) {
		this.pet_Breed = pet_Breed;
	}

	public String getPet_Gender() {
		return pet_Gender;
	}

	public void setPet_Gender(String pet_Gender) {
		this.pet_Gender = pet_Gender;
	}

	public float getPet_Weight() {
		return pet_Weight;
	}

	public void setPet_Weight(float pet_Weight) {
		this.pet_Weight = pet_Weight;
	}

	public String getPet_Disease() {
		return pet_Disease;
	}

	public void setPet_Disease(String pet_Disease) {
		this.pet_Disease = pet_Disease;
	}

	public String getPet_Infodetail() {
		return pet_Infodetail;
	}

	public void setPet_Infodetail(String pet_Infodetail) {
		this.pet_Infodetail = pet_Infodetail;
	}

	public String getPet_Filename() {
		return pet_Filename;
	}

	public void setPet_Filename(String pet_Filename) {
		this.pet_Filename = pet_Filename;
	}
	
	@Override
	public String toString() {
		return "pet_Name: " + pet_Name + ", pet_Infodetail: " + pet_Infodetail + ", pet_Filename: " + pet_Filename;
	}
}
