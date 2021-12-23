
public class docclass {
	private String nameandsurname;
	private String mail;
	private char[] sifre;
	private String alan;
	public docclass(String nameandsurname, String mail, char[] sifre, String alan) {
		super();
		this.nameandsurname = nameandsurname;
	
		this.mail = mail;
		this.sifre = sifre;
		this.alan = alan;
	}
	public String getNameandsurname() {
		return nameandsurname;
	}
	public void setNameandsurname(String nameandsurname) {
		this.nameandsurname = nameandsurname;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public char[] getSifre() {
		return sifre;
	}
	public void setSifre(char[] sifre) {
		this.sifre = sifre;
	}
	public String getAlan() {
		return alan;
	}
	public void setAlan(String alan) {
		this.alan = alan;
	}
	
	

}
