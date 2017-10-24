
public class notice {
private String _id;
private String summary;
private String email;
private Boolean resolved;

public notice()
{
	_id ="";
	summary = "";
	email = "";
	resolved = false;
}

public notice(String _id,String summary,String email,Boolean resolved)
{
	this._id = _id;
	this.summary =summary;
	this.email = email;
	this.resolved = resolved;
}

public String getID() {
	return _id;
}

public void setID(String _id) {
	this._id = _id;
}

public String getSummary() {
	return summary;
}

public void setSummary(String summary) {
	
	this.summary = summary;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Boolean getResolved() {
	return resolved;
}

public void setResolved(Boolean resolved) {

	this.resolved = resolved;
}



}
