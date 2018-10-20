package com.otm.core.model.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Status implements Serializable {

	private String user;
	private String eMail;
	private String status;

	public String getUser() {
		return user;
	}

	public String geteMail() {
		return eMail;
	}

	public String getStatus() {
		return status;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("Mail Status[User=%d, EMail='%s', Status='%s']", user, eMail,status);
	}
}