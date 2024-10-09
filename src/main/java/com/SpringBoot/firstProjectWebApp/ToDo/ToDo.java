package com.SpringBoot.firstProjectWebApp.ToDo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Size;

//static list of todo=>(h2,mysql)
//i make it table in db
@Entity
public class ToDo {
	@Id
	@GeneratedValue
	//i make an primary key and generate values about it
	private int id;
	
	private String userName;
    @Size(min = 10, message = "Enter at least 10 characters")
	private String describtion;
	private LocalDate targetDate;
	private boolean done;
	public ToDo() {}
	public ToDo(int id, String userName, String describtion, LocalDate targetData, boolean done) {
		super();
		this.id = id;
		this.userName = userName;
		this.describtion = describtion;
		this.targetDate = targetData;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDescribtion() {
		return describtion;
	}
	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetData) {
		this.targetDate = targetData;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", userName=" + userName + ", describtion=" + describtion + ", targetData="
				+ targetDate + ", done=" + done + "]";
	}
	
	
	
}
