
public class Patientcls {
 private String nameansur;
 private String tc;
 private char[] passwrd;
public Patientcls(String nameansur, String tc, char[] passwrd) {
	
	this.nameansur = nameansur;
	this.tc = tc;
	this.passwrd = passwrd;
}
public String getNameansur() {
	return nameansur;
}
public void setNameansur(String nameansur) {
	this.nameansur = nameansur;
}
public String getTc() {
	return tc;
}
public void setTc(String tc) {
	this.tc = tc;
}
public char[] getPasswrd() {
	return passwrd;
}
public void setPasswrd(char[] passwrd) {
	this.passwrd = passwrd;
}
 
}
