package com.otm.core.model;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "mail")
public class MailDetail implements Serializable
	{

	@Transient
	private Map<String, Object> model;
    	@Id
		@Column(name = "MAILID")
    	@GeneratedValue(strategy = GenerationType.AUTO)
		private long mailId;

		@Column(name = "USERID")
		private long userId;

		@Column(name = "USERNAME", nullable = false)
		private String userName;

		@Column(name = "MESSAGE")
		private String msg;

		@Column(name = "TOMailId")
		private String to;

		@Column(name = "SEND")
		private boolean send;

		/*@Column(name = "FROM")
	    private String from;
	    */
		@Column(name = "SUBJECT")
	    private String subject;
	    
		
		public String getTo()
			{
				return to;
			}

		public void setTo(String to)
			{
				this.to = to;
			}

		public long getMailId()
			{
				return mailId;
			}

		public void setMailId(long mailId)
			{
				this.mailId = mailId;
			}

		public long getUserId()
			{
				return userId;
			}

		public void setUserId(long userId)
			{
				this.userId = userId;
			}

		public String getUserName()
			{
				return userName;
			}

		public void setUserName(String userName)
			{
				this.userName = userName;
			}

		public String getMsg()
			{
				return msg;
			}

		public void setMsg(String msg)
			{
				this.msg = msg;
			}

		public boolean isSend()
			{
				return send;
			}

		public void setSend(boolean send)
			{
				this.send = send;
			}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public Map<String, Object> getModel() {
			return model;
		}

		public void setModel(Map<String, Object> model) {
			this.model = model;
		}

		@Override
		public String toString()
			{
				StringBuffer strBuff = new StringBuffer();

				strBuff.append(" Name : ").append(getMsg());

				return strBuff.toString();
			}
	}
