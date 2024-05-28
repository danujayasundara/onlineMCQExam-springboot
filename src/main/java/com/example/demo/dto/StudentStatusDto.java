package com.example.demo.dto;

public class StudentStatusDto {
	
	private String fullname;
    private boolean status;
    
	public StudentStatusDto(String fullname, boolean status) {
		super();
		this.fullname = fullname;
		this.status = status;
	}
	
	public StudentStatusDto() {
		// TODO Auto-generated constructor stub
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
    public String toString() {
        return "StudentStatusDto{" +
                "fullname=" + fullname +
                ", status=" + status +
                '}';
    }
}
