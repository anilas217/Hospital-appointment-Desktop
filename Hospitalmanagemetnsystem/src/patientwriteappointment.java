
public class patientwriteappointment {
private String docname;
private String docmail;
private String patientname;
private String patientTC;
private String patienthours;

public patientwriteappointment(String docname, String docmail, String patientname, String patientTC,
		String patienthours) {
	super();
	this.docname = docname;
	this.docmail = docmail;
	this.patientname = patientname;
	this.patientTC = patientTC;
	this.patienthours = patienthours;
}
public String getDocname() {
	return docname;
}
public void setDocname(String docname) {
	this.docname = docname;
}
public String getDocmail() {
	return docmail;
}
public void setDocmail(String docmail) {
	this.docmail = docmail;
}
public String getPatientname() {
	return patientname;
}
public void setPatientname(String patientname) {
	this.patientname = patientname;
}
public String getPatientTC() {
	return patientTC;
}
public void setPatientTC(String patientTC) {
	this.patientTC = patientTC;
}
public String getPatienthours() {
	return patienthours;
}
public void setPatienthours(String patienthours) {
	this.patienthours = patienthours;
}

}
